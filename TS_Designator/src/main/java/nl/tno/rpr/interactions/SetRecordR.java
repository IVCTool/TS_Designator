// This file was generated by the TNO Bean Generator.
// Any modifications to this file will be lost upon re-generation.
// Generated on: 2020/03/27 12:19:05

package nl.tno.rpr.interactions;

import nl.tno.rpr.datatypes.AcknowledgementProtocolEnum8;
import nl.tno.rpr.datatypes.EntityIdentifierStruct;
import nl.tno.rpr.datatypes.RecordSetStruct;

/**
 * A Simulation Management (SIMAN) interaction, sent from a Simulation Manager federate to request
 * that a federate sets the values of specified data to specified values (provided in record
 * format).
 */
public class SetRecordR {

  /** The DIS entity ID of the entity or application sending the interaction. */
  EntityIdentifierStruct OriginatingEntity;

  /**
   * The DIS entity ID of the entity or application which is the intended recipient(s) of the
   * interaction.
   */
  EntityIdentifierStruct ReceivingEntity;

  /**
   * The Request ID is a monotonically increasing integer identifier inserted by the Simulation
   * Manager into all Simulation management interactions. It is used as a unique identifier to
   * identify the latest in a series of competing requests and identifying acknowledgements.
   */
  int RequestIdentifier;

  /** The acknowledgement protocol to be used for a transaction */
  AcknowledgementProtocolEnum8 AcknowledgementProtocol;

  /** Specifies the information, in record format, to be set by the receiving entity. */
  RecordSetStruct[] RecordSetData;

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

  public AcknowledgementProtocolEnum8 getAcknowledgementProtocol() {
    return this.AcknowledgementProtocol;
  }

  public void setAcknowledgementProtocol(AcknowledgementProtocolEnum8 AcknowledgementProtocol) {
    this.AcknowledgementProtocol = AcknowledgementProtocol;
  }

  public RecordSetStruct[] getRecordSetData() {
    return this.RecordSetData;
  }

  public void setRecordSetData(RecordSetStruct[] RecordSetData) {
    this.RecordSetData = RecordSetData;
  }
}