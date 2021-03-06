// This file was generated by the TNO Bean Generator.
// Any modifications to this file will be lost upon re-generation.
// Generated on: 2020/03/27 12:19:05

package nl.tno.rpr.datatypes;

/**
 * The station name at which the constituent part is located. In case of 'On Station', the
 * alternative specifies its location relative to the host object.
 */
public class StationNameLocationVariantStruct {

  /** Discriminant */
  ConstituentPartStationNameEnum16 StationName;

  /**
   * The location of the constituent part object relative to the host object entity coordinate
   * system.
   */
  RelativePositionStruct RelativeLocation;

  /**
   * The location of the constituent part object relative to the host object in polar coordinates.
   */
  RelativeRangeBearingStruct RelativeRangeAndBearing;

  public ConstituentPartStationNameEnum16 getStationName() {
    return this.StationName;
  }

  public void setStationName(ConstituentPartStationNameEnum16 StationName) {
    this.StationName = StationName;
  }

  public RelativePositionStruct getRelativeLocation() {
    return this.RelativeLocation;
  }

  public void setRelativeLocation(RelativePositionStruct RelativeLocation) {
    this.RelativeLocation = RelativeLocation;
  }

  public RelativeRangeBearingStruct getRelativeRangeAndBearing() {
    return this.RelativeRangeAndBearing;
  }

  public void setRelativeRangeAndBearing(RelativeRangeBearingStruct RelativeRangeAndBearing) {
    this.RelativeRangeAndBearing = RelativeRangeAndBearing;
  }
}
