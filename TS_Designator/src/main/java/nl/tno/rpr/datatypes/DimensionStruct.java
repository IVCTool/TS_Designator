// This file was generated by the TNO Bean Generator.
// Any modifications to this file will be lost upon re-generation.
// Generated on: 2020/03/27 12:19:05

package nl.tno.rpr.datatypes;

/** Bounding box in X,Y,Z axis. */
public class DimensionStruct {

  /** Length in meters along X axis. */
  float XAxisLength;

  /** Length in meters along Y axis. */
  float YAxisLength;

  /** Length in meters along Z axis. */
  float ZAxisLength;

  public float getXAxisLength() {
    return this.XAxisLength;
  }

  public void setXAxisLength(float XAxisLength) {
    this.XAxisLength = XAxisLength;
  }

  public float getYAxisLength() {
    return this.YAxisLength;
  }

  public void setYAxisLength(float YAxisLength) {
    this.YAxisLength = YAxisLength;
  }

  public float getZAxisLength() {
    return this.ZAxisLength;
  }

  public void setZAxisLength(float ZAxisLength) {
    this.ZAxisLength = ZAxisLength;
  }
}