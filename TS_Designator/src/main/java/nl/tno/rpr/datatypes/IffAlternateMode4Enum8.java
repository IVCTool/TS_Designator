// This file was generated by the TNO Bean Generator.
// Any modifications to this file will be lost upon re-generation.
// Generated on: 2020/03/27 12:19:05

package nl.tno.rpr.datatypes;

/** IFF alternate mode 4 */
public enum IffAlternateMode4Enum8 {
  Other((byte) 0),
  Valid((byte) 1),
  Invalid((byte) 2),
  NoResponse((byte) 3),
  UnableToVerify((byte) 4);

  private final byte value;

  private IffAlternateMode4Enum8(byte value) {
    this.value = value;
  }

  public byte getValue() {
    return value;
  }
}
