// This file was generated by the TNO Bean Generator.
// Any modifications to this file will be lost upon re-generation.
// Generated on: 2020/03/27 12:19:05

package nl.tno.rpr.objects;

import nl.tno.rpr.datatypes.BeamFunctionCodeEnum8;
import nl.tno.rpr.datatypes.EventIdentifierStruct;

/**
 * A sector of concentrated energy from a device that radiates an electromagnetic signal. See also
 * IEEE 1278.1-1995 Section 5.4.7.1.
 */
public class EmitterBeam {

  /** The azimuth center of the emitter beam's scan volume relative to the emitter system. */
  float BeamAzimuthCenter;

  /** The azimuth half-angle of the emitter beam's scan volume relative to the emitter system. */
  float BeamAzimuthSweep;

  /** The elevation center of the emitter beam's scan volume relative to the emitter system. */
  float BeamElevationCenter;

  /** The elevation half-angle of the emitter beam's scan volume relative to the emitter system. */
  float BeamElevationSweep;

  /** The function of the emitter beam. */
  BeamFunctionCodeEnum8 BeamFunctionCode;

  /** The identification of the emitter beam (must be unique on the emitter system). */
  byte BeamIdentifier;

  /**
   * The index, into the federation specific emissions database, of the current operating mode of
   * the emitter beam.
   */
  short BeamParameterIndex;

  /** The effective radiated power of the emitter beam. */
  float EffectiveRadiatedPower;

  /** The center frequency of the emitter beam. */
  float EmissionFrequency;

  /** The identification of the emitter system that is generating this emitter beam. */
  String EmitterSystemIdentifier;

  /**
   * The EventIdentifier is used by the generating federate to associate related events. The event
   * number shall start at one at the beginning of the exercise, and be incremented by one for each
   * event.
   */
  EventIdentifierStruct EventIdentifier;

  /** The bandwidth of the frequencies covered by the emitter beam. */
  float FrequencyRange;

  /** The Pulse Repetition Frequency of the emitter beam. */
  float PulseRepetitionFrequency;

  /** The pulse width of the emitter beam. */
  float PulseWidth;

  /** The percentage of time a scan is through its pattern from its origin. */
  float SweepSynch;

  public float getBeamAzimuthCenter() {
    return this.BeamAzimuthCenter;
  }

  public void setBeamAzimuthCenter(float BeamAzimuthCenter) {
    this.BeamAzimuthCenter = BeamAzimuthCenter;
  }

  public float getBeamAzimuthSweep() {
    return this.BeamAzimuthSweep;
  }

  public void setBeamAzimuthSweep(float BeamAzimuthSweep) {
    this.BeamAzimuthSweep = BeamAzimuthSweep;
  }

  public float getBeamElevationCenter() {
    return this.BeamElevationCenter;
  }

  public void setBeamElevationCenter(float BeamElevationCenter) {
    this.BeamElevationCenter = BeamElevationCenter;
  }

  public float getBeamElevationSweep() {
    return this.BeamElevationSweep;
  }

  public void setBeamElevationSweep(float BeamElevationSweep) {
    this.BeamElevationSweep = BeamElevationSweep;
  }

  public BeamFunctionCodeEnum8 getBeamFunctionCode() {
    return this.BeamFunctionCode;
  }

  public void setBeamFunctionCode(BeamFunctionCodeEnum8 BeamFunctionCode) {
    this.BeamFunctionCode = BeamFunctionCode;
  }

  public byte getBeamIdentifier() {
    return this.BeamIdentifier;
  }

  public void setBeamIdentifier(byte BeamIdentifier) {
    this.BeamIdentifier = BeamIdentifier;
  }

  public short getBeamParameterIndex() {
    return this.BeamParameterIndex;
  }

  public void setBeamParameterIndex(short BeamParameterIndex) {
    this.BeamParameterIndex = BeamParameterIndex;
  }

  public float getEffectiveRadiatedPower() {
    return this.EffectiveRadiatedPower;
  }

  public void setEffectiveRadiatedPower(float EffectiveRadiatedPower) {
    this.EffectiveRadiatedPower = EffectiveRadiatedPower;
  }

  public float getEmissionFrequency() {
    return this.EmissionFrequency;
  }

  public void setEmissionFrequency(float EmissionFrequency) {
    this.EmissionFrequency = EmissionFrequency;
  }

  public String getEmitterSystemIdentifier() {
    return this.EmitterSystemIdentifier;
  }

  public void setEmitterSystemIdentifier(String EmitterSystemIdentifier) {
    this.EmitterSystemIdentifier = EmitterSystemIdentifier;
  }

  public EventIdentifierStruct getEventIdentifier() {
    return this.EventIdentifier;
  }

  public void setEventIdentifier(EventIdentifierStruct EventIdentifier) {
    this.EventIdentifier = EventIdentifier;
  }

  public float getFrequencyRange() {
    return this.FrequencyRange;
  }

  public void setFrequencyRange(float FrequencyRange) {
    this.FrequencyRange = FrequencyRange;
  }

  public float getPulseRepetitionFrequency() {
    return this.PulseRepetitionFrequency;
  }

  public void setPulseRepetitionFrequency(float PulseRepetitionFrequency) {
    this.PulseRepetitionFrequency = PulseRepetitionFrequency;
  }

  public float getPulseWidth() {
    return this.PulseWidth;
  }

  public void setPulseWidth(float PulseWidth) {
    this.PulseWidth = PulseWidth;
  }

  public float getSweepSynch() {
    return this.SweepSynch;
  }

  public void setSweepSynch(float SweepSynch) {
    this.SweepSynch = SweepSynch;
  }
}