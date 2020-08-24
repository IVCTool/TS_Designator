// This file was generated by the TNO Bean Generator.
// Any modifications to this file will be lost upon re-generation.
// Generated on: 2020/03/27 12:19:05

package nl.tno.rpr.datatypes;

/** Record specifying Cone 2 geometry record */
public class Cone2GeomRecStruct {

  /** Vertex location X, Y, Z */
  WorldLocationStruct VertexLocation;

  /** Orientation, specified by Euler angles */
  OrientationStruct Orientation;

  /** Velocity Vx, Vy, Vz */
  VelocityVectorStruct Velocity;

  /** Angular velocity Vx, Vy, Vz */
  AngularVelocityVectorStruct AngularVelocity;

  /** Height */
  float Height;

  /** Variation of height */
  float HeightRate;

  /** Peak angle */
  float PeakAngle;

  /** Variation of peak angle */
  float PeakAngleRate;

  /** Padding field */
  byte[] Padding;

  public WorldLocationStruct getVertexLocation() {
    return this.VertexLocation;
  }

  public void setVertexLocation(WorldLocationStruct VertexLocation) {
    this.VertexLocation = VertexLocation;
  }

  public OrientationStruct getOrientation() {
    return this.Orientation;
  }

  public void setOrientation(OrientationStruct Orientation) {
    this.Orientation = Orientation;
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

  public float getHeight() {
    return this.Height;
  }

  public void setHeight(float Height) {
    this.Height = Height;
  }

  public float getHeightRate() {
    return this.HeightRate;
  }

  public void setHeightRate(float HeightRate) {
    this.HeightRate = HeightRate;
  }

  public float getPeakAngle() {
    return this.PeakAngle;
  }

  public void setPeakAngle(float PeakAngle) {
    this.PeakAngle = PeakAngle;
  }

  public float getPeakAngleRate() {
    return this.PeakAngleRate;
  }

  public void setPeakAngleRate(float PeakAngleRate) {
    this.PeakAngleRate = PeakAngleRate;
  }

  public byte[] getPadding() {
    return this.Padding;
  }

  public void setPadding(byte[] Padding) {
    this.Padding = Padding;
  }
}
