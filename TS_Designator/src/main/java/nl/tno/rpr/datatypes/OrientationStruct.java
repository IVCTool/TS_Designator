// This file was generated by the TNO Bean Generator.
// Any modifications to this file will be lost upon re-generation.
// Generated on: 2020/03/27 12:19:05

package nl.tno.rpr.datatypes;

/**
 * The orientation of an object in the world coordinate system, as specified in IEEE Std 1278.1-1995
 * section 1.3.2.
 */
public class OrientationStruct {

  /** Rotation about the Z axis. */
  float Psi;

  /** Rotation about the Y axis. */
  float Theta;

  /** Rotation about the X axis. */
  float Phi;

  public float getPsi() {
    return this.Psi;
  }

  public void setPsi(float Psi) {
    this.Psi = Psi;
  }

  public float getTheta() {
    return this.Theta;
  }

  public void setTheta(float Theta) {
    this.Theta = Theta;
  }

  public float getPhi() {
    return this.Phi;
  }

  public void setPhi(float Phi) {
    this.Phi = Phi;
  }
}