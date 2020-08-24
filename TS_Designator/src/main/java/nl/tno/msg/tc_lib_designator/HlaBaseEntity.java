/*
Copyright 2020, Rein (TNO MSG)

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
*/

package nl.tno.msg.tc_lib_designator;

import hla.rti1516e.AttributeHandle;
import hla.rti1516e.AttributeHandleSet;
import hla.rti1516e.AttributeHandleValueMap;
import hla.rti1516e.ObjectClassHandle;
import hla.rti1516e.ObjectInstanceHandle;
import hla.rti1516e.RTIambassador;
import hla.rti1516e.encoding.EncoderFactory;
import hla.rti1516e.exceptions.AttributeNotDefined;
import hla.rti1516e.exceptions.AttributeNotOwned;
import hla.rti1516e.exceptions.FederateNotExecutionMember;
import hla.rti1516e.exceptions.InvalidObjectClassHandle;
import hla.rti1516e.exceptions.NameNotFound;
import hla.rti1516e.exceptions.NotConnected;
import hla.rti1516e.exceptions.ObjectClassNotDefined;
import hla.rti1516e.exceptions.ObjectClassNotPublished;
import hla.rti1516e.exceptions.ObjectInstanceNameInUse;
import hla.rti1516e.exceptions.ObjectInstanceNameNotReserved;
import hla.rti1516e.exceptions.ObjectInstanceNotKnown;
import hla.rti1516e.exceptions.RTIinternalError;
import hla.rti1516e.exceptions.RestoreInProgress;
import hla.rti1516e.exceptions.SaveInProgress;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import nl.tno.rpr.objects.BaseEntity;
import nl.tno.rpr.datatypes.*;
import omtcodec.DataElementCodec;
import omtcodec.OMTcodecFactory;
import org.slf4j.Logger;

/**
 * HlaBaseEntity
 * 
 * This class extends class BaseEntity. Class BaseEntity only contains the attributes with setters and getters.
 * This class adds the following:
 *     - it defines for every attribute the properties:
 *           - name
 *           - if the attribute is static (should be set only once) or not
 *           - if it is mandatory to set the attribute (error if not set)
 *           - if it is mandatory to set the attribute (warning if not set)
 *     - subscribe and publish methods
 *     - encoding and decoding of the attributes
 *     - method newInstance creates a deep copy of an instance of this class
 *     - it keeps track of the state of each attribute:
 *           - dirty (set locally, but not yet sent out to other federates)
 *           - time of last update
 *           - updated in last reflect
 *
 * @author Rein (TNO MSG)
 */
public class HlaBaseEntity extends BaseEntity {
	public static class AttributeInfo {
		String name;
		boolean isStatic;
		boolean mandatory;
		boolean mandatoryWarningOnly; // indicating: attribute is optional, but should preferably be set
		public AttributeInfo(String name, boolean isStatic, boolean mandatory, boolean mandatoryWarningOnly) {
			this.name = name;
			this.isStatic = isStatic;
			this.mandatory = mandatory;
			this.mandatoryWarningOnly = mandatoryWarningOnly;
		}
	}
	private static Map<AttributeHandle, AttributeInfo> staticAttributeInfo = new HashMap<AttributeHandle, AttributeInfo>();

	public static String  getAttrName                (AttributeHandle hAttr) { return staticAttributeInfo.get(hAttr).name; }
	public static boolean getAttrStatic              (AttributeHandle hAttr) { return staticAttributeInfo.get(hAttr).isStatic; }
	public static boolean getAttrMandatory           (AttributeHandle hAttr) { return staticAttributeInfo.get(hAttr).mandatory; }
	public static boolean getAttrMandatoryWarningOnly(AttributeHandle hAttr) { return staticAttributeInfo.get(hAttr).mandatoryWarningOnly; }

	private static boolean            hasBeenInitialised = false;
	private static Logger             logger = null;
	@SuppressWarnings("unused") // encoderFactory is not used; declared here because of keeping HlaBaseEntity and HlaDesignator as equal as possible
	private static EncoderFactory     encoderFactory = null;
	private static OMTcodecFactory    omtFactory = null;
	private static ObjectClassHandle  classId = null; public static ObjectClassHandle getClassId() { return classId; }
	private static String             className = "HlaBaseEntity"; public static String getClassName() { return className; }
	private static String             classNameFromFOM = "BaseEntity";

	private static AttributeHandleSet attributeHandleSet                      = null; public static AttributeHandleSet getAttrHandleSet()                      { return attributeHandleSet; }
	private static AttributeHandle    attributeIdEntityIdentifier             = null; public static AttributeHandle    getAttrIdEntityIdentifier()             { return attributeIdEntityIdentifier; }

	private final Map<AttributeHandle, Long   > attributeUpdateTime       = new ConcurrentHashMap<AttributeHandle, Long   >();
	private final Map<AttributeHandle, Boolean> attributeSetInLastReflect = new ConcurrentHashMap<AttributeHandle, Boolean>();
	private final Map<AttributeHandle, Boolean> attributeDirty            = new ConcurrentHashMap<AttributeHandle, Boolean>();

	private ObjectInstanceHandle      objectId = null;
	private String                    objectName = "";
	private long                      timeOfCreation = -1;
	private long                      timeOfRemoval = -1;
	private boolean                   inhibitSettingDirty = false;
	private boolean                   enableSettingAttributeSetInLastReflect = false;

	public HlaBaseEntity() {
		this(null);
	}

	public HlaBaseEntity(ObjectInstanceHandle theObject) {
		objectId = theObject;

		// Initialize entity id
		EntityIdentifierStruct entityId = new EntityIdentifierStruct();
		entityId.setFederateIdentifier(new FederateIdentifierStruct());
		super.setEntityIdentifier(entityId);

		if (attributeHandleSet != null) {
			for (AttributeHandle hAttr : attributeHandleSet) {
				attributeUpdateTime.put(hAttr, new Long(-1));
				attributeSetInLastReflect.put(hAttr, new Boolean(false));
				attributeDirty.put(hAttr, new Boolean(false));
			}
		}
	}

	// Create a new instance (deep copy)
	public HlaBaseEntity newInstance() {
		HlaBaseEntity dst = new HlaBaseEntity();

		EntityIdentifierStruct dstEntityId = new EntityIdentifierStruct();
		dstEntityId.setFederateIdentifier(new FederateIdentifierStruct());
		dstEntityId.getFederateIdentifier().setSiteID(this.getEntityIdentifier().getFederateIdentifier().getSiteID());
		dstEntityId.getFederateIdentifier().setApplicationID(this.getEntityIdentifier().getFederateIdentifier().getApplicationID());
		dstEntityId.setEntityNumber(this.getEntityIdentifier().getEntityNumber());
		dst.setEntityIdentifier(dstEntityId);

		dst.objectId = this.objectId;
		dst.inhibitSettingDirty = this.inhibitSettingDirty;
		dst.objectName = this.objectName;

		for (Map.Entry<AttributeHandle, Long> entry : this.attributeUpdateTime.entrySet())
			dst.attributeUpdateTime.put(entry.getKey(), entry.getValue());
		for (Map.Entry<AttributeHandle, Boolean> entry : this.attributeSetInLastReflect.entrySet())
			dst.attributeSetInLastReflect.put(entry.getKey(), entry.getValue());
		for (Map.Entry<AttributeHandle, Boolean> entry : this.attributeDirty.entrySet())
			dst.attributeDirty.put(entry.getKey(), entry.getValue());

		return dst;
	}

	public String getObjectName() { return objectName; }
	public void   setObjectName(String objectName) { this.objectName = objectName; }

	public long getTimeOfCreation()       { return timeOfCreation; }
	public void setTimeOfCreation(long t) { timeOfCreation = t; }

	public long    getTimeOfRemoval()       { return timeOfRemoval; }
	public void    setTimeOfRemoval(long t) { timeOfRemoval = t; }
	public boolean isRemoved()              { return timeOfRemoval >= 0; }

	public long getAttrTime(AttributeHandle hAttr) { return attributeUpdateTime.get(hAttr).longValue(); }

	public boolean getAttrSetInLastReflect(AttributeHandle hAttr) { return attributeSetInLastReflect.get(hAttr).booleanValue(); }

	public boolean attrHasBeenSet(AttributeHandle hAttr) { return (getAttrTime(hAttr) >= 0); }

	/**
     * @return true if at least one attribute has been set, otherwise false
     * If none of the attributes has a value, apparently object has been discovered, but no attributes have been reflected yet
     */
    public boolean atLeastOneAttributeHasBeenSet() {
        for (Map.Entry<AttributeHandle, Long> entry : attributeUpdateTime.entrySet()) {
            if (entry.getValue() >= 0) {
                return true;
            }
        }
        return false;
    }

	private static AttributeHandle addAttribute(RTIambassador ivct_rti, String attributeName,
			boolean attributeIsStatic, boolean mandatory, boolean mandatoryWarningOnly) {
		AttributeHandle hAttr = null;
		try {
			hAttr = ivct_rti.getAttributeHandle(classId, attributeName);
		} catch (NameNotFound | InvalidObjectClassHandle | FederateNotExecutionMember | NotConnected
				| RTIinternalError e) {
			logger.error("{} - error getting attribute handle of {} - {}", getClassName(), attributeName, e.toString());
			hAttr = null;
		}
		attributeHandleSet.add(hAttr);
		staticAttributeInfo.put(hAttr, new AttributeInfo(attributeName, attributeIsStatic, mandatory, mandatoryWarningOnly));
		logger.debug("{} {}", hAttr, attributeName);
		return hAttr;
	}

	/**
	 * @param logger_ logger
	 * @param ivct_rti rti ambassador
	 * @param encoderFactory_ encoder factory
	 * @param omtFactory_ omt codec factory
	 * @return true if ok, otherwise false
	 */
	public static boolean init(Logger logger_, RTIambassador ivct_rti, final EncoderFactory encoderFactory_, final OMTcodecFactory omtFactory_) {
		/* Do NOT check (with hasBeenInitialised) if this method has been executed before.
		 * Reason: running with another federate than before, gives other attribute handle id's.
		 * So attributeHandleSet (with all attribute handles) has to be initialized again.
		 */

		// Useful for unit tests without rti etc
		if (logger_ == null)
			return true;

		logger = logger_;
		encoderFactory = encoderFactory_;
		omtFactory = omtFactory_;

		// Get object class id
		try {
			classId = ivct_rti.getObjectClassHandle(classNameFromFOM);
		} catch (NameNotFound | FederateNotExecutionMember | NotConnected | RTIinternalError e) {
			logger.error("{} - error getting {} class handle", getClassName(), classNameFromFOM);
			return false;
		}

		// Create attribute handle set; get attribute id's, add them to attribute handle set
		// For every attribute: set static (i.e. static in the RPR-FOM) to true or false; set mandatory to true or false; set mandatoryWarningOnly to true or false
		try {
			attributeHandleSet = ivct_rti.getAttributeHandleSetFactory().create();
		} catch (FederateNotExecutionMember | NotConnected e) {
			logger.error("{} - error creating attribute handle set", getClassName());
			return false;
		}
		attributeIdEntityIdentifier             = addAttribute(ivct_rti, "EntityIdentifier"            , true , true , false);
		logger.debug("attributeHandleSet: {} entries: {}", attributeHandleSet.size(), attributeHandleSet);

		// Check if "null" entry in attributeHandleSet
		for (AttributeHandle hAttr : attributeHandleSet) {
			if (hAttr == null) {
				logger.error("{} - error getting attribute handle", getClassName());
				return false;
			}
		}

		hasBeenInitialised = true;
		return true;
	}

    /**
     * @param ivct_rti rti ambassador
     * @return true if ok, otherwise false
     */
	public static boolean publish(RTIambassador ivct_rti) {
		try {
			ivct_rti.publishObjectClassAttributes(classId, attributeHandleSet);
		} catch (AttributeNotDefined | ObjectClassNotDefined | SaveInProgress | RestoreInProgress
				| FederateNotExecutionMember | NotConnected | RTIinternalError e) {
			logger.error("{} - error publishing - {}", getClassName(), e.toString());
			return false;
		}
		return true;
	}

    /**
     * @param ivct_rti rti ambassador
     * @return true if ok, otherwise false
     */
	public static boolean subscribe(RTIambassador ivct_rti) {
		try {
			ivct_rti.subscribeObjectClassAttributes(classId, attributeHandleSet);
		} catch (AttributeNotDefined | ObjectClassNotDefined | SaveInProgress | RestoreInProgress
				| FederateNotExecutionMember | NotConnected | RTIinternalError e) {
			logger.error("{} - error subscribing - {}", getClassName(), e.toString());
			return false;
		}
		return true;
	}

    /**
     * @param ivct_rti rti ambassador
     * @return true if ok, otherwise false
     */
	public static boolean requestAttributeValueUpdate(RTIambassador ivct_rti) {
		try {
			// Provoke reflectAttributeValues to be called
			ivct_rti.requestAttributeValueUpdate(getClassId(), attributeHandleSet, null);
		} catch (AttributeNotDefined | SaveInProgress | RestoreInProgress
				| FederateNotExecutionMember | NotConnected | RTIinternalError | ObjectClassNotDefined e) {
			logger.error("{} - error in calling requestAttributeValueUpdate - {}", getClassName(), e.toString());
			return false;
		}
		return true;
	}

    /**
     * @param ivct_rti rti ambassador
     * @param objectName name of the object
     * @return true if decoding ok, otherwise false
     */
	public boolean registerObject(RTIambassador ivct_rti, String objectName) {
		// Register object instance
		try {
			objectId = ivct_rti.registerObjectInstance(classId, objectName);
		} catch (ObjectInstanceNameInUse | ObjectInstanceNameNotReserved | ObjectClassNotPublished | ObjectClassNotDefined
				| SaveInProgress | RestoreInProgress | FederateNotExecutionMember | NotConnected | RTIinternalError e) {
			return false;
		}
		return true;
	}

	public ObjectInstanceHandle getObjectId() {
		return objectId;
	}

    /**
     * @param theAttributes the attributes and their values
     * @return true if decoding ok, otherwise false
     */
	public boolean reflectAttributeValues(AttributeHandleValueMap theAttributes) {
		// Reset attributeSetInLastReflect
		for (AttributeHandle hAttr : attributeHandleSet) {
			attributeSetInLastReflect.put(hAttr, new Boolean(false));
		}

		boolean decodingOk = true;
		inhibitSettingDirty = true;
		enableSettingAttributeSetInLastReflect = true;
		for (AttributeHandleValueMap.Entry<AttributeHandle,byte[]> theAttribute : theAttributes.entrySet()) {
			AttributeHandle hAttr = theAttribute.getKey();
			String attributeName = staticAttributeInfo.get(hAttr).name;

			if (hAttr.equals(attributeIdEntityIdentifier)) {
				try {
					DataElementCodec codec = omtFactory.createDataElementCodec(EntityIdentifierStruct.class, "EntityIdentifierStruct");
					final EntityIdentifierStruct value = (EntityIdentifierStruct) codec.decode(theAttribute.getValue());
					setEntityIdentifier(value);
					FederateIdentifierStruct federateId = value.getFederateIdentifier();
					logger.debug("{}: {}:{}:{}", attributeName, federateId.getSiteID(),
							federateId.getApplicationID(), value.getEntityNumber());
				} catch (Exception e) {
					logger.error("BaseEntity {} - failed to decode attribute {} - {}", getObjectName(), attributeName, e.toString());
					decodingOk = false;
				}
			} else {
				logger.error("{} - not yet implemented attribute handle: {}", getClassName(), hAttr.toString());
				decodingOk = false;
			}
		}
		inhibitSettingDirty = false;
		enableSettingAttributeSetInLastReflect = false;
		return decodingOk;
	}

	private void updateAttributeDirtyAndAttributeTimeAndAttributeSetInLastReflect(AttributeHandle hAttr) {
		if (logger == null)
			return;
		if (!inhibitSettingDirty) {
			this.attributeDirty.put(hAttr, new Boolean(true));
		}
		if (enableSettingAttributeSetInLastReflect) {
			this.attributeSetInLastReflect.put(hAttr, new Boolean(true));
		}
		this.attributeUpdateTime.put(hAttr, new Long(System.currentTimeMillis()));
	}

	// Override all set-methods, in order to:
	//     warn if same value set again
	//     maintain maps of attribute dirty and attribute time
	@Override
	public void setEntityIdentifier(EntityIdentifierStruct value) {
		AttributeHandle hAttr = attributeIdEntityIdentifier;
		if (attrHasBeenSet(hAttr)
				&& value.getFederateIdentifier().getSiteID() == getEntityIdentifier().getFederateIdentifier().getSiteID()
				&& value.getFederateIdentifier().getApplicationID() == getEntityIdentifier().getFederateIdentifier().getApplicationID()
				&& value.getEntityNumber() == getEntityIdentifier().getEntityNumber()) {
			logger.debug("BaseEntity {} - attribute {} has been set again with the same value as before", getObjectName(), getAttrName(hAttr));
			return;
		}
		super.setEntityIdentifier(value);
		updateAttributeDirtyAndAttributeTimeAndAttributeSetInLastReflect(hAttr);
	}

    /**
     * @param ivct_rti rti ambassador
     * @return true if encoding ok, otherwise false
     */
	public boolean updateAttributeValuesToRti(RTIambassador ivct_rti) {
		return this.updateAttributeValuesToRti(ivct_rti, attributeHandleSet, true);
	}

    /**
     * @param ivct_rti rti ambassador
     * @param theAttributesToBeProvided the attributes that should be sent to the rti
     * @param updateDirtyAttributeOnly only send attributes that are in dirty state (i.e. have been set, but not yet sent)
     * @return true if encoding ok, otherwise false
     */
	public boolean updateAttributeValuesToRti(RTIambassador ivct_rti, AttributeHandleSet theAttributesToBeProvided, boolean updateDirtyAttributeOnly) {
		logger.debug("{} attributes should be updated to rti", theAttributesToBeProvided.size());

		// Check if has been initialised
		if (!hasBeenInitialised ) {
			logger.error("{} has not yet been initialised", getClassName());
			return false;
		}

		// Prepare a map of attributes to be sent
		AttributeHandleValueMap attributes = null;
		try {
			attributes = ivct_rti.getAttributeHandleValueMapFactory().create(0);
		} catch (FederateNotExecutionMember | NotConnected e) {
			logger.error("{} - error creating attribute handle value map - {}", getClassName(), e.toString());
			return false;
		}

		// Populate the map of attributes to be sent
		boolean encodingOk = true;
		for (AttributeHandle hAttr : theAttributesToBeProvided) {
			if (!attrHasBeenSet(hAttr)) {
				logger.debug("Attribute {} does not have a value, so ignoring this attribute", hAttr);
				continue;
			}
			logger.debug("Attribute {} has to be provided", hAttr);
			if (!updateDirtyAttributeOnly || attributeDirty.get(hAttr).booleanValue()) {
				if (updateDirtyAttributeOnly) {
					attributeDirty.put(hAttr, new Boolean(false));
				}
				String attributeName = staticAttributeInfo.get(hAttr).name;

				if (hAttr.equals(attributeIdEntityIdentifier)) {
					try {
						DataElementCodec codec = omtFactory.createDataElementCodec(EntityIdentifierStruct.class, "EntityIdentifierStruct");
						byte [] byteArray = codec.encode(this.getEntityIdentifier());
						attributes.put(hAttr, byteArray);
						logger.debug("{}: {}", attributeName, this.getEntityIdentifier());
					} catch (Exception e) {
						logger.error("BaseEntity {} - failed to encode attribute {} - {}", getObjectName(), attributeName, e.toString());
						encodingOk = false;
					}
				} else {
					logger.error("not yet implemented attribute handle: {}", hAttr.toString());
					encodingOk = false;
				}
			}
		}

		// Set the attributes update times
		if (attributes != null) {
			long t = System.currentTimeMillis();
			for (Map.Entry<AttributeHandle, byte[]> entry : attributes.entrySet()) {
				attributeUpdateTime.put(entry.getKey(), new Long(t));
			}
		}

		// Send the attributes value updates to rti
		if (attributes != null && attributes.size() > 0) {
			logger.debug("Going to call {}::updateAttributeValues with {} attributes", getClassName(), attributes.size());
			try {
				ivct_rti.updateAttributeValues(objectId, attributes, null);
			} catch (AttributeNotOwned | AttributeNotDefined | ObjectInstanceNotKnown | SaveInProgress | RestoreInProgress
					| FederateNotExecutionMember | NotConnected | RTIinternalError e) {
				logger.error("{} - error in updateAttributeValues - {}", getClassName(), e.toString());
				encodingOk = false;
			}
		}

		return encodingOk;
	}
}