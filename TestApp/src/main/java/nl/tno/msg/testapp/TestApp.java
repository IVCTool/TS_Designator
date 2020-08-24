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

package nl.tno.msg.testapp;

import hla.rti1516e.AttributeHandleSet;
import hla.rti1516e.CallbackModel;
import hla.rti1516e.NullFederateAmbassador;
import hla.rti1516e.ObjectInstanceHandle;
import hla.rti1516e.RTIambassador;
import hla.rti1516e.ResignAction;
import hla.rti1516e.RtiFactory;
import hla.rti1516e.RtiFactoryFactory;
import hla.rti1516e.encoding.EncoderFactory;
import hla.rti1516e.exceptions.FederatesCurrentlyJoined;
import hla.rti1516e.exceptions.FederationExecutionAlreadyExists;
import hla.rti1516e.exceptions.IllegalName;
import hla.rti1516e.exceptions.RTIexception;
import hla.rti1516e.exceptions.RTIinternalError;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.xml.bind.JAXBException;
import nl.tno.rpr.datatypes.AccelerationVectorStruct;
import nl.tno.rpr.datatypes.DeadReckoningAlgorithmEnum8;
import nl.tno.rpr.datatypes.EntityIdentifierStruct;
import nl.tno.rpr.datatypes.FederateIdentifierStruct;
import nl.tno.rpr.datatypes.RelativePositionStruct;
import nl.tno.rpr.datatypes.WorldLocationStruct;
import nl.tno.msg.tc_lib_designator.HlaBaseEntity;
import nl.tno.msg.tc_lib_designator.DesignatorCodeEnum16_Alternative;
import nl.tno.msg.tc_lib_designator.DesignatorCodeNameEnum16_Alternative;
import nl.tno.msg.tc_lib_designator.HlaDesignator;
import omt.ObjectModelType;
import omt.helpers.OmtFunctions;
import omtcodec.OMTcodecFactory;
import org.slf4j.LoggerFactory;

public class TestApp extends NullFederateAmbassador {
	/*
	 * Command line options for provoking specific (erroneous) behaviour
	 */
	public enum OptionIds {
		provokeDecodingError,
		provokeMissingOptionalAttribute,
		provokeMissingMandatoryAttribute,
		provokeHostEntityIdError,
		provokeHostObjectNameError,
		provokeHostEntityIdAndHostObjectNameReferToDifferentEntities,
		provokeDesignatedObjectError,
		provokeOutputPowerNegative,
		provokeEmissionWavelengthNegative,
		provokeRelSpotLocSetWhileNoDesignatedObject,
		provokeMultipleSettingOfStaticAttribute,
		provokeAttributeUpdatesWhilePowerZero,
		provokeNoRemoval,
		provokePowerNotZeroBeforeRemoval,
		provokeSlowRemovalAfterPowerZero,
		provokeSlowRemovalAfterHostRemoval,
		provokeAccelerationSetWhileDrStatic,
		provokeAccelerationNotSetWhileDrNonStatic,
		provokeDrAlgoNotStaticOrFvw,
		provokeNoDrUpdateOnHeartbeat,
		provokeIllegalDrPositionExtrapolation;
	}

	public class Option {
		private String  optionNameLong;
		private String  optionNameShort;
		private boolean enabled;

		Option(String optionNameLong, String optionNameShort) {
			this.optionNameLong = optionNameLong;
			this.optionNameShort = optionNameShort;
			this.enabled = false;
		}
	}

	private static final Map<OptionIds, Option> options = new LinkedHashMap<OptionIds, Option>(); // LinkedHashMap preserves order
	private boolean provoke(OptionIds optionId) { return options.get(optionId).enabled; }

    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TestApp.class);

    private String rtiHost = "localhost";
	private String federationName = "MAK-RPR-2.0";
	private String federateName = "TestAppDesignator";
	private int nrOfCycles = 40;

	private RTIambassador rtiAmbassador;
	private EncoderFactory encoderFactory;
	private OMTcodecFactory omtFactory;

	private HlaBaseEntity hostEntity;
	private HlaBaseEntity targetEntity;
	private HlaDesignator designator;
	private final String  hostEntityInstanceName = "hostEntity";
	private final String  targetEntityInstanceName = "targetEntity";
	private final String  designatorInstanceName = "testDesignator";
	private final short   hostEntityNr = 1;
	private final short   targetEntityNr = 2;

	private volatile boolean _reservationComplete;
	private volatile boolean _reservationSucceeded;
	private final Object _reservationSemaphore = new Object();

	private static void logErrorAndExit(String errorMsg, Object... args) {
		logger.error(errorMsg, args);
		System.exit(1);
	}

	public static void main(final String[] args) {
		TestApp testApp = new TestApp(args);
		testApp.run();
		logger.debug("TestApp terminated");
	}

	private TestApp(final String[] args) {
		// Initialize provocation options
		for (OptionIds optionId : OptionIds.values()) {
			// Create optionNameLong from optionId
			String optionNameLong = "-" + optionId.toString();

			// Create optionNameShort from optionNameLong
			String optionNameShort = "-p";
			for (int i = 0; i < optionNameLong.length(); i++)
				if (Character.isUpperCase(optionNameLong.charAt(i)))
					optionNameShort += optionNameLong.charAt(i);

			// Check if no duplicate optionNameShort in options
			for (Map.Entry<OptionIds, Option> tmpEntry : options.entrySet()) {
				Option tmpOption = tmpEntry.getValue();
				if (optionNameShort.equals(tmpOption.optionNameShort))
					logErrorAndExit("Duplicate short option {} for options {} and {}", optionNameShort, optionNameLong, tmpOption.optionNameLong);
			}

			// Store in options
			options.put(optionId, new Option(optionNameLong, optionNameShort));
		}

		// Print help info
		String helpString = "Syntax: TestApp\n"
				+ "    [-rtiHost rtiHost], e.g. -rtiHost localhost or -rtiHost localhost:8989" + ", default: " + rtiHost + "\n"
				+ "    [-federationName federationName]" + ", default: " + federationName + "\n"
				+ "    [-federateName federateName]" + ", default: " + federateName + "\n";
		for (Map.Entry<OptionIds, Option> entry : options.entrySet()) {
			Option option = entry.getValue();
			helpString += String.format("    [%-13s | %s]\n", option.optionNameShort, option.optionNameLong);
		}
		logger.info(helpString);

		// Get command line arguments
		for (int i = 0; i < args.length; i++) {
			if (args[i].equals("-rtiHost")) {
				i++;
				rtiHost = args[i];
			} else if (args[i].equals("-federationName")) {
				i++;
				federationName = args[i];
			} else if (args[i].equals("-federateName")) {
				i++;
				federateName = args[i];
			} else {
				boolean optionRecognized = false;
				for (Map.Entry<OptionIds, Option> entry : options.entrySet()) {
					Option option = entry.getValue();
					if (args[i].equals(option.optionNameShort) || args[i].equals(option.optionNameLong)) {
						option.enabled = true;
						optionRecognized = true;
					}
				}
				if (!optionRecognized)
					logErrorAndExit("Unknown command line argument: {}", args[i]);
			}
		}
	}

	private URL getFom(String fileName) {
		logger.info("Searching for file {}", fileName);
		URL url = this.getClass().getClassLoader().getResource(fileName); // Original comment in HelloWorld: that's only working for pRTI
		if (url != null) {
			logger.info("File {} found", fileName);
			return url;
		} else {
			File f = new File(fileName);
			if (!f.exists()) {
				logger.info("File {} not found at application root, searching in TestApp/bin/", fileName);
				// Original comment in HelloWorld: file not found, likely because started within docker
				f = new File("TestApp/bin/" + fileName);
				if (f.exists()) {
					logger.info("File {} found", fileName);
				} else {
					logErrorAndExit("FOM file {} not found. Application terminated.", fileName);
				}
			}
			try {
				url = f.toURI().toURL();
			} catch (MalformedURLException e) {
				logErrorAndExit("Malformed URL: {}", fileName);
			}
			return url;
		}
	}

	private void reserveObjectInstanceName(String name) {
		do {
			try {
				this._reservationComplete = false;
				this.rtiAmbassador.reserveObjectInstanceName(name);
				synchronized (this._reservationSemaphore) {
					// Wait for response from RTI
					while (!this._reservationComplete) {
						try {
							this._reservationSemaphore.wait();
						} catch (final InterruptedException ignored) {
							logger.warn("InterruptException received and ignored");
						}
					}
				}
				if (!this._reservationSucceeded) {
					logger.info("Name already taken, try again.");
				}
			} catch (final IllegalName e) {
				logger.info("Illegal name. Try again.");
			} catch (final RTIexception e) {
				logger.info("RTI exception when reserving name: {}", e.getMessage());
				return;
			}
		} while (!this._reservationSucceeded);
	}

	/** {@inheritDoc} */
	@Override
	public final void objectInstanceNameReservationSucceeded(final String objectName) {
		synchronized (this._reservationSemaphore) {
			this._reservationComplete = true;
			this._reservationSucceeded = true;
			this._reservationSemaphore.notifyAll();
		}
	}

	/** {@inheritDoc} */
	@Override
	public final void objectInstanceNameReservationFailed(final String objectName) {
		synchronized (this._reservationSemaphore) {
			this._reservationComplete = true;
			this._reservationSucceeded = false;
			this._reservationSemaphore.notifyAll();
		}
	}

	/** {@inheritDoc} */
	@Override
	public final void provideAttributeValueUpdate(final ObjectInstanceHandle theObject,
			final AttributeHandleSet theAttributes, final byte[] userSuppliedTag) {
		if (theObject.equals(hostEntity.getObjectId())) {
			hostEntity.updateAttributeValuesToRti(rtiAmbassador, theAttributes, false);
		} else if (theObject.equals(targetEntity.getObjectId())) {
			targetEntity.updateAttributeValuesToRti(rtiAmbassador, theAttributes, false);
		} else if (theObject.equals(designator.getObjectId())) {
			designator.updateAttributeValuesToRti(rtiAmbassador, theAttributes, false);
		}
	}

	private void run() {
		try {
			// Create rtiAmbassador
			try {
				final RtiFactory rtiFactory = RtiFactoryFactory.getRtiFactory();
				this.rtiAmbassador = rtiFactory.getRtiAmbassador();
			} catch (final Exception e) {
				logger.info(e.getMessage());
				logger.info("Unable to create RTI ambassador");
				return;
			}

			// Connect in immediate mode
			this.rtiAmbassador.connect(this, CallbackModel.HLA_IMMEDIATE, "crcAddress=" + rtiHost);

			// Get FOM and MIM
			URL fddFileUrlFom = getFom("RPR_FOM_v2.0_1516-2010.xml");
			URL fddFileUrlMim = getFom("HLAstandardMIM.xml");

			// Create and join federation
			logger.info("Protocol format: {}", fddFileUrlFom.getProtocol());
			logger.info("FOM Path: {}", fddFileUrlFom.getPath());
			try {
				this.rtiAmbassador.createFederationExecution(this.federationName, new URL[] { fddFileUrlFom }, "HLAfloat64Time");
			} catch (final FederationExecutionAlreadyExists ignored) {
			}

			this.rtiAmbassador.joinFederationExecution(this.federateName, this.federationName, new URL[] { fddFileUrlFom });

			// Create the encoder factory and the OMT codec factory
			try {
				ObjectModelType module = OmtFunctions.readOmt(fddFileUrlFom);
				ObjectModelType mim = OmtFunctions.readOmt(fddFileUrlMim);
				encoderFactory = RtiFactoryFactory.getRtiFactory().getEncoderFactory();
				omtFactory = new OMTcodecFactory(encoderFactory, new ObjectModelType[]{module, mim});
			} catch (IOException | JAXBException | RTIinternalError e) {
				logErrorAndExit("Error in creating encoder factory and OMT codec factory");
			}

			// Initialize HlaBaseEntity; publish some of it's attributes
			if (!HlaBaseEntity.init(logger, rtiAmbassador, encoderFactory, omtFactory))
				logErrorAndExit("Error in initializing HlaBaseEntity");
			if (!HlaBaseEntity.publish(rtiAmbassador))
				logErrorAndExit("Error in publishing HlaDesignator");

			// Initialize federateIdentifier
			FederateIdentifierStruct federateIdentifier = new FederateIdentifierStruct();
			federateIdentifier.setSiteID((short) 25);
			federateIdentifier.setApplicationID((short) 25);

			// Create and register hostEntity object
			reserveObjectInstanceName(hostEntityInstanceName);
			hostEntity = new HlaBaseEntity();
			if (!hostEntity.registerObject(rtiAmbassador, hostEntityInstanceName))
				logger.error("Failed registering object {}", hostEntityInstanceName);

			// Set initial values of hostEntity object
			EntityIdentifierStruct hostEntity_entityIdentifier= new EntityIdentifierStruct();
			hostEntity_entityIdentifier.setFederateIdentifier(federateIdentifier);
			hostEntity_entityIdentifier.setEntityNumber(hostEntityNr);
			hostEntity.setEntityIdentifier(hostEntity_entityIdentifier);
			hostEntity.updateAttributeValuesToRti(this.rtiAmbassador);

			// Create and register targetEntity object
			reserveObjectInstanceName(targetEntityInstanceName);
			targetEntity = new HlaBaseEntity();
			if (!targetEntity.registerObject(rtiAmbassador, targetEntityInstanceName))
				logger.error("Failed registering object {}", targetEntityInstanceName);

			// Set initial values of targetEntity object
			EntityIdentifierStruct targetEntity_entityIdentifier= new EntityIdentifierStruct();
			targetEntity_entityIdentifier.setFederateIdentifier(federateIdentifier);
			targetEntity_entityIdentifier.setEntityNumber(targetEntityNr);
			targetEntity.setEntityIdentifier(targetEntity_entityIdentifier);
			targetEntity.updateAttributeValuesToRti(this.rtiAmbassador);

			// Initialize HlaDesignator; publish all it's attributes
			if (!HlaDesignator.init(logger, rtiAmbassador, encoderFactory, omtFactory))
				logErrorAndExit("Error in initializing HlaDesignator");
			if (!HlaDesignator.publish(rtiAmbassador))
				logErrorAndExit("Error in publishing HlaDesignator");

			// Create and register Designator object
			reserveObjectInstanceName(designatorInstanceName);
			designator = new HlaDesignator();
			if (!designator.registerObject(rtiAmbassador, designatorInstanceName))
				logger.error("Failed registering object {}", designatorInstanceName);

			// Set initial values of Designator object
			EntityIdentifierStruct entityIdentifier= new EntityIdentifierStruct();
			entityIdentifier.setFederateIdentifier(federateIdentifier);
			if (!provoke(OptionIds.provokeHostEntityIdError))
				entityIdentifier.setEntityNumber(hostEntityNr);
			else
				entityIdentifier.setEntityNumber((short) 99);
			designator.setEntityIdentifier(entityIdentifier);
			if (provoke(OptionIds.provokeHostObjectNameError))
				designator.setHostObjectIdentifier("___" + hostEntityInstanceName + "___");
			else if (provoke(OptionIds.provokeHostEntityIdAndHostObjectNameReferToDifferentEntities))
				designator.setHostObjectIdentifier(targetEntityInstanceName);
			else
				designator.setHostObjectIdentifier(hostEntityInstanceName);
			RelativePositionStruct relPos =new RelativePositionStruct();
			relPos.setBodyXDistance((float) 3.0);
			relPos.setBodyYDistance((float) 3.0);
			relPos.setBodyZDistance((float) 3.0);
			designator.setRelativePosition(relPos);
			designator.setCodeName_Alternative(DesignatorCodeNameEnum16_Alternative.Not_Specified);
			if (!provoke(OptionIds.provokeRelSpotLocSetWhileNoDesignatedObject))
				designator.setDesignatedObjectIdentifier(targetEntityInstanceName);
			if (provoke(OptionIds.provokeDecodingError))
				designator.setProvokeErrorInDesignatorCode(true);
			designator.setDesignatorCode_Alternative(DesignatorCodeEnum16_Alternative.Other);
			designator.setDesignatorEmissionWavelength((float) 789.0);
			if (!provoke(OptionIds.provokeMissingMandatoryAttribute) ) {
				designator.setDesignatorOutputPower((float) 123.0);
			}
			WorldLocationStruct worldLoc = new WorldLocationStruct();
			worldLoc.setX(123.0);
			worldLoc.setY(456.0);
			worldLoc.setZ(789.0);
			designator.setDesignatorSpotLocation(worldLoc);
			if (provoke(OptionIds.provokeDrAlgoNotStaticOrFvw))
				designator.setDeadReckoningAlgorithm(DeadReckoningAlgorithmEnum8.DRM_RPB);
			else
				designator.setDeadReckoningAlgorithm(DeadReckoningAlgorithmEnum8.Static);
			if (!provoke(OptionIds.provokeMissingOptionalAttribute)) {
				RelativePositionStruct relPosSpotLocation =new RelativePositionStruct();
				relPosSpotLocation.setBodyXDistance((float) 2.0);
				relPosSpotLocation.setBodyYDistance((float) 2.0);
				relPosSpotLocation.setBodyZDistance((float) 2.0);
				designator.setRelativeSpotLocation(relPosSpotLocation);
			}
			if (!provoke(OptionIds.provokeAccelerationNotSetWhileDrNonStatic)) {
				AccelerationVectorStruct accelerationVector = new AccelerationVectorStruct();
				accelerationVector.setXAcceleration((float) 0.0);
				accelerationVector.setYAcceleration((float) 0.0);
				accelerationVector.setZAcceleration((float) 0.0);
				designator.setSpotLinearAccelerationVector(accelerationVector);
			}

			// Update attribute values to RTI
			designator.updateAttributeValuesToRti(this.rtiAmbassador);

			// Optionally set invalid values of Designator object
			if (provoke(OptionIds.provokeDesignatedObjectError)) {
				designator.setDesignatedObjectIdentifier("___" + targetEntityInstanceName + "___");
			}
			if (provoke(OptionIds.provokeOutputPowerNegative)) {
				designator.setDesignatorOutputPower((float) -1.0);
			}
			if (provoke(OptionIds.provokeEmissionWavelengthNegative)) {
				designator.setDesignatorEmissionWavelength((float) -1.0);
			}

			// Update attribute values to RTI
			designator.updateAttributeValuesToRti(this.rtiAmbassador);

			// Loop for some time, updating some attributes, optionally provoking specific (erroneous) conditions
			for (int i = 1; i <= nrOfCycles; i++) {
				logger.info("cycle {} of {}", i, nrOfCycles);

				if (i == nrOfCycles - 19) {
					if (!provoke(OptionIds.provokeNoDrUpdateOnHeartbeat)) {
						WorldLocationStruct worldLoc2 = new WorldLocationStruct();
						worldLoc2.setX(500.0);
						worldLoc2.setY(456.0);
						worldLoc2.setZ(789.0);
						designator.setDesignatorSpotLocation(worldLoc2);
					}

				} else if (i <= nrOfCycles - 14) {
					designator.setDesignatorEmissionWavelength(designator.getDesignatorEmissionWavelength() + (float) 1.0);

				} else if (i == nrOfCycles -13) {
					if (!provoke(OptionIds.provokeNoDrUpdateOnHeartbeat)) {
						WorldLocationStruct worldLoc2 = new WorldLocationStruct();
						worldLoc2.setX(999.0);
						worldLoc2.setY(456.0);
						worldLoc2.setZ(789.0);
						designator.setDesignatorSpotLocation(worldLoc2);
					}

				} else if (i == nrOfCycles -12) {
					if (provoke(OptionIds.provokeMultipleSettingOfStaticAttribute)) {
						designator.setCodeName_Alternative(DesignatorCodeNameEnum16_Alternative.AN_AAQ_14_LANTIRN);
					}

				} else if (i == nrOfCycles -11 && provoke(OptionIds.provokeAttributeUpdatesWhilePowerZero)) {
					designator.setDesignatorOutputPower(0);

				} else if (i == nrOfCycles -10 && provoke(OptionIds.provokeAttributeUpdatesWhilePowerZero)) {
					designator.setDesignatorEmissionWavelength(designator.getDesignatorEmissionWavelength() + (float) 1.0);

				} else if (i == nrOfCycles -9) {
					designator.setDesignatorOutputPower(5);

				} else if (i == nrOfCycles -8) {
					if (provoke(OptionIds.provokeAccelerationSetWhileDrStatic)) {
						designator.setDeadReckoningAlgorithm(DeadReckoningAlgorithmEnum8.Static);
						AccelerationVectorStruct accel = new AccelerationVectorStruct();
						accel.setXAcceleration((float) 5.0);
						accel.setYAcceleration((float) 5.0);
						accel.setZAcceleration((float) 5.0);
						designator.setSpotLinearAccelerationVector(accel);
					} else if (provoke(OptionIds.provokeAccelerationNotSetWhileDrNonStatic)) {
						designator.setDeadReckoningAlgorithm(DeadReckoningAlgorithmEnum8.DRM_FVW);
					} else {
						designator.setDeadReckoningAlgorithm(DeadReckoningAlgorithmEnum8.DRM_FVW);
						AccelerationVectorStruct accel = new AccelerationVectorStruct();
						accel.setXAcceleration((float) 5.0);
						accel.setYAcceleration((float) 5.0);
						accel.setZAcceleration((float) 5.0);
						designator.setSpotLinearAccelerationVector(accel);
						WorldLocationStruct worldLoc2 = new WorldLocationStruct();
						worldLoc2.setX(100.0);
						worldLoc2.setY(100.0);
						worldLoc2.setZ(100.0);
						designator.setDesignatorSpotLocation(worldLoc2);
						designator.updateAttributeValuesToRti(this.rtiAmbassador);
						Thread.sleep(2000);
						if (provoke(OptionIds.provokeIllegalDrPositionExtrapolation)) {
							worldLoc2 = new WorldLocationStruct();
							worldLoc2.setX(110.5);
							worldLoc2.setY(110.5);
							worldLoc2.setZ(110.5);
							designator.setDesignatorSpotLocation(worldLoc2);
							designator.updateAttributeValuesToRti(this.rtiAmbassador);
						} else {
							worldLoc2 = new WorldLocationStruct();
							worldLoc2.setX(110.7);
							worldLoc2.setY(110.7);
							worldLoc2.setZ(110.7);
							designator.setDesignatorSpotLocation(worldLoc2);
							designator.updateAttributeValuesToRti(this.rtiAmbassador);
						}
					}
				} else if (i == nrOfCycles -7) {
					if (!provoke(OptionIds.provokePowerNotZeroBeforeRemoval) && !provoke(OptionIds.provokeNoRemoval)) {
						designator.setDesignatorOutputPower(0);
						designator.updateAttributeValuesToRti(this.rtiAmbassador);
					}
					Thread.sleep(20); // sleep < 20 => deleteObjectInstance arriving  in the TestSuite BEFORE preceding setDesignatorOutputPower
					if (provoke(OptionIds.provokeSlowRemovalAfterPowerZero))
						Thread.sleep(2000);
					if (provoke(OptionIds.provokeNoRemoval))
						Thread.sleep(300000);
					else
						this.rtiAmbassador.deleteObjectInstance(designator.getObjectId(), null);

				} else if (i == nrOfCycles -2) {
					this.rtiAmbassador.deleteObjectInstance(hostEntity.getObjectId(), null);

				} else if (i == nrOfCycles -1) {
					this.rtiAmbassador.deleteObjectInstance(targetEntity.getObjectId(), null);
				}

				designator.updateAttributeValuesToRti(this.rtiAmbassador);
				Thread.sleep(200);
			}

			// Resign from federation
			logger.debug("Resigning from federation");
			this.rtiAmbassador.resignFederationExecution(ResignAction.DELETE_OBJECTS_THEN_DIVEST);
			try {
				this.rtiAmbassador.destroyFederationExecution(this.federationName);
			} catch (final FederatesCurrentlyJoined ignored) {
			}
			this.rtiAmbassador.disconnect();
			this.rtiAmbassador = null;
		} catch (final Exception e) {
			logger.error("Exception: {}", e.toString());
			try {
				logger.info("Press <ENTER> to shutdown");
				final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
				in.readLine();
			} catch (final IOException ioe) {
			}
		}
	}
}
