// This file was generated by the TNO Bean Generator.
// Any modifications to this file will be lost upon re-generation.
// Generated on: 2020/03/27 12:19:05

package nl.tno.rpr.datatypes;

/** Standard Boolean type used for 8-bit compatibility. */
public enum RPRboolean {
  False((byte) 0),
  True((byte) 1);

  private final byte value;

  private RPRboolean(byte value) {
    this.value = value;
  }

  public byte getValue() {
    return value;
  }
}
