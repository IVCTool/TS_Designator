// This file was generated by the TNO Bean Generator.
// Any modifications to this file will be lost upon re-generation.
// Generated on: 2020/03/27 12:19:05

package nl.tno.rpr.datatypes;

/** Character set used in the marking and the string of characters to be interpreted for display. */
public class MarkingStruct {

  /** Character set representation. */
  MarkingEncodingEnum8 MarkingEncodingType;

  /** 11 element character string */
  byte[] MarkingData;

  public MarkingEncodingEnum8 getMarkingEncodingType() {
    return this.MarkingEncodingType;
  }

  public void setMarkingEncodingType(MarkingEncodingEnum8 MarkingEncodingType) {
    this.MarkingEncodingType = MarkingEncodingType;
  }

  public byte[] getMarkingData() {
    return this.MarkingData;
  }

  public void setMarkingData(byte[] MarkingData) {
    this.MarkingData = MarkingData;
  }
}
