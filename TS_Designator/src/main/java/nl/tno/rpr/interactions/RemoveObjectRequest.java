// This file was generated by the TNO Bean Generator.
// Any modifications to this file will be lost upon re-generation.
// Generated on: 2020/03/27 12:19:05

package nl.tno.rpr.interactions;

/**
 * A Simulation Management (SIMAN) interaction, sent from a Simulation Manager to request that one
 * or more specified objects be removed from the simulation.
 */
public class RemoveObjectRequest {

  /** The IDs of the objects to be removed. */
  String[] ObjectIdentifiers;

  /**
   * The Request ID is a monotonically increasing integer identifier inserted by the Simulation
   * Manager into all Simulation management interactions. It is used as a unique identifier to
   * identify the latest in a series of competing requests and identifying acknowledgements.
   */
  int RequestIdentifier;

  public String[] getObjectIdentifiers() {
    return this.ObjectIdentifiers;
  }

  public void setObjectIdentifiers(String[] ObjectIdentifiers) {
    this.ObjectIdentifiers = ObjectIdentifiers;
  }

  public int getRequestIdentifier() {
    return this.RequestIdentifier;
  }

  public void setRequestIdentifier(int RequestIdentifier) {
    this.RequestIdentifier = RequestIdentifier;
  }
}
