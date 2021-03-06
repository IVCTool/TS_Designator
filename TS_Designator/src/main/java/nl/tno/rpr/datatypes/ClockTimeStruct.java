// This file was generated by the TNO Bean Generator.
// Any modifications to this file will be lost upon re-generation.
// Generated on: 2020/03/27 12:19:05

package nl.tno.rpr.datatypes;

/**
 * Specification of the point in time of an occurrence. Based on the Clock Time record as specified
 * in IEEE 1278.1-1995 section 5.2.8.
 */
public class ClockTimeStruct {

  /** The number of hours since 0000 hours, January 1, 1970 UTC. */
  int Hours;

  /** The time past the hour indicated in the Hours field. */
  int TimePastTheHour;

  public int getHours() {
    return this.Hours;
  }

  public void setHours(int Hours) {
    this.Hours = Hours;
  }

  public int getTimePastTheHour() {
    return this.TimePastTheHour;
  }

  public void setTimePastTheHour(int TimePastTheHour) {
    this.TimePastTheHour = TimePastTheHour;
  }
}
