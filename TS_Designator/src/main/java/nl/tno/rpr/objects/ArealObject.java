// This file was generated by the TNO Bean Generator.
// Any modifications to this file will be lost upon re-generation.
// Generated on: 2020/03/27 12:19:05

package nl.tno.rpr.objects;

import nl.tno.rpr.datatypes.DamageStatusEnum32;
import nl.tno.rpr.datatypes.RPRboolean;
import nl.tno.rpr.datatypes.WorldLocationStruct;

/**
 * A synthetic environment object that is geometrically anchored to the terrain with a set of three
 * or more points, which comes to a closure.
 */
public class ArealObject extends EnvironmentObject {

  /** Specifies the physical location (a collection of points) of the object */
  WorldLocationStruct[] PointsData;

  /** Specifies the percent completion of the object */
  int PercentComplete;

  /** Specifies the damaged appearance of the object */
  DamageStatusEnum32 DamagedAppearance;

  /** Specifies whether or not the object was created before the start of the exercise */
  RPRboolean ObjectPreDistributed;

  /**
   * Specifies whether or not the object has been deactivated (it has ceased to exist in the
   * synthetic environment)
   */
  RPRboolean Deactivated;

  /** Specifies whether or not the object is smoking (creating a smoke plume) */
  RPRboolean Smoking;

  /** Specifies whether or not the object is aflame */
  RPRboolean Flaming;

  public WorldLocationStruct[] getPointsData() {
    return this.PointsData;
  }

  public void setPointsData(WorldLocationStruct[] PointsData) {
    this.PointsData = PointsData;
  }

  public int getPercentComplete() {
    return this.PercentComplete;
  }

  public void setPercentComplete(int PercentComplete) {
    this.PercentComplete = PercentComplete;
  }

  public DamageStatusEnum32 getDamagedAppearance() {
    return this.DamagedAppearance;
  }

  public void setDamagedAppearance(DamageStatusEnum32 DamagedAppearance) {
    this.DamagedAppearance = DamagedAppearance;
  }

  public RPRboolean getObjectPreDistributed() {
    return this.ObjectPreDistributed;
  }

  public void setObjectPreDistributed(RPRboolean ObjectPreDistributed) {
    this.ObjectPreDistributed = ObjectPreDistributed;
  }

  public RPRboolean getDeactivated() {
    return this.Deactivated;
  }

  public void setDeactivated(RPRboolean Deactivated) {
    this.Deactivated = Deactivated;
  }

  public RPRboolean getSmoking() {
    return this.Smoking;
  }

  public void setSmoking(RPRboolean Smoking) {
    this.Smoking = Smoking;
  }

  public RPRboolean getFlaming() {
    return this.Flaming;
  }

  public void setFlaming(RPRboolean Flaming) {
    this.Flaming = Flaming;
  }
}
