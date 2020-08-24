// This file was generated by the TNO Bean Generator.
// Any modifications to this file will be lost upon re-generation.
// Generated on: 2020/03/27 12:19:05

package nl.tno.rpr.datatypes;

/** Warhead */
public enum WarheadTypeEnum16 {
  Other((short) 0),
  CargoVariableSubmunitions((short) 10),
  FuelAirExplosive((short) 20),
  GlassBeads((short) 30),
  Warhead_1um((short) 31),
  Warhead_5um((short) 32),
  Warhead_10um((short) 33),
  HighExplosive((short) 1000),
  HE_Plastic((short) 1100),
  HE_Incendiary((short) 1200),
  HE_Fragmentation((short) 1300),
  HE_Antitank((short) 1400),
  HE_Bomblets((short) 1500),
  HE_ShapedCharge((short) 1600),
  HE_ContinuousRod((short) 1610),
  HE_TungstenBall((short) 1615),
  HE_BlastFragmentation((short) 1620),
  HE_SteerableDartswithHE((short) 1625),
  HE_Darts((short) 1630),
  HE_Flechettes((short) 1635),
  HE_DirectedFragmentation((short) 1640),
  HE_SemiArmorPiercing((short) 1645),
  HE_ShapedChargeFragmentation((short) 1650),
  HE_SemiArmorPiercingFragmentation((short) 1655),
  HE_HollowCharge((short) 1660),
  HE_DoubleHollowCharge((short) 1665),
  HE_GeneralPurpose((short) 1670),
  HE_BlastPenetrator((short) 1675),
  HE_RodPenetrator((short) 1680),
  HE_Antipersonnel((short) 1685),
  Smoke((short) 2000),
  Illumination((short) 3000),
  Practice((short) 4000),
  Kinetic((short) 5000),
  Mines((short) 6000),
  Nuclear((short) 7000),
  NuclearIMT((short) 7010),
  ChemicalGeneral((short) 8000),
  ChemicalBlisterAgent((short) 8100),
  HD_Mustard((short) 8110),
  ThickenedHD_Mustard((short) 8115),
  DustyHD_Mustard((short) 8120),
  ChemicalBloodAgent((short) 8200),
  AC_HCN((short) 8210),
  CK_CNCI((short) 8215),
  CG_Phosgene((short) 8220),
  ChemicalNerveAgent((short) 8300),
  VX((short) 8310),
  ThickenedVX((short) 8315),
  DustyVX((short) 8320),
  GA_Tabun((short) 8325),
  ThickenedGA_Tabun((short) 8330),
  DustyGA_Tabun((short) 8335),
  GB_Sarin((short) 8340),
  ThickenedGB_Sarin((short) 8345),
  DustyGB_Sarin((short) 8350),
  GD_Soman((short) 8355),
  ThickenedGD_Soman((short) 8360),
  DustyGD_Soman((short) 8365),
  GF((short) 8370),
  ThickenedGF((short) 8375),
  DustyGF((short) 8380),
  Biological((short) 9000),
  BiologicalVirus((short) 9100),
  BiologicalBacteria((short) 9200),
  BiologicalRickettsia((short) 9300),
  BiologicalGeneticallyModifiedMicroOrganisms((short) 9400),
  BiologicalToxin((short) 9500);

  private final short value;

  private WarheadTypeEnum16(short value) {
    this.value = value;
  }

  public short getValue() {
    return value;
  }
}
