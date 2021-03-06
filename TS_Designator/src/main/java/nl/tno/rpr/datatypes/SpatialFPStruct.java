// This file was generated by the TNO Bean Generator.
// Any modifications to this file will be lost upon re-generation.
// Generated on: 2020/03/27 12:19:05

package nl.tno.rpr.datatypes;

/** Spatial structure for Dead Reckoning Algorithm FPW (2) and FPB (6). */
public class SpatialFPStruct {

  /** Location of the object. */
  WorldLocationStruct WorldLocation;

  /** Whether the object is frozen or not. */
  RPRboolean IsFrozen;

  /**
   * The angles of rotation around the coordinate axes between the object's attitude and the
   * reference coordinate system axes (calculated as the Tait-Bryan Euler angles specifying the
   * successive rotations needed to transform from the world coordinate system to the entity
   * coordinate system).
   */
  OrientationStruct Orientation;

  /** The rate at which an object's position is changing over time. */
  VelocityVectorStruct VelocityVector;

  public WorldLocationStruct getWorldLocation() {
    return this.WorldLocation;
  }

  public void setWorldLocation(WorldLocationStruct WorldLocation) {
    this.WorldLocation = WorldLocation;
  }

  public RPRboolean getIsFrozen() {
    return this.IsFrozen;
  }

  public void setIsFrozen(RPRboolean IsFrozen) {
    this.IsFrozen = IsFrozen;
  }

  public OrientationStruct getOrientation() {
    return this.Orientation;
  }

  public void setOrientation(OrientationStruct Orientation) {
    this.Orientation = Orientation;
  }

  public VelocityVectorStruct getVelocityVector() {
    return this.VelocityVector;
  }

  public void setVelocityVector(VelocityVectorStruct VelocityVector) {
    this.VelocityVector = VelocityVector;
  }
}
