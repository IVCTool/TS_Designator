// This file was generated by the TNO Bean Generator.
// Any modifications to this file will be lost upon re-generation.
// Generated on: 2020/03/27 12:19:05

package nl.tno.rpr.interactions;

import nl.tno.rpr.datatypes.AcknowledgementProtocolEnum8;

/**
 * A Simulation Management (SIMAN) interaction, sent from a Simulation Manager to request that one
 * or more specified objects be removed from the simulation.
 */
public class RemoveObjectRequestR extends RemoveObjectRequest {

  /** The acknowledgement protocol to be used for a transaction */
  AcknowledgementProtocolEnum8 AcknowledgementProtocol;

  public AcknowledgementProtocolEnum8 getAcknowledgementProtocol() {
    return this.AcknowledgementProtocol;
  }

  public void setAcknowledgementProtocol(AcknowledgementProtocolEnum8 AcknowledgementProtocol) {
    this.AcknowledgementProtocol = AcknowledgementProtocol;
  }
}
