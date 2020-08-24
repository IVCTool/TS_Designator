// This file was generated by the TNO Bean Generator.
// Any modifications to this file will be lost upon re-generation.
// Generated on: 2020/03/27 12:19:05

package nl.tno.rpr.datatypes;

/** Radio input source */
public enum RadioInputSourceEnum8 {
  Other((byte) 0),
  Pilot((byte) 1),
  Copilot((byte) 2),
  FirstOfficer((byte) 3),
  Driver((byte) 4),
  Loader((byte) 5),
  Gunner((byte) 6),
  Commander((byte) 7),
  DigitalDataDevice((byte) 8),
  Intercom((byte) 9),
  AudioJammer((byte) 10),
  DataJammer((byte) 11),
  GPSJammer((byte) 12),
  GPSMeaconer((byte) 13);

  private final byte value;

  private RadioInputSourceEnum8(byte value) {
    this.value = value;
  }

  public byte getValue() {
    return value;
  }
}
