// This file was generated by the TNO Bean Generator.
// Any modifications to this file will be lost upon re-generation.
// Generated on: 2020/03/27 12:19:05

package nl.tno.rpr.datatypes;

/** Beam function */
public enum BeamFunctionCodeEnum8 {
  Other((byte) 0),
  Search((byte) 1),
  HeightFinder((byte) 2),
  Acquisition((byte) 3),
  Tracking((byte) 4),
  AcquisitionAndTracking((byte) 5),
  CommandGuidance((byte) 6),
  Illumination((byte) 7),
  RangeOnlyRadar((byte) 8),
  MissileBeacon((byte) 9),
  MissileFuze((byte) 10),
  ActiveRadarMissileSeeker((byte) 11),
  Jammer((byte) 12),
  IFF((byte) 13),
  NavigationalOrWeather((byte) 14),
  Meteorological((byte) 15),
  DataTransmission((byte) 16),
  NavigationalDirectionalBeacon((byte) 17),
  Time__SharedSearch((byte) 20),
  Time__SharedAcquisition((byte) 21),
  Time__SharedTrack((byte) 22),
  Time__SharedCommandGuidance((byte) 23),
  Time__SharedIllumination((byte) 24),
  Time__SharedJamming((byte) 25);

  private final byte value;

  private BeamFunctionCodeEnum8(byte value) {
    this.value = value;
  }

  public byte getValue() {
    return value;
  }
}
