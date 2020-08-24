// This file was generated by the TNO Bean Generator.
// Any modifications to this file will be lost upon re-generation.
// Generated on: 2020/03/27 12:19:05

package nl.tno.rpr.interactions;

import nl.tno.rpr.datatypes.ClockTimeStruct;
import nl.tno.rpr.datatypes.EntityIdentifierStruct;

/**
 * A Simulation Management (SIMAN) interaction, sent from a Simulation Manager federate to either a)
 * start simulating one or more entities or b) resume simulation of one or more entities after a
 * pause.
 */
public class StartResume {

  /** The DIS entity ID of the entity or application sending the interaction. */
  EntityIdentifierStruct OriginatingEntity;

  /**
   * The DIS entity ID of the entity or application which is the intended recipient(s) of the
   * interaction.
   */
  EntityIdentifierStruct ReceivingEntity;

  /** The real world time (GMT) that the entity or entities should start/resume at. */
  ClockTimeStruct RealWorldTime;

  /**
   * The Request ID is a monotonically increasing integer identifier inserted by the Simulation
   * Manager into all Simulation management interactions. It is used as a unique identifier to
   * identify the latest in a series of competing requests and identifying acknowledgements.
   */
  int RequestIdentifier;

  /** The simulation time that the entity or entities should use when they start/resume. */
  ClockTimeStruct SimulationTime;

  public EntityIdentifierStruct getOriginatingEntity() {
    return this.OriginatingEntity;
  }

  public void setOriginatingEntity(EntityIdentifierStruct OriginatingEntity) {
    this.OriginatingEntity = OriginatingEntity;
  }

  public EntityIdentifierStruct getReceivingEntity() {
    return this.ReceivingEntity;
  }

  public void setReceivingEntity(EntityIdentifierStruct ReceivingEntity) {
    this.ReceivingEntity = ReceivingEntity;
  }

  public ClockTimeStruct getRealWorldTime() {
    return this.RealWorldTime;
  }

  public void setRealWorldTime(ClockTimeStruct RealWorldTime) {
    this.RealWorldTime = RealWorldTime;
  }

  public int getRequestIdentifier() {
    return this.RequestIdentifier;
  }

  public void setRequestIdentifier(int RequestIdentifier) {
    this.RequestIdentifier = RequestIdentifier;
  }

  public ClockTimeStruct getSimulationTime() {
    return this.SimulationTime;
  }

  public void setSimulationTime(ClockTimeStruct SimulationTime) {
    this.SimulationTime = SimulationTime;
  }
}
