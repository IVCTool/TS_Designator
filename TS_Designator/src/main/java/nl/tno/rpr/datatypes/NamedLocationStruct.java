// This file was generated by the TNO Bean Generator.
// Any modifications to this file will be lost upon re-generation.
// Generated on: 2020/03/27 12:19:05

package nl.tno.rpr.datatypes;

/**
 * The discrete positional relationship of the constituent part object with respect to its host
 * object. Based on the specifications in IEEE 1278.1a-1998 of the IsPartOf PDU 'Location of Part'
 * (paragraph 5.3.9.4e) and 'Named Location' (paragraph 5.3.9.4f) fields.
 */
public class NamedLocationStruct {

  /** The number of the particular station at which the constituent part is attached. */
  short StationNumber;

  /** The name of the station where the constituent part is located. */
  StationNameLocationVariantStruct StationName;

  public short getStationNumber() {
    return this.StationNumber;
  }

  public void setStationNumber(short StationNumber) {
    this.StationNumber = StationNumber;
  }

  public StationNameLocationVariantStruct getStationName() {
    return this.StationName;
  }

  public void setStationName(StationNameLocationVariantStruct StationName) {
    this.StationName = StationName;
  }
}
