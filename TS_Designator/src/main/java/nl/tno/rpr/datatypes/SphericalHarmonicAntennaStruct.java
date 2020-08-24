// This file was generated by the TNO Bean Generator.
// Any modifications to this file will be lost upon re-generation.
// Generated on: 2020/03/27 12:19:05

package nl.tno.rpr.datatypes;

/** Specifies the direction and radiation pattern from a radio transmitter's antenna. */
public class SphericalHarmonicAntennaStruct {

  /** The highest order of the expansion in spherical harmonics, counting from zero. */
  int Order;

  /**
   * Represents the power distribution from the antenna as the coefficients of a spherical harmonic
   * expansion to the order given in the Order field. The length of the array is N^2+2N+1 (N being
   * the Order).
   */
  float[] Coefficients;

  /**
   * This field shall specify the reference coordinate system with respect to which beam direction
   * is specified.
   */
  ReferenceSystemEnum8 ReferenceSystem;

  /** Padding to 32 bits */
  byte[] Padding;

  public int getOrder() {
    return this.Order;
  }

  public void setOrder(int Order) {
    this.Order = Order;
  }

  public float[] getCoefficients() {
    return this.Coefficients;
  }

  public void setCoefficients(float[] Coefficients) {
    this.Coefficients = Coefficients;
  }

  public ReferenceSystemEnum8 getReferenceSystem() {
    return this.ReferenceSystem;
  }

  public void setReferenceSystem(ReferenceSystemEnum8 ReferenceSystem) {
    this.ReferenceSystem = ReferenceSystem;
  }

  public byte[] getPadding() {
    return this.Padding;
  }

  public void setPadding(byte[] Padding) {
    this.Padding = Padding;
  }
}
