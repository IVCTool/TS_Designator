// This file was generated by the TNO Bean Generator.
// Any modifications to this file will be lost upon re-generation.
// Generated on: 2020/03/27 12:19:05

package nl.tno.rpr.interactions;

import nl.tno.rpr.datatypes.EntityIdentifierStruct;
import nl.tno.rpr.datatypes.FixedDatumStruct;
import nl.tno.rpr.datatypes.VariableDatumStruct;

/**
 * A Simulation Management (SIMAN) interaction, sent from a Simulation Manager federate to request
 * that a federate sets the values of specified data to specified values.
 */
public class SetData {

  /** The DIS entity ID of the entity or application sending the interaction. */
  EntityIdentifierStruct OriginatingEntity;

  /**
   * The DIS entity ID of the entity or application which is the intended recipient of the
   * interaction.
   */
  EntityIdentifierStruct ReceivingEntity;

  /**
   * The Request ID is a monotonically increasing integer identifier inserted by the Simulation
   * Manager into all Simulation management interactions. It is used as a unique identifier to
   * identify the latest in a series of competing requests and identifying acknowledgements.
   */
  int RequestIdentifier;

  /**
   * The set of fixed length data items (types and values) that the recipient is requested to set.
   */
  FixedDatumStruct[] FixedDatums;

  /**
   * The set of variables length data items (types and values) that the recipient is requested to
   * set.
   */
  VariableDatumStruct[] VariableDatumSet;

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

  public int getRequestIdentifier() {
    return this.RequestIdentifier;
  }

  public void setRequestIdentifier(int RequestIdentifier) {
    this.RequestIdentifier = RequestIdentifier;
  }

  public FixedDatumStruct[] getFixedDatums() {
    return this.FixedDatums;
  }

  public void setFixedDatums(FixedDatumStruct[] FixedDatums) {
    this.FixedDatums = FixedDatums;
  }

  public VariableDatumStruct[] getVariableDatumSet() {
    return this.VariableDatumSet;
  }

  public void setVariableDatumSet(VariableDatumStruct[] VariableDatumSet) {
    this.VariableDatumSet = VariableDatumSet;
  }
}
