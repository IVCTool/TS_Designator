// This file was generated by the TNO Bean Generator.
// Any modifications to this file will be lost upon re-generation.
// Generated on: 2020/03/27 12:19:05

package nl.tno.rpr.datatypes;

/** Fuse (detonator) */
public enum FuseTypeEnum16 {
  Other((short) 0),
  IntelligentInfluence((short) 10),
  Sensor((short) 20),
  SelfDestruct((short) 30),
  UltraQuick((short) 40),
  Body((short) 50),
  DeepIntrusion((short) 60),
  Multifunction((short) 100),
  PointDetonation_PD((short) 200),
  BaseDetonation_BD((short) 300),
  Contact((short) 1000),
  ContactInstantImpact((short) 1100),
  ContactDelayed((short) 1200),
  Contact10msDelay((short) 1201),
  Contact20msDelay((short) 1202),
  Contact50msDelay((short) 1205),
  Contact60msDelay((short) 1206),
  Contact100msDelay((short) 1210),
  Contact125msDelay((short) 1212),
  Contact250msDelay((short) 1225),
  ContactElectronicObliqueContact((short) 1300),
  ContactGraze((short) 1400),
  ContactCrush((short) 1500),
  ContactHydrostatic((short) 1600),
  ContactMechanical((short) 1700),
  ContactChemical((short) 1800),
  ContactPiezoelectric((short) 1900),
  ContactPointInitiating((short) 1910),
  ContactPointInitiatingBaseDetonating((short) 1920),
  ContactBaseDetonating((short) 1930),
  ContactBallisticCapAndBase((short) 1940),
  ContactBase((short) 1950),
  ContactNose((short) 1960),
  ContactFittedInStandoffProbe((short) 1970),
  ContactNonAligned((short) 1980),
  Timed((short) 2000),
  TimedProgrammable((short) 2100),
  TimedBurnout((short) 2200),
  TimedPyrotechnic((short) 2300),
  TimedElectronic((short) 2400),
  TimedBaseDelay((short) 2500),
  TimedReinforcedNoseImpactDelay((short) 2600),
  TimedShortDelayImpact((short) 2700),
  Timed10msDelay((short) 2701),
  Timed20msDelay((short) 2702),
  Timed50msDelay((short) 2705),
  Timed60msDelay((short) 2706),
  Timed100msDelay((short) 2710),
  Timed125msDelay((short) 2712),
  Timed250msDelay((short) 2725),
  TimedNoseMountedVariableDelay((short) 2800),
  TimedLongDelaySide((short) 2900),
  TimedSelectableDelay((short) 2910),
  TimedImpact((short) 2920),
  TimedSequence((short) 2930),
  Proximity((short) 3000),
  ProximityActiveLaser((short) 3100),
  ProximityMagneticMagpolarity((short) 3200),
  ProximityActiveDopplerRadar((short) 3300),
  ProximityRadioFrequencyRF((short) 3400),
  ProximityProgrammable((short) 3500),
  ProximityProgrammablePrefragmented((short) 3600),
  ProximityInfrared((short) 3700),
  Command((short) 4000),
  CommandElectronicRemotelySet((short) 4100),
  Altitude((short) 5000),
  AltitudeRadioAltimeter((short) 5100),
  AltitudeAirBurst((short) 5200),
  Depth((short) 6000),
  Acoustic((short) 7000),
  Pressure((short) 8000),
  PressureDelay((short) 8010),
  Inert((short) 8100),
  Dummy((short) 8110),
  Practice((short) 8120),
  PlugRepresenting((short) 8130),
  Training((short) 8150),
  Pyrotechnic((short) 9000),
  PyrotechnicDelay((short) 9010),
  ElectroOptical((short) 9100),
  ElectroMechanical((short) 9110),
  ElectroMechanicalNose((short) 9120),
  Strikerless((short) 9200),
  StrikerlessNoseImpact((short) 9210),
  StrikerlessCompressionIgnition((short) 9220),
  CompressionIgnition((short) 9300),
  CompressionIgnitionStrikerlessNoseImpact((short) 9310),
  Percussion((short) 9400),
  PercussionInstantaneous((short) 9410),
  Electronic((short) 9500),
  ElectronicInternallyMounted((short) 9510),
  ElectronicRangeSetting((short) 9520),
  ElectronicProgrammed((short) 9530),
  Mechanical((short) 9600),
  MechanicalNose((short) 9610),
  MechanicalTail((short) 9620);

  private final short value;

  private FuseTypeEnum16(short value) {
    this.value = value;
  }

  public short getValue() {
    return value;
  }
}
