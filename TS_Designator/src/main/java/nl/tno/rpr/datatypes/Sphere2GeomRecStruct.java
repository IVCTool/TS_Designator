// This file was generated by the TNO Bean Generator.
// Any modifications to this file will be lost upon re-generation.
// Generated on: 2020/03/27 12:19:05

package nl.tno.rpr.datatypes;

/** Record specifying Sphere 2 geometry record */
public class Sphere2GeomRecStruct {

  /** Centroid location X, Y, Z */
  WorldLocationStruct CentroidLocation;

  /** Radius */
  float Radius;

  /** Variation of radius */
  float RadiusRate;

  /** Velocity Vx, Vy, Vz */
  VelocityVectorStruct Velocity;

  /** Angular velocity Vx, Vy, Vz */
  AngularVelocityVectorStruct AngularVelocity;

  public WorldLocationStruct getCentroidLocation() {
    return this.CentroidLocation;
  }

  public void setCentroidLocation(WorldLocationStruct CentroidLocation) {
    this.CentroidLocation = CentroidLocation;
  }

  public float getRadius() {
    return this.Radius;
  }

  public void setRadius(float Radius) {
    this.Radius = Radius;
  }

  public float getRadiusRate() {
    return this.RadiusRate;
  }

  public void setRadiusRate(float RadiusRate) {
    this.RadiusRate = RadiusRate;
  }

  public VelocityVectorStruct getVelocity() {
    return this.Velocity;
  }

  public void setVelocity(VelocityVectorStruct Velocity) {
    this.Velocity = Velocity;
  }

  public AngularVelocityVectorStruct getAngularVelocity() {
    return this.AngularVelocity;
  }

  public void setAngularVelocity(AngularVelocityVectorStruct AngularVelocity) {
    this.AngularVelocity = AngularVelocity;
  }
}