// This file was generated by the TNO Bean Generator.
// Any modifications to this file will be lost upon re-generation.
// Generated on: 2020/03/27 12:19:05

package nl.tno.rpr.objects;

import nl.tno.rpr.datatypes.RPRboolean;

/** RRB IFF transponder system */
public class RRB extends IFF {

  /** RRB Code (range 0-16) */
  byte Code;

  /** Specifies whether or not power reduction is on. */
  RPRboolean PowerReduction;

  /** Specifies whether or not the system is damaged. */
  RPRboolean IsDamaged;

  /** Specifies whether or not the system is malfunctioning. */
  RPRboolean IsMalfunctioning;

  /** Specifies whether or not the system is on. */
  RPRboolean IsOn;

  /** Specifies whether or not the radar enhancement is on. */
  RPRboolean RadarEnhancement;

  public byte getCode() {
    return this.Code;
  }

  public void setCode(byte Code) {
    this.Code = Code;
  }

  public RPRboolean getPowerReduction() {
    return this.PowerReduction;
  }

  public void setPowerReduction(RPRboolean PowerReduction) {
    this.PowerReduction = PowerReduction;
  }

  public RPRboolean getIsDamaged() {
    return this.IsDamaged;
  }

  public void setIsDamaged(RPRboolean IsDamaged) {
    this.IsDamaged = IsDamaged;
  }

  public RPRboolean getIsMalfunctioning() {
    return this.IsMalfunctioning;
  }

  public void setIsMalfunctioning(RPRboolean IsMalfunctioning) {
    this.IsMalfunctioning = IsMalfunctioning;
  }

  public RPRboolean getIsOn() {
    return this.IsOn;
  }

  public void setIsOn(RPRboolean IsOn) {
    this.IsOn = IsOn;
  }

  public RPRboolean getRadarEnhancement() {
    return this.RadarEnhancement;
  }

  public void setRadarEnhancement(RPRboolean RadarEnhancement) {
    this.RadarEnhancement = RadarEnhancement;
  }
}