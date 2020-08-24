// This file was generated by the TNO Bean Generator.
// Any modifications to this file will be lost upon re-generation.
// Generated on: 2020/03/27 12:19:05

package nl.tno.rpr.datatypes;

/** System repaired */
public enum RepairTypeEnum16 {
  NoRepairsPerformed((short) 0),
  AllRequestedRepairsPerformed((short) 1),
  MotorOrEngine((short) 10),
  Starter((short) 20),
  Alternator((short) 30),
  Generator((short) 40),
  Battery((short) 50),
  EngineCoolantLeak((short) 60),
  FuelFilter((short) 70),
  TransmissionOilLeak((short) 80),
  EngineOilLeak((short) 90),
  Pumps((short) 100),
  Filters((short) 110),
  Transmission((short) 120),
  Brakes((short) 130),
  SuspensionSystem((short) 140),
  OilFilter((short) 150),
  Hull((short) 1000),
  Airframe((short) 1010),
  TruckBody((short) 1020),
  TankBody((short) 1030),
  TrailerBody((short) 1040),
  Turret((short) 1050),
  Propeller((short) 1500),
  EnvironmentalFilters((short) 1520),
  Wheels((short) 1540),
  Tire((short) 1550),
  Track((short) 1560),
  GunElevationDrive((short) 2000),
  GunStabilizationSystem((short) 2010),
  GunnersPrimarySight_GPS_((short) 2020),
  CommandersExtensionToTheGPS((short) 2030),
  LoadingMechanism((short) 2040),
  GunnersAuxiliarySight((short) 2050),
  GunnersControlPanel((short) 2060),
  GunnersControlAssemblyHandle_Handles((short) 2070),
  CommandersControlHandles_Assembly((short) 2090),
  CommandersWeaponStation((short) 2100),
  CommandersIndependentThermalViewer_CITV_((short) 2110),
  GeneralWeapons((short) 2120),
  FuelTransferPump((short) 4000),
  FuelLines((short) 4010),
  Gauges((short) 4020),
  GeneralFuelSystem((short) 4030),
  ElectronicWarfareSystems((short) 4500),
  DetectionSystems((short) 4600),
  ElectronicWarfareRadioFrequency((short) 4610),
  ElectronicWarfareMicrowave((short) 4620),
  ElectronicWarfareInfrared((short) 4630),
  ElectronicWarfareLaser((short) 4640),
  RangeFinders((short) 4700),
  Range__OnlyRadar((short) 4710),
  LaserRangeFinder((short) 4720),
  ElectronicSystems((short) 4800),
  ElectronicSystemsRadioFrequency((short) 4810),
  ElectronicSystemsMicrowave((short) 4820),
  ElectronicSystemsInfrared((short) 4830),
  ElectronicSystemsLaser((short) 4840),
  Radios((short) 5000),
  CommunicationSystems((short) 5010),
  Intercoms((short) 5100),
  Encoders((short) 5200),
  EncryptionDevices((short) 5250),
  Decoders((short) 5300),
  DecryptionDevices((short) 5350),
  Computers((short) 5500),
  NavigationAndControlSystems((short) 6000),
  FireControlSystems((short) 6500),
  AirSupply((short) 8000),
  LifeSupportFilters((short) 8010),
  LifeSupportWaterSupply((short) 8020),
  RefrigerationSystem((short) 8030),
  ChemicalBiologicalAndRadiologicalProtection((short) 8040),
  WaterWashDownSystems((short) 8050),
  DecontaminationSystems((short) 8060),
  HydraulicSystemWaterSupply((short) 9000),
  CoolingSystem((short) 9010),
  Winches((short) 9020),
  Catapults((short) 9030),
  Cranes((short) 9040),
  Launchers((short) 9050),
  LifeBoats((short) 10000),
  LandingCraft((short) 10010),
  EjectionSeats((short) 10020);

  private final short value;

  private RepairTypeEnum16(short value) {
    this.value = value;
  }

  public short getValue() {
    return value;
  }
}