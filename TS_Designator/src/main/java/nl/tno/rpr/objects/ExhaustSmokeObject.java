// This file was generated by the TNO Bean Generator.
// Any modifications to this file will be lost upon re-generation.
// Generated on: 2020/03/27 12:19:05

package nl.tno.rpr.objects;

import nl.tno.rpr.datatypes.ExhaustSmokeStruct;

/** An exhaust smoke linear object. */
public class ExhaustSmokeObject extends LinearObject {

  /** Specifies an exhaust smoke linear object */
  ExhaustSmokeStruct[] SegmentRecords;

  public ExhaustSmokeStruct[] getSegmentRecords() {
    return this.SegmentRecords;
  }

  public void setSegmentRecords(ExhaustSmokeStruct[] SegmentRecords) {
    this.SegmentRecords = SegmentRecords;
  }
}
