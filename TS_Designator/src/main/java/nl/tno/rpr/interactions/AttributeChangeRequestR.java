// This file was generated by the TNO Bean Generator.
// Any modifications to this file will be lost upon re-generation.
// Generated on: 2020/03/27 12:19:05

package nl.tno.rpr.interactions;

import nl.tno.rpr.datatypes.AcknowledgementProtocolEnum8;

/**
 * A Simulation Management (SIMAN) interaction, sent from a Simulation Manager federate to ask that
 * a specified attribute be set to a specified value. The Simulation Manager federate specifies the
 * acknowledgement protocol to be used.
 */
public class AttributeChangeRequestR extends AttributeChangeRequest {

  /** The acknowledgement protocol to be used for a transaction */
  AcknowledgementProtocolEnum8 AcknowledgementProtocol;

  public AcknowledgementProtocolEnum8 getAcknowledgementProtocol() {
    return this.AcknowledgementProtocol;
  }

  public void setAcknowledgementProtocol(AcknowledgementProtocolEnum8 AcknowledgementProtocol) {
    this.AcknowledgementProtocol = AcknowledgementProtocol;
  }
}
