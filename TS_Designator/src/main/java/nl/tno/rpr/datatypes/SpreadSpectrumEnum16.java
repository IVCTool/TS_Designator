// This file was generated by the TNO Bean Generator.
// Any modifications to this file will be lost upon re-generation.
// Generated on: 2020/03/27 12:19:05

package nl.tno.rpr.datatypes;

/** The type of spread spectrum characteristics employed by a transmitter. */
public enum SpreadSpectrumEnum16 {
  None((short) 0),
  SINCGARSFrequencyHop((short) 1);

  private final short value;

  private SpreadSpectrumEnum16(short value) {
    this.value = value;
  }

  public short getValue() {
    return value;
  }
}
