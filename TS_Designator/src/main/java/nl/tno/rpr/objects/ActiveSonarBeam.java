// This file was generated by the TNO Bean Generator.
// Any modifications to this file will be lost upon re-generation.
// Generated on: 2020/03/27 12:19:05

package nl.tno.rpr.objects;

import nl.tno.rpr.datatypes.ActiveSonarScanPatternEnum16;
import nl.tno.rpr.datatypes.EventIdentifierStruct;

/** A sector of concentrated acoustic energy from an active sonar device. */
public class ActiveSonarBeam {

  /** An index into the database of active (intentional) underwater acoustics emissions. */
  short ActiveEmissionParameterIndex;

  /** The RTI ID of the ActiveSonar emitting this beam */
  String ActiveSonarIdentifier;

  /**
   * The horizontal width of the main beam (as opposed to any side lobes) measured from beam center
   * to the 3 dB down point. Omni directional beams shall have a beam width of 0 radians.
   */
  float AzimuthBeamwidth;

  /**
   * The center azimuthal bearing of the main beam (as opposed to side lobes) in relation to the own
   * ship heading, clockwise positive. Omnidirection beams shall have an azimuthal center of 0
   * radians.
   */
  float AzimuthCenter;

  /**
   * The identification of the active sonar beam, which must be unique on the active sonar system.
   */
  byte BeamIdentifier;

  /** Vertical angle from beam center to 3db down point. O is omnidirectional */
  float ElevationBeamwidth;

  /** The angle of axis of the beam center to the horizontal plane. Positive upward. */
  float ElevationCenter;

  /** Used to associate changes to the beam with its ActiveSonar. */
  EventIdentifierStruct EventIdentifier;

  /** The pattern that describes the angular movement of the sonar beam during its sweep. */
  ActiveSonarScanPatternEnum16 ScanPattern;

  public short getActiveEmissionParameterIndex() {
    return this.ActiveEmissionParameterIndex;
  }

  public void setActiveEmissionParameterIndex(short ActiveEmissionParameterIndex) {
    this.ActiveEmissionParameterIndex = ActiveEmissionParameterIndex;
  }

  public String getActiveSonarIdentifier() {
    return this.ActiveSonarIdentifier;
  }

  public void setActiveSonarIdentifier(String ActiveSonarIdentifier) {
    this.ActiveSonarIdentifier = ActiveSonarIdentifier;
  }

  public float getAzimuthBeamwidth() {
    return this.AzimuthBeamwidth;
  }

  public void setAzimuthBeamwidth(float AzimuthBeamwidth) {
    this.AzimuthBeamwidth = AzimuthBeamwidth;
  }

  public float getAzimuthCenter() {
    return this.AzimuthCenter;
  }

  public void setAzimuthCenter(float AzimuthCenter) {
    this.AzimuthCenter = AzimuthCenter;
  }

  public byte getBeamIdentifier() {
    return this.BeamIdentifier;
  }

  public void setBeamIdentifier(byte BeamIdentifier) {
    this.BeamIdentifier = BeamIdentifier;
  }

  public float getElevationBeamwidth() {
    return this.ElevationBeamwidth;
  }

  public void setElevationBeamwidth(float ElevationBeamwidth) {
    this.ElevationBeamwidth = ElevationBeamwidth;
  }

  public float getElevationCenter() {
    return this.ElevationCenter;
  }

  public void setElevationCenter(float ElevationCenter) {
    this.ElevationCenter = ElevationCenter;
  }

  public EventIdentifierStruct getEventIdentifier() {
    return this.EventIdentifier;
  }

  public void setEventIdentifier(EventIdentifierStruct EventIdentifier) {
    this.EventIdentifier = EventIdentifier;
  }

  public ActiveSonarScanPatternEnum16 getScanPattern() {
    return this.ScanPattern;
  }

  public void setScanPattern(ActiveSonarScanPatternEnum16 ScanPattern) {
    this.ScanPattern = ScanPattern;
  }
}