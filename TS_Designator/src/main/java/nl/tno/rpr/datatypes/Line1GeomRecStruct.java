// This file was generated by the TNO Bean Generator.
// Any modifications to this file will be lost upon re-generation.
// Generated on: 2020/03/27 12:19:05

package nl.tno.rpr.datatypes;

/** Record specifying Line 1 geometry record */
public class Line1GeomRecStruct {

  /** Start point location */
  WorldLocationStruct StartPointLocation;

  /** End point location */
  WorldLocationStruct EndPointLocation;

  public WorldLocationStruct getStartPointLocation() {
    return this.StartPointLocation;
  }

  public void setStartPointLocation(WorldLocationStruct StartPointLocation) {
    this.StartPointLocation = StartPointLocation;
  }

  public WorldLocationStruct getEndPointLocation() {
    return this.EndPointLocation;
  }

  public void setEndPointLocation(WorldLocationStruct EndPointLocation) {
    this.EndPointLocation = EndPointLocation;
  }
}
