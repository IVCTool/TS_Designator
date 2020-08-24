// This file was generated by the TNO Bean Generator.
// Any modifications to this file will be lost upon re-generation.
// Generated on: 2020/03/27 12:19:05

package nl.tno.rpr.datatypes;

/** Record specifying Point 2 geometry record */
public class Point2GeomRecStruct {

  /** Location X, Y, Z */
  WorldLocationStruct Location;

  /** Velocity Vx, Vy, Vz */
  VelocityVectorStruct Velocity;

  /** Padding field */
  byte[] Padding;

  public WorldLocationStruct getLocation() {
    return this.Location;
  }

  public void setLocation(WorldLocationStruct Location) {
    this.Location = Location;
  }

  public VelocityVectorStruct getVelocity() {
    return this.Velocity;
  }

  public void setVelocity(VelocityVectorStruct Velocity) {
    this.Velocity = Velocity;
  }

  public byte[] getPadding() {
    return this.Padding;
  }

  public void setPadding(byte[] Padding) {
    this.Padding = Padding;
  }
}