// This file was generated by the TNO Bean Generator.
// Any modifications to this file will be lost upon re-generation.
// Generated on: 2020/03/27 12:19:05

package nl.tno.rpr.interactions;

import nl.tno.rpr.datatypes.ActionResultEnum32;

/**
 * A Simulation Management (SIMAN) interaction designed to acknowledge receipt of an
 * ActionResponseToObject interaction from a Simulation Manager federate and to inform the
 * Simulation Manager federate whether the object has implemented the request.
 */
public class ActionResponseFromObject {

  /** The status of the request that the recipient has been asked to perform. */
  ActionResultEnum32 ActionResult;

  public ActionResultEnum32 getActionResult() {
    return this.ActionResult;
  }

  public void setActionResult(ActionResultEnum32 ActionResult) {
    this.ActionResult = ActionResult;
  }
}
