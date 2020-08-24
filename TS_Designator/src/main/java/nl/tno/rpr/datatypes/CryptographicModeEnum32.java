// This file was generated by the TNO Bean Generator.
// Any modifications to this file will be lost upon re-generation.
// Generated on: 2020/03/27 12:19:05

package nl.tno.rpr.datatypes;

/** Represents the encryption mode of a cryptographic system. */
public enum CryptographicModeEnum32 {
  BasebandEncryption(0),
  DiphaseEncryption(1);

  private final int value;

  private CryptographicModeEnum32(int value) {
    this.value = value;
  }

  public int getValue() {
    return value;
  }
}