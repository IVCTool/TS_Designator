// This file was generated by the TNO Bean Generator.
// Any modifications to this file will be lost upon re-generation.
// Generated on: 2020/03/27 12:19:05

package nl.tno.rpr.datatypes;

/** Detailed modulation types for Angle Modulation */
public enum AngleModulationTypeEnum16 {
  Other((short) 0),
  FrequencyModulation((short) 1),
  FrequencyShiftKeying((short) 2),
  PhaseModulation((short) 3);

  private final short value;

  private AngleModulationTypeEnum16(short value) {
    this.value = value;
  }

  public short getValue() {
    return value;
  }
}
