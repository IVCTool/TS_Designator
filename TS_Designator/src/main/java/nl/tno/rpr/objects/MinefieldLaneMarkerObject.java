// This file was generated by the TNO Bean Generator.
// Any modifications to this file will be lost upon re-generation.
// Generated on: 2020/03/27 12:19:05

package nl.tno.rpr.objects;

import nl.tno.rpr.datatypes.MinefieldLaneMarkerStruct;

/**
 * A minefield lane marker showing a cleared lane through a specific minefield, defined as a linear
 * object.
 */
public class MinefieldLaneMarkerObject extends LinearObject {

  /** Specifies a minefield lane marker showing a cleared lane through a minefield */
  MinefieldLaneMarkerStruct[] SegmentRecords;

  public MinefieldLaneMarkerStruct[] getSegmentRecords() {
    return this.SegmentRecords;
  }

  public void setSegmentRecords(MinefieldLaneMarkerStruct[] SegmentRecords) {
    this.SegmentRecords = SegmentRecords;
  }
}
