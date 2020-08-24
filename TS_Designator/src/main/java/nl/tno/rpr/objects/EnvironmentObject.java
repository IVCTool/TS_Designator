// This file was generated by the TNO Bean Generator.
// Any modifications to this file will be lost upon re-generation.
// Generated on: 2020/03/27 12:19:05

package nl.tno.rpr.objects;

import nl.tno.rpr.datatypes.EntityIdentifierStruct;
import nl.tno.rpr.datatypes.EnvironmentObjectTypeStruct;
import nl.tno.rpr.datatypes.ForceIdentifierEnum8;

/** A base class of environment point, linear, or areal object classes. */
public class EnvironmentObject {

  /** Identifies this EnvironmentObject instance (point, linear or areal) */
  EntityIdentifierStruct ObjectIdentifier;

  /**
   * Identifies the Synthetic Environment object instance to which this EnvironmentObject instance
   * is associated
   */
  String ReferencedObjectIdentifier;

  /** Identifies the force that created or modified this EnvironmentObject instance */
  ForceIdentifierEnum8 ForceIdentifier;

  /** Identifies the type of this EnvironmentObject instance */
  EnvironmentObjectTypeStruct ObjectType;

  public EntityIdentifierStruct getObjectIdentifier() {
    return this.ObjectIdentifier;
  }

  public void setObjectIdentifier(EntityIdentifierStruct ObjectIdentifier) {
    this.ObjectIdentifier = ObjectIdentifier;
  }

  public String getReferencedObjectIdentifier() {
    return this.ReferencedObjectIdentifier;
  }

  public void setReferencedObjectIdentifier(String ReferencedObjectIdentifier) {
    this.ReferencedObjectIdentifier = ReferencedObjectIdentifier;
  }

  public ForceIdentifierEnum8 getForceIdentifier() {
    return this.ForceIdentifier;
  }

  public void setForceIdentifier(ForceIdentifierEnum8 ForceIdentifier) {
    this.ForceIdentifier = ForceIdentifier;
  }

  public EnvironmentObjectTypeStruct getObjectType() {
    return this.ObjectType;
  }

  public void setObjectType(EnvironmentObjectTypeStruct ObjectType) {
    this.ObjectType = ObjectType;
  }
}
