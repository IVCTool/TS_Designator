// This file was generated by the TNO Bean Generator.
// Any modifications to this file will be lost upon re-generation.
// Generated on: 2020/03/27 12:19:05

package nl.tno.rpr.objects;

import nl.tno.rpr.datatypes.EventIdentifierStruct;
import nl.tno.rpr.datatypes.FundamentalParameterDataStruct;
import nl.tno.rpr.datatypes.IffOperationalParameter1Enum8;
import nl.tno.rpr.datatypes.IffOperationalParameter2Enum8;
import nl.tno.rpr.datatypes.IffSystemModeEnum8;
import nl.tno.rpr.datatypes.IffSystemNameEnum16;
import nl.tno.rpr.datatypes.IffSystemTypeEnum16;
import nl.tno.rpr.datatypes.RPRboolean;

/**
 * Interrogator Friend or Foe (IFF) system, Air Traffic Control Beacon and Transponder system,
 * collision avoidance and navigational aids systems.
 */
public class IFF extends EmbeddedSystem {

  /** The azimuth center of the IFF beam's scan volume relative to the IFF system. */
  float BeamAzimuthCenter;

  /** The azimuth half-angle of the IFF beam's scan volume relative to the IFF system. */
  float BeamAzimuthSweep;

  /** The elevation center of the IFF beam's scan volume relative to the IFF system. */
  float BeamElevationCenter;

  /** The elevation half-angle of the IFF beam's scan volume relative to the IFF system. */
  float BeamElevationSweep;

  /** The percentage of time a scan is through its pattern from its origin. */
  float BeamSweepSync;

  /** Used to associate related events. */
  EventIdentifierStruct EventIdentifier;

  /** The fundamental energy radiation characteristics of the IFF/ATC/NAVAIDS system. */
  FundamentalParameterDataStruct[] FundamentalParameterData;

  /**
   * Specifies if level 2 data is available for this IFF system. If level 2 data is available then
   * the BeamAzimuthCenter, BeamAzimuthSweep, BeamElevationCenter, BeamElevationSweep,
   * BeamSweepSync, FundamentalParameterData, SecondaryOperationalDataParameter1, and
   * SecondaryOperationalDataParameter2 attributes shall be generated.
   */
  RPRboolean Layer2DataAvailable;

  /** Additional characteristics of the IFF/ATC/NAVAIDS emitting system. */
  IffOperationalParameter1Enum8 SecondaryOperationalDataParameter1;

  /** Additional characteristics of the IFF/ATC/NAVAIDS emitting system. */
  IffOperationalParameter2Enum8 SecondaryOperationalDataParameter2;

  /** Mode of operation. */
  IffSystemModeEnum8 SystemMode;

  /** Particular named type of the IFF system in use. */
  IffSystemNameEnum16 SystemName;

  /** General type of IFF system in use. */
  IffSystemTypeEnum16 SystemType;

  /** Whether or not the system is on. */
  RPRboolean SystemIsOn;

  /** Whether or not the system is operational. */
  RPRboolean SystemIsOperational;

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

  public float getBeamSweepSync() {
    return this.BeamSweepSync;
  }

  public void setBeamSweepSync(float BeamSweepSync) {
    this.BeamSweepSync = BeamSweepSync;
  }

  public EventIdentifierStruct getEventIdentifier() {
    return this.EventIdentifier;
  }

  public void setEventIdentifier(EventIdentifierStruct EventIdentifier) {
    this.EventIdentifier = EventIdentifier;
  }

  public FundamentalParameterDataStruct[] getFundamentalParameterData() {
    return this.FundamentalParameterData;
  }

  public void setFundamentalParameterData(
      FundamentalParameterDataStruct[] FundamentalParameterData) {
    this.FundamentalParameterData = FundamentalParameterData;
  }

  public RPRboolean getLayer2DataAvailable() {
    return this.Layer2DataAvailable;
  }

  public void setLayer2DataAvailable(RPRboolean Layer2DataAvailable) {
    this.Layer2DataAvailable = Layer2DataAvailable;
  }

  public IffOperationalParameter1Enum8 getSecondaryOperationalDataParameter1() {
    return this.SecondaryOperationalDataParameter1;
  }

  public void setSecondaryOperationalDataParameter1(
      IffOperationalParameter1Enum8 SecondaryOperationalDataParameter1) {
    this.SecondaryOperationalDataParameter1 = SecondaryOperationalDataParameter1;
  }

  public IffOperationalParameter2Enum8 getSecondaryOperationalDataParameter2() {
    return this.SecondaryOperationalDataParameter2;
  }

  public void setSecondaryOperationalDataParameter2(
      IffOperationalParameter2Enum8 SecondaryOperationalDataParameter2) {
    this.SecondaryOperationalDataParameter2 = SecondaryOperationalDataParameter2;
  }

  public IffSystemModeEnum8 getSystemMode() {
    return this.SystemMode;
  }

  public void setSystemMode(IffSystemModeEnum8 SystemMode) {
    this.SystemMode = SystemMode;
  }

  public IffSystemNameEnum16 getSystemName() {
    return this.SystemName;
  }

  public void setSystemName(IffSystemNameEnum16 SystemName) {
    this.SystemName = SystemName;
  }

  public IffSystemTypeEnum16 getSystemType() {
    return this.SystemType;
  }

  public void setSystemType(IffSystemTypeEnum16 SystemType) {
    this.SystemType = SystemType;
  }

  public RPRboolean getSystemIsOn() {
    return this.SystemIsOn;
  }

  public void setSystemIsOn(RPRboolean SystemIsOn) {
    this.SystemIsOn = SystemIsOn;
  }

  public RPRboolean getSystemIsOperational() {
    return this.SystemIsOperational;
  }

  public void setSystemIsOperational(RPRboolean SystemIsOperational) {
    this.SystemIsOperational = SystemIsOperational;
  }
}
