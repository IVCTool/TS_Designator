// This file was generated by the TNO Bean Generator.
// Any modifications to this file will be lost upon re-generation.
// Generated on: 2020/03/27 12:19:05

package nl.tno.rpr.objects;

import nl.tno.rpr.datatypes.BreachableSegmentStruct;

/** A linear object that can be breached. */
public class BreachableLinearObject extends LinearObject {

  /** Specifies a breachable linear object */
  BreachableSegmentStruct[] SegmentRecords;

  public BreachableSegmentStruct[] getSegmentRecords() {
    return this.SegmentRecords;
  }

  public void setSegmentRecords(BreachableSegmentStruct[] SegmentRecords) {
    this.SegmentRecords = SegmentRecords;
  }
}