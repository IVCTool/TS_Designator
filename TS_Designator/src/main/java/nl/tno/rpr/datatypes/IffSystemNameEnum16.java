// This file was generated by the TNO Bean Generator.
// Any modifications to this file will be lost upon re-generation.
// Generated on: 2020/03/27 12:19:05

package nl.tno.rpr.datatypes;

/** IFF system name */
public enum IffSystemNameEnum16 {
  Other((short) 0),
  MarkX((short) 1),
  MarkXII((short) 2),
  ATCRBS((short) 3),
  Soviet((short) 4),
  ModeS((short) 5),
  MarkX__XII__ATCRBS((short) 6),
  Mark__X__XII__ATCRBS__ModeS((short) 7),
  ARI5954((short) 8),
  ARI5983((short) 9),
  GenericRRB((short) 10),
  GenericMarkXIIA((short) 11),
  GenericMode5((short) 12),
  GenericMarkXIIACombinedInterrogator_Transponder_CIT_((short) 13),
  GenericMarkXIICombinedInterrogator_Transponder_CIT_((short) 14),
  GenericTCASI_ACASITransceiver((short) 15),
  GenericTCASII_ACASIITransceiver((short) 16),
  GenericMarkX_A_((short) 17),
  GenericMarkX_SIF_((short) 18);

  private final short value;

  private IffSystemNameEnum16(short value) {
    this.value = value;
  }

  public short getValue() {
    return value;
  }
}
