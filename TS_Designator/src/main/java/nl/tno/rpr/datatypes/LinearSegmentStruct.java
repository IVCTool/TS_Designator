// This file was generated by the TNO Bean Generator.
// Any modifications to this file will be lost upon re-generation.
// Generated on: 2020/03/27 12:19:05

package nl.tno.rpr.datatypes;

/** Specifies linear object segment characteristics. */
public class LinearSegmentStruct {

  /** Identifies the individual segment. */
  int SegmentNumber;

  /** Specifies the percent completion of the segment. */
  int PercentComplete;

  /** Specifies the location of the segment. */
  WorldLocationStruct Location;

  /** Specifies the orientation of the segment. */
  OrientationStruct Orientation;

  /** Specifies the length of the segment, in meters, extending in the positive X direction. */
  short Length;

  /**
   * Specifies the total width of the segment, in meters; one-half of the width shall extend in the
   * positive Y direction, and one-half of the width shall extend in the negative Y direction.
   */
  short Width;

  /** Specifies the height of the segment, in meters, above ground. */
  short Height;

  /** Specifies the depth of the segment, in meters, below ground level. */
  short Depth;

  /** Specifies the damaged appearance of the segment. */
  DamageStatusEnum32 DamagedState;

  /**
   * Specifies whether or not the segment has been deactivated (it has ceased to exist in the
   * synthetic environment).
   */
  RPRboolean Deactivated;

  /** Specifies whether or not the segment is aflame. */
  RPRboolean Flaming;

  /** Specifies whether or not the segment was created before the start of the exercise. */
  RPRboolean ObjectPreDistributed;

  /** Specifies whether or not the segment is smoking (creating a smoke plume). */
  RPRboolean Smoking;

  public int getSegmentNumber() {
    return this.SegmentNumber;
  }

  public void setSegmentNumber(int SegmentNumber) {
    this.SegmentNumber = SegmentNumber;
  }

  public int getPercentComplete() {
    return this.PercentComplete;
  }

  public void setPercentComplete(int PercentComplete) {
    this.PercentComplete = PercentComplete;
  }

  public WorldLocationStruct getLocation() {
    return this.Location;
  }

  public void setLocation(WorldLocationStruct Location) {
    this.Location = Location;
  }

  public OrientationStruct getOrientation() {
    return this.Orientation;
  }

  public void setOrientation(OrientationStruct Orientation) {
    this.Orientation = Orientation;
  }

  public short getLength() {
    return this.Length;
  }

  public void setLength(short Length) {
    this.Length = Length;
  }

  public short getWidth() {
    return this.Width;
  }

  public void setWidth(short Width) {
    this.Width = Width;
  }

  public short getHeight() {
    return this.Height;
  }

  public void setHeight(short Height) {
    this.Height = Height;
  }

  public short getDepth() {
    return this.Depth;
  }

  public void setDepth(short Depth) {
    this.Depth = Depth;
  }

  public DamageStatusEnum32 getDamagedState() {
    return this.DamagedState;
  }

  public void setDamagedState(DamageStatusEnum32 DamagedState) {
    this.DamagedState = DamagedState;
  }

  public RPRboolean getDeactivated() {
    return this.Deactivated;
  }

  public void setDeactivated(RPRboolean Deactivated) {
    this.Deactivated = Deactivated;
  }

  public RPRboolean getFlaming() {
    return this.Flaming;
  }

  public void setFlaming(RPRboolean Flaming) {
    this.Flaming = Flaming;
  }

  public RPRboolean getObjectPreDistributed() {
    return this.ObjectPreDistributed;
  }

  public void setObjectPreDistributed(RPRboolean ObjectPreDistributed) {
    this.ObjectPreDistributed = ObjectPreDistributed;
  }

  public RPRboolean getSmoking() {
    return this.Smoking;
  }

  public void setSmoking(RPRboolean Smoking) {
    this.Smoking = Smoking;
  }
}
