// This file was generated by the TNO Bean Generator.
// Any modifications to this file will be lost upon re-generation.
// Generated on: 2020/03/27 12:19:05

package nl.tno.rpr.datatypes;

/** Damaged appearance */
public enum DamageStatusEnum32 {
  NoDamage(0),
  SlightDamage(1),
  ModerateDamage(2),
  Destroyed(3);

  private final int value;

  private DamageStatusEnum32(int value) {
    this.value = value;
  }

  public int getValue() {
    return value;
  }
}