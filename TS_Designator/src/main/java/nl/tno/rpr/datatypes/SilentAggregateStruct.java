// This file was generated by the TNO Bean Generator.
// Any modifications to this file will be lost upon re-generation.
// Generated on: 2020/03/27 12:19:05

package nl.tno.rpr.datatypes;

/** These fields contain information about subaggregates not registered in the federation. */
public class SilentAggregateStruct {

  /** This field shall specify the aggregates common to this system list. */
  EntityTypeStruct AggregateType;

  /**
   * This field shall specify the number of aggregates that have the type specified in AggregateType
   * field.
   */
  short NumberOfAggregatesOfThisType;

  public EntityTypeStruct getAggregateType() {
    return this.AggregateType;
  }

  public void setAggregateType(EntityTypeStruct AggregateType) {
    this.AggregateType = AggregateType;
  }

  public short getNumberOfAggregatesOfThisType() {
    return this.NumberOfAggregatesOfThisType;
  }

  public void setNumberOfAggregatesOfThisType(short NumberOfAggregatesOfThisType) {
    this.NumberOfAggregatesOfThisType = NumberOfAggregatesOfThisType;
  }
}