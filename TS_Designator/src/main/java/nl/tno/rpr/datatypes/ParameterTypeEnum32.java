// This file was generated by the TNO Bean Generator.
// Any modifications to this file will be lost upon re-generation.
// Generated on: 2020/03/27 12:19:05

package nl.tno.rpr.datatypes;

/** Parameter type */
public enum ParameterTypeEnum32 {
  ArticulatedPart(0),
  AttachedPart(1),
  Separation(2),
  EntityType(3),
  EntityAssociation(4);

  private final int value;

  private ParameterTypeEnum32(int value) {
    this.value = value;
  }

  public int getValue() {
    return value;
  }
}
