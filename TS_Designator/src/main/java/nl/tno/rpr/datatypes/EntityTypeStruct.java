// This file was generated by the TNO Bean Generator.
// Any modifications to this file will be lost upon re-generation.
// Generated on: 2020/03/27 12:19:05

package nl.tno.rpr.datatypes;

/**
 * Type of entity. Based on the Entity Type record as specified in IEEE 1278.1-1995 section 5.2.16.
 */
public class EntityTypeStruct {

  /** Kind of entity. */
  byte EntityKind;

  /** Domain in which the entity operates. */
  byte Domain;

  /** Country to which the design of the entity is attributed. */
  short CountryCode;

  /** Main category that describes the entity. */
  byte Category;

  /** Subcategory to which an entity belongs based on the Category field. */
  byte Subcategory;

  /** Specific information about an entity based on the Subcategory field. */
  byte Specific;

  /** Extra information required to describe a particular entity. */
  byte Extra;

  public byte getEntityKind() {
    return this.EntityKind;
  }

  public void setEntityKind(byte EntityKind) {
    this.EntityKind = EntityKind;
  }

  public byte getDomain() {
    return this.Domain;
  }

  public void setDomain(byte Domain) {
    this.Domain = Domain;
  }

  public short getCountryCode() {
    return this.CountryCode;
  }

  public void setCountryCode(short CountryCode) {
    this.CountryCode = CountryCode;
  }

  public byte getCategory() {
    return this.Category;
  }

  public void setCategory(byte Category) {
    this.Category = Category;
  }

  public byte getSubcategory() {
    return this.Subcategory;
  }

  public void setSubcategory(byte Subcategory) {
    this.Subcategory = Subcategory;
  }

  public byte getSpecific() {
    return this.Specific;
  }

  public void setSpecific(byte Specific) {
    this.Specific = Specific;
  }

  public byte getExtra() {
    return this.Extra;
  }

  public void setExtra(byte Extra) {
    this.Extra = Extra;
  }
}
