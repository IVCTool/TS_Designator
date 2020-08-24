// This file was generated by the TNO Bean Generator.
// Any modifications to this file will be lost upon re-generation.
// Generated on: 2020/03/27 12:19:05

package nl.tno.rpr.interactions;

import nl.tno.rpr.datatypes.EntityIdentifierStruct;
import nl.tno.rpr.datatypes.FixedDatumStruct;
import nl.tno.rpr.datatypes.RequestStatusEnum32;
import nl.tno.rpr.datatypes.VariableDatumStruct;

/**
 * A Simulation Management (SIMAN) interaction designed to acknowledge receipt of an ActionResponse
 * interaction from a Simulation Manager federate and to inform the Simulation Manager federate
 * whether the federate has implemented the request.
 */
public class ActionResponse {

  /** The DIS entity ID of the entity or application sending the interaction. */
  EntityIdentifierStruct OriginatingEntity;

  /**
   * The DIS entity ID of the entity or application which is the intended recipient of the
   * interaction.
   */
  EntityIdentifierStruct ReceivingEntity;

  /**
   * This field matches this response with the specific ActionRequest interaction sent by the
   * simulation manager.
   */
  int RequestIdentifier;

  /** The status of the request that the recipient has been asked to perform. */
  RequestStatusEnum32 RequestStatus;

  /** Additional, fixed length data items (types and values). */
  FixedDatumStruct[] FixedDatums;

  /** Additional, non fixed length, data items (types and values). */
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

  public RequestStatusEnum32 getRequestStatus() {
    return this.RequestStatus;
  }

  public void setRequestStatus(RequestStatusEnum32 RequestStatus) {
    this.RequestStatus = RequestStatus;
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