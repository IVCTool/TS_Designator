// This file was generated by the TNO Bean Generator.
// Any modifications to this file will be lost upon re-generation.
// Generated on: 2020/03/27 12:19:05

package nl.tno.rpr.interactions;

import nl.tno.rpr.datatypes.BreachableSegmentStruct;

/**
 * An interaction sent to an environment manager to request the creation, modification, or deletion
 * of instances of the BreachableLinearObject class.
 */
public class BreachableLinearObjectTransaction extends LinearObjectTransaction {

  /** Specifies a breachable linear object */
  BreachableSegmentStruct[] SegmentRecords;

  public BreachableSegmentStruct[] getSegmentRecords() {
    return this.SegmentRecords;
  }

  public void setSegmentRecords(BreachableSegmentStruct[] SegmentRecords) {
    this.SegmentRecords = SegmentRecords;
  }
}
