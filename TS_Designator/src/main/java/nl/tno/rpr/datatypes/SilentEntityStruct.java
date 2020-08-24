// This file was generated by the TNO Bean Generator.
// Any modifications to this file will be lost upon re-generation.
// Generated on: 2020/03/27 12:19:05

package nl.tno.rpr.datatypes;

/** These fields contain information about entities not registered in the federation. */
public class SilentEntityStruct {

  /**
   * This field shall specify the number of entities that have the type specified in the field
   * EntityType.
   */
  short NumberOfEntitiesOfThisType;

  /**
   * This field shall specify the number of Entity Appearance records that follow. This number shall
   * be between zero and the number of entities of this type. Simulation applications representing
   * the aggregate that do not model entity appearances shall set this field to zero. Simulation
   * applications representing the aggregate that model entity appearances shall set this field to
   * the number of entity appearances that deviate from the default appearance. Other simulations
   * can safely assume that any entity appearances not specified are default appearances.
   */
  short NumberOfAppearanceRecords;

  /** This field shall specify the entity types common to the entities in this system list. */
  EntityTypeStruct EntityType;

  /**
   * This field shall specify the entity appearances of entities in the aggregate that deviate from
   * the default. The length of the array is defined in the NumberOfAppearanceRecords field.
   */
  int[] EntityAppearance;

  public short getNumberOfEntitiesOfThisType() {
    return this.NumberOfEntitiesOfThisType;
  }

  public void setNumberOfEntitiesOfThisType(short NumberOfEntitiesOfThisType) {
    this.NumberOfEntitiesOfThisType = NumberOfEntitiesOfThisType;
  }

  public short getNumberOfAppearanceRecords() {
    return this.NumberOfAppearanceRecords;
  }

  public void setNumberOfAppearanceRecords(short NumberOfAppearanceRecords) {
    this.NumberOfAppearanceRecords = NumberOfAppearanceRecords;
  }

  public EntityTypeStruct getEntityType() {
    return this.EntityType;
  }

  public void setEntityType(EntityTypeStruct EntityType) {
    this.EntityType = EntityType;
  }

  public int[] getEntityAppearance() {
    return this.EntityAppearance;
  }

  public void setEntityAppearance(int[] EntityAppearance) {
    this.EntityAppearance = EntityAppearance;
  }
}
