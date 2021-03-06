// This file was generated by the TNO Bean Generator.
// Any modifications to this file will be lost upon re-generation.
// Generated on: 2020/03/27 12:19:05

package nl.tno.rpr.datatypes;

/** Record specifying plume dimension rates */
public class PlumeDimensionRateStruct {

  /** Variation of plume length */
  float LengthRate;

  /** Variation of plume width */
  float WidthRate;

  /** Variation of plume height */
  float HeightRate;

  public float getLengthRate() {
    return this.LengthRate;
  }

  public void setLengthRate(float LengthRate) {
    this.LengthRate = LengthRate;
  }

  public float getWidthRate() {
    return this.WidthRate;
  }

  public void setWidthRate(float WidthRate) {
    this.WidthRate = WidthRate;
  }

  public float getHeightRate() {
    return this.HeightRate;
  }

  public void setHeightRate(float HeightRate) {
    this.HeightRate = HeightRate;
  }
}
