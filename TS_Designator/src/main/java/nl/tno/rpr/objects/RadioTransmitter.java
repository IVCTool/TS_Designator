// This file was generated by the TNO Bean Generator.
// Any modifications to this file will be lost upon re-generation.
// Generated on: 2020/03/27 12:19:05

package nl.tno.rpr.objects;

import nl.tno.rpr.datatypes.AntennaPatternVariantStruct;
import nl.tno.rpr.datatypes.CryptographicModeEnum32;
import nl.tno.rpr.datatypes.CryptographicSystemTypeEnum16;
import nl.tno.rpr.datatypes.RFModulationSystemTypeEnum16;
import nl.tno.rpr.datatypes.RFModulationTypeVariantStruct;
import nl.tno.rpr.datatypes.RPRboolean;
import nl.tno.rpr.datatypes.RadioInputSourceEnum8;
import nl.tno.rpr.datatypes.RadioTypeStruct;
import nl.tno.rpr.datatypes.SpreadSpectrumVariantStruct;
import nl.tno.rpr.datatypes.TransmitterOperationalStatusEnum8;
import nl.tno.rpr.datatypes.WorldLocationStruct;

/**
 * A device that sends out information encoded in electromagnetic waves in the radio frequency
 * range.
 */
public class RadioTransmitter extends EmbeddedSystem {

  /** The radiation pattern of the radio's antenna. */
  AntennaPatternVariantStruct[] AntennaPatternData;

  /** The mode of the cryptographic system. */
  CryptographicModeEnum32 CryptographicMode;

  /** The type of cryptographic equipment in use. */
  CryptographicSystemTypeEnum16 CryptoSystem;

  /**
   * The identification of the key used to encrypt the radio signals being transmitted. The
   * transmitter and receiver should be considered to be using the same key if these numbers match.
   */
  short EncryptionKeyIdentifier;

  /** The center frequency of the radio transmissions. */
  long Frequency;

  /** The bandpass of the radio transmissions. */
  float FrequencyBandwidth;

  /** A number that uniquely identifies this radio from others on the host. */
  short RadioIndex;

  /** Specifies which position or data port provided the input for the transmission. */
  RadioInputSourceEnum8 RadioInputSource;

  /** The type of radio transmitter. */
  RadioTypeStruct RadioSystemType;

  /** The radio system type associated with this transmitter. */
  RFModulationSystemTypeEnum16 RFModulationSystemType;

  /** Classification of the modulation type. */
  RFModulationTypeVariantStruct RFModulationType;

  /**
   * Describes the spread spectrum characteristics of the transmission, such as frequency hopping or
   * other spread spectrum transmission modes.
   */
  SpreadSpectrumVariantStruct SpreadSpectrum;

  /** A globally unique identifier for the associated audio stream */
  long StreamTag;

  /** Whether the radio is using time hopping or not. */
  RPRboolean TimeHopInUse;

  /** The average transmitted power. */
  float TransmittedPower;

  /** The current operational state of the radio transmitter. */
  TransmitterOperationalStatusEnum8 TransmitterOperationalStatus;

  /** The location of the antenna in the world coordinate system. */
  WorldLocationStruct WorldLocation;

  public AntennaPatternVariantStruct[] getAntennaPatternData() {
    return this.AntennaPatternData;
  }

  public void setAntennaPatternData(AntennaPatternVariantStruct[] AntennaPatternData) {
    this.AntennaPatternData = AntennaPatternData;
  }

  public CryptographicModeEnum32 getCryptographicMode() {
    return this.CryptographicMode;
  }

  public void setCryptographicMode(CryptographicModeEnum32 CryptographicMode) {
    this.CryptographicMode = CryptographicMode;
  }

  public CryptographicSystemTypeEnum16 getCryptoSystem() {
    return this.CryptoSystem;
  }

  public void setCryptoSystem(CryptographicSystemTypeEnum16 CryptoSystem) {
    this.CryptoSystem = CryptoSystem;
  }

  public short getEncryptionKeyIdentifier() {
    return this.EncryptionKeyIdentifier;
  }

  public void setEncryptionKeyIdentifier(short EncryptionKeyIdentifier) {
    this.EncryptionKeyIdentifier = EncryptionKeyIdentifier;
  }

  public long getFrequency() {
    return this.Frequency;
  }

  public void setFrequency(long Frequency) {
    this.Frequency = Frequency;
  }

  public float getFrequencyBandwidth() {
    return this.FrequencyBandwidth;
  }

  public void setFrequencyBandwidth(float FrequencyBandwidth) {
    this.FrequencyBandwidth = FrequencyBandwidth;
  }

  public short getRadioIndex() {
    return this.RadioIndex;
  }

  public void setRadioIndex(short RadioIndex) {
    this.RadioIndex = RadioIndex;
  }

  public RadioInputSourceEnum8 getRadioInputSource() {
    return this.RadioInputSource;
  }

  public void setRadioInputSource(RadioInputSourceEnum8 RadioInputSource) {
    this.RadioInputSource = RadioInputSource;
  }

  public RadioTypeStruct getRadioSystemType() {
    return this.RadioSystemType;
  }

  public void setRadioSystemType(RadioTypeStruct RadioSystemType) {
    this.RadioSystemType = RadioSystemType;
  }

  public RFModulationSystemTypeEnum16 getRFModulationSystemType() {
    return this.RFModulationSystemType;
  }

  public void setRFModulationSystemType(RFModulationSystemTypeEnum16 RFModulationSystemType) {
    this.RFModulationSystemType = RFModulationSystemType;
  }

  public RFModulationTypeVariantStruct getRFModulationType() {
    return this.RFModulationType;
  }

  public void setRFModulationType(RFModulationTypeVariantStruct RFModulationType) {
    this.RFModulationType = RFModulationType;
  }

  public SpreadSpectrumVariantStruct getSpreadSpectrum() {
    return this.SpreadSpectrum;
  }

  public void setSpreadSpectrum(SpreadSpectrumVariantStruct SpreadSpectrum) {
    this.SpreadSpectrum = SpreadSpectrum;
  }

  public long getStreamTag() {
    return this.StreamTag;
  }

  public void setStreamTag(long StreamTag) {
    this.StreamTag = StreamTag;
  }

  public RPRboolean getTimeHopInUse() {
    return this.TimeHopInUse;
  }

  public void setTimeHopInUse(RPRboolean TimeHopInUse) {
    this.TimeHopInUse = TimeHopInUse;
  }

  public float getTransmittedPower() {
    return this.TransmittedPower;
  }

  public void setTransmittedPower(float TransmittedPower) {
    this.TransmittedPower = TransmittedPower;
  }

  public TransmitterOperationalStatusEnum8 getTransmitterOperationalStatus() {
    return this.TransmitterOperationalStatus;
  }

  public void setTransmitterOperationalStatus(
      TransmitterOperationalStatusEnum8 TransmitterOperationalStatus) {
    this.TransmitterOperationalStatus = TransmitterOperationalStatus;
  }

  public WorldLocationStruct getWorldLocation() {
    return this.WorldLocation;
  }

  public void setWorldLocation(WorldLocationStruct WorldLocation) {
    this.WorldLocation = WorldLocation;
  }
}
