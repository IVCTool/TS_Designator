// This file was generated by the TNO Bean Generator.
// Any modifications to this file will be lost upon re-generation.
// Generated on: 2020/03/27 12:19:05

package nl.tno.rpr.objects;

import nl.tno.rpr.datatypes.ReceiverOperationalStatusEnum16;

/**
 * A device that converts incoming electromagnetic waves in the radio frequency range into
 * information.
 */
public class RadioReceiver extends EmbeddedSystem {

  /**
   * A number that uniquely identifies this radio receiver from other receivers on the host object.
   */
  short RadioIndex;

  /** The radio frequency power received, after applying any propagation loss and antenna gain. */
  float ReceivedPower;

  /** The object instance ID of the transmitter that generated the received radio signal. */
  String ReceivedTransmitterIdentifier;

  /** The operational state of the radio receiver. */
  ReceiverOperationalStatusEnum16 ReceiverOperationalStatus;

  public short getRadioIndex() {
    return this.RadioIndex;
  }

  public void setRadioIndex(short RadioIndex) {
    this.RadioIndex = RadioIndex;
  }

  public float getReceivedPower() {
    return this.ReceivedPower;
  }

  public void setReceivedPower(float ReceivedPower) {
    this.ReceivedPower = ReceivedPower;
  }

  public String getReceivedTransmitterIdentifier() {
    return this.ReceivedTransmitterIdentifier;
  }

  public void setReceivedTransmitterIdentifier(String ReceivedTransmitterIdentifier) {
    this.ReceivedTransmitterIdentifier = ReceivedTransmitterIdentifier;
  }

  public ReceiverOperationalStatusEnum16 getReceiverOperationalStatus() {
    return this.ReceiverOperationalStatus;
  }

  public void setReceiverOperationalStatus(
      ReceiverOperationalStatusEnum16 ReceiverOperationalStatus) {
    this.ReceiverOperationalStatus = ReceiverOperationalStatus;
  }
}