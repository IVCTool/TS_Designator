// This file was generated by the TNO Bean Generator.
// Any modifications to this file will be lost upon re-generation.
// Generated on: 2020/03/27 12:19:05

package nl.tno.rpr.datatypes;

/** Record specifying Line 2 geometry record */
public class Line2GeomRecStruct {

  /** Start point location */
  WorldLocationStruct StartPointLocation;

  /** End point location */
  WorldLocationStruct EndPointLocation;

  /** Start point velocity */
  VelocityVectorStruct StartPointVelocity;

  /** End point velocity */
  VelocityVectorStruct EndPointVelocity;

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

  public VelocityVectorStruct getStartPointVelocity() {
    return this.StartPointVelocity;
  }

  public void setStartPointVelocity(VelocityVectorStruct StartPointVelocity) {
    this.StartPointVelocity = StartPointVelocity;
  }

  public VelocityVectorStruct getEndPointVelocity() {
    return this.EndPointVelocity;
  }

  public void setEndPointVelocity(VelocityVectorStruct EndPointVelocity) {
    this.EndPointVelocity = EndPointVelocity;
  }
}
