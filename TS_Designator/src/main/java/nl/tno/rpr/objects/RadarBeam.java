// This file was generated by the TNO Bean Generator.
// Any modifications to this file will be lost upon re-generation.
// Generated on: 2020/03/27 12:19:05

package nl.tno.rpr.objects;

import nl.tno.rpr.datatypes.RPRboolean;

/** A sector of concentrated energy from a device that radiates an electromagnetic signal. */
public class RadarBeam extends EmitterBeam {

  /**
   * When TRUE the receiving simulation can assume that all targets that are in the scan pattern of
   * the radar beam are being tracked
   */
  RPRboolean HighDensityTrack;

  /** Identification of the entities being tracked. */
  String[] TrackObjectIdentifiers;

  public RPRboolean getHighDensityTrack() {
    return this.HighDensityTrack;
  }

  public void setHighDensityTrack(RPRboolean HighDensityTrack) {
    this.HighDensityTrack = HighDensityTrack;
  }

  public String[] getTrackObjectIdentifiers() {
    return this.TrackObjectIdentifiers;
  }

  public void setTrackObjectIdentifiers(String[] TrackObjectIdentifiers) {
    this.TrackObjectIdentifiers = TrackObjectIdentifiers;
  }
}
