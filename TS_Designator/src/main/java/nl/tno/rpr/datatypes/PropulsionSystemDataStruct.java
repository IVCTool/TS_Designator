// This file was generated by the TNO Bean Generator.
// Any modifications to this file will be lost upon re-generation.
// Generated on: 2020/03/27 12:19:05

package nl.tno.rpr.datatypes;

/** Information describing a propulsion system in terms of power settings and current RPM. */
public class PropulsionSystemDataStruct {

  /** The power setting of the propulsion system, after any response lags have been incorporated. */
  float PowerSetting;

  /** The current engine speed. */
  float EngineRPM;

  public float getPowerSetting() {
    return this.PowerSetting;
  }

  public void setPowerSetting(float PowerSetting) {
    this.PowerSetting = PowerSetting;
  }

  public float getEngineRPM() {
    return this.EngineRPM;
  }

  public void setEngineRPM(float EngineRPM) {
    this.EngineRPM = EngineRPM;
  }
}