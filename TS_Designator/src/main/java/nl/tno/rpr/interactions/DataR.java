// This file was generated by the TNO Bean Generator.
// Any modifications to this file will be lost upon re-generation.
// Generated on: 2020/03/27 12:19:05

package nl.tno.rpr.interactions;

import nl.tno.rpr.datatypes.AcknowledgementProtocolEnum8;

/**
 * A Simulation Management (SIMAN) interaction designed to acknowledge either a) a DataQueryR
 * interaction (in which case the DataR interaction contains the results of the query) or b) a
 * SetDataR interaction (in which case the DataR interaction contains the data that the federate was
 * able to set).
 */
public class DataR extends Data {

  /** The acknowledgement protocol to be used for a transaction */
  AcknowledgementProtocolEnum8 AcknowledgementProtocol;

  public AcknowledgementProtocolEnum8 getAcknowledgementProtocol() {
    return this.AcknowledgementProtocol;
  }

  public void setAcknowledgementProtocol(AcknowledgementProtocolEnum8 AcknowledgementProtocol) {
    this.AcknowledgementProtocol = AcknowledgementProtocol;
  }
}