// This file was generated by the TNO Bean Generator.
// Any modifications to this file will be lost upon re-generation.
// Generated on: 2020/03/27 12:19:05

package nl.tno.rpr.datatypes;

/** Articulated part type metric */
public enum ArticulatedTypeMetricEnum32 {
  Position(1),
  PositionRate(2),
  Extension(3),
  ExtensionRate(4),
  X(5),
  XRate(6),
  Y(7),
  YRate(8),
  Z(9),
  ZRate(10),
  Azimuth(11),
  AzimuthRate(12),
  Elevation(13),
  ElevationRate(14),
  Rotation(15),
  RotationRate(16);

  private final int value;

  private ArticulatedTypeMetricEnum32(int value) {
    this.value = value;
  }

  public int getValue() {
    return value;
  }
}
