// This file was generated by the TNO Bean Generator.
// Any modifications to this file will be lost upon re-generation.
// Generated on: 2020/03/27 12:19:05

package nl.tno.rpr.objects;

import nl.tno.rpr.datatypes.EventIdentifierStruct;

/**
 * The underwater acoustic classes used to communicate underwater acoustic active, intentional
 * emissions and Passive Signature or Unintentional Emissions information. These emissions are used
 * during undersea warfare scenarios to detect, classify, and track hostile forces when electronic
 * warfare mechanisms are unavailable.
 */
public class UnderwaterAcousticsEmission extends EmbeddedSystem {

  /**
   * The generating federate uses the Event Identifier to associate related events. The event number
   * begins at one at the beginning of the exercise and is incremented by one for each event.
   */
  EventIdentifierStruct EventIdentifier;

  public EventIdentifierStruct getEventIdentifier() {
    return this.EventIdentifier;
  }

  public void setEventIdentifier(EventIdentifierStruct EventIdentifier) {
    this.EventIdentifier = EventIdentifier;
  }
}
