// This file was generated by the TNO Bean Generator.
// Any modifications to this file will be lost upon re-generation.
// Generated on: 2020/03/27 12:19:05

package nl.tno.rpr.datatypes;

/** Defines the spatial relationship between two objects. */
public class IsPartOfStruct {

  /** The identifier of the entity of which the object is a constituent part. */
  EntityIdentifierStruct HostEntityIdentifier;

  /** The RTI instance identifier of the object of which this object is a constituent part. */
  String HostRTIObjectIdentifier;

  /** The relationship of the constituent part object to its host object. */
  ConstituentPartRelationshipStruct Relationship;

  /**
   * The discrete positional relationship of the constituent part object with respect to its host
   * object.
   */
  NamedLocationStruct NamedLocation;

  public EntityIdentifierStruct getHostEntityIdentifier() {
    return this.HostEntityIdentifier;
  }

  public void setHostEntityIdentifier(EntityIdentifierStruct HostEntityIdentifier) {
    this.HostEntityIdentifier = HostEntityIdentifier;
  }

  public String getHostRTIObjectIdentifier() {
    return this.HostRTIObjectIdentifier;
  }

  public void setHostRTIObjectIdentifier(String HostRTIObjectIdentifier) {
    this.HostRTIObjectIdentifier = HostRTIObjectIdentifier;
  }

  public ConstituentPartRelationshipStruct getRelationship() {
    return this.Relationship;
  }

  public void setRelationship(ConstituentPartRelationshipStruct Relationship) {
    this.Relationship = Relationship;
  }

  public NamedLocationStruct getNamedLocation() {
    return this.NamedLocation;
  }

  public void setNamedLocation(NamedLocationStruct NamedLocation) {
    this.NamedLocation = NamedLocation;
  }
}
