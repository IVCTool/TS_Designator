// This file was generated by the TNO Bean Generator.
// Any modifications to this file will be lost upon re-generation.
// Generated on: 2020/03/27 12:19:05

package nl.tno.rpr.interactions;

import nl.tno.rpr.datatypes.BreachedStatusEnum8;

/**
 * An interaction sent to an environment manager to request the creation, modification, or deletion
 * of instances of the MinefieldObject class.
 */
public class MinefieldObjectTransaction extends ArealObjectTransaction {

  /** Specifies the breached appearance of the minefield object */
  BreachedStatusEnum8 BreachedStatus;

  /** Specifies the number of mines in the minefield */
  int MineCount;

  public BreachedStatusEnum8 getBreachedStatus() {
    return this.BreachedStatus;
  }

  public void setBreachedStatus(BreachedStatusEnum8 BreachedStatus) {
    this.BreachedStatus = BreachedStatus;
  }

  public int getMineCount() {
    return this.MineCount;
  }

  public void setMineCount(int MineCount) {
    this.MineCount = MineCount;
  }
}
