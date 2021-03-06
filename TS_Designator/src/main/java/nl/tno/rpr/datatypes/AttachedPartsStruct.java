// This file was generated by the TNO Bean Generator.
// Any modifications to this file will be lost upon re-generation.
// Generated on: 2020/03/27 12:19:05

package nl.tno.rpr.datatypes;

/** Structure to represent removable parts that may be attached to an entity. */
public class AttachedPartsStruct {

  /** Identification of the location (or station) to which the part is attached. */
  StationEnum32 Station;

  /** The entity type of the attached part. */
  EntityTypeStruct StoreType;

  public StationEnum32 getStation() {
    return this.Station;
  }

  public void setStation(StationEnum32 Station) {
    this.Station = Station;
  }

  public EntityTypeStruct getStoreType() {
    return this.StoreType;
  }

  public void setStoreType(EntityTypeStruct StoreType) {
    this.StoreType = StoreType;
  }
}
