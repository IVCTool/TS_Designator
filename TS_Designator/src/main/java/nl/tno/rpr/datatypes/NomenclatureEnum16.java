// This file was generated by the TNO Bean Generator.
// Any modifications to this file will be lost upon re-generation.
// Generated on: 2020/03/27 12:19:05

package nl.tno.rpr.datatypes;

/** The nomenclature for a specific radio system. */
public enum NomenclatureEnum16 {
  Other((short) 0),
  AN_ARN__118((short) 1),
  AN_ARN__139((short) 2),
  GenericGroundFixedTransmitter((short) 3),
  GenericGroundMobileTransmitter((short) 4);

  private final short value;

  private NomenclatureEnum16(short value) {
    this.value = value;
  }

  public short getValue() {
    return value;
  }
}
