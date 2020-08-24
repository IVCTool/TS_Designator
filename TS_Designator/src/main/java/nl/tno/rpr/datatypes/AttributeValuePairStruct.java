// This file was generated by the TNO Bean Generator.
// Any modifications to this file will be lost upon re-generation.
// Generated on: 2020/03/27 12:19:05

package nl.tno.rpr.datatypes;

/** Pair of an AttributeHandle identifying an attribute and data for that attribute. */
public class AttributeValuePairStruct {

  /** AttributeHandle identifying attribute. */
  int AttributeHandle;

  /** Value for the specified attribute. */
  byte[] NumberOfBytes__A__Value;

  /** Brings the record length to a 32-bit boundary */
  byte[] PaddingTo32;

  public int getAttributeHandle() {
    return this.AttributeHandle;
  }

  public void setAttributeHandle(int AttributeHandle) {
    this.AttributeHandle = AttributeHandle;
  }

  public byte[] getNumberOfBytes__A__Value() {
    return this.NumberOfBytes__A__Value;
  }

  public void setNumberOfBytes__A__Value(byte[] NumberOfBytes__A__Value) {
    this.NumberOfBytes__A__Value = NumberOfBytes__A__Value;
  }

  public byte[] getPaddingTo32() {
    return this.PaddingTo32;
  }

  public void setPaddingTo32(byte[] PaddingTo32) {
    this.PaddingTo32 = PaddingTo32;
  }
}
