// This file was generated by the TNO Bean Generator.
// Any modifications to this file will be lost upon re-generation.
// Generated on: 2020/03/27 12:19:05

package nl.tno.rpr.datatypes;

/**
 * Structure to specify a movable or attached part of an entity. Based on the Articulation Parameter
 * record as specified in IEEE 1278.1-1995 section 5.2.5.
 *
 * <p>Note that usage of this datatype for the PhyscialEntity object class attribute
 * ArticulatedParametersArray and MunitionDetonation interaction class parameter ArticulatedPartData
 * shall be in accordance with IEEE 1278.1-1995 Annex A.
 */
public class ArticulatedParameterStruct {

  /**
   * Indicator of a change to the part. This field shall be set to zero for each exercise and
   * sequentially incremented by one for each change in articulation parameters. In the case where
   * all possible values are exhausted, the numbers shall be reused beginning at zero.
   */
  byte ArticulatedParameterChange;

  /**
   * Identification of the articulated part to which this articulation parameter is attached. This
   * field shall contain the value zero if the articulated part is attached directly to the entity.
   */
  short PartAttachedTo;

  /**
   * Details of the parameter: whether it is an articulated or an attached part, and its type and
   * value.
   */
  ParameterValueVariantStruct ParameterValue;

  public byte getArticulatedParameterChange() {
    return this.ArticulatedParameterChange;
  }

  public void setArticulatedParameterChange(byte ArticulatedParameterChange) {
    this.ArticulatedParameterChange = ArticulatedParameterChange;
  }

  public short getPartAttachedTo() {
    return this.PartAttachedTo;
  }

  public void setPartAttachedTo(short PartAttachedTo) {
    this.PartAttachedTo = PartAttachedTo;
  }

  public ParameterValueVariantStruct getParameterValue() {
    return this.ParameterValue;
  }

  public void setParameterValue(ParameterValueVariantStruct ParameterValue) {
    this.ParameterValue = ParameterValue;
  }
}
