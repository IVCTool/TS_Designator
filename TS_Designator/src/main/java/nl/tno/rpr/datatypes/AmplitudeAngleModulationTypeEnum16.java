// This file was generated by the TNO Bean Generator.
// Any modifications to this file will be lost upon re-generation.
// Generated on: 2020/03/27 12:19:05

package nl.tno.rpr.datatypes;

/** Detailed modulation types for Amplitude and Angle Modulation */
public enum AmplitudeAngleModulationTypeEnum16 {
  Other((short) 0),
  AmplitudeAndAngle((short) 1);

  private final short value;

  private AmplitudeAngleModulationTypeEnum16(short value) {
    this.value = value;
  }

  public short getValue() {
    return value;
  }
}