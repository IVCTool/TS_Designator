// This file was generated by the TNO Bean Generator.
// Any modifications to this file will be lost upon re-generation.
// Generated on: 2020/03/27 12:19:05

package nl.tno.rpr.datatypes;

/** Transfer type */
public enum TransferTypeEnum8 {
  Other((byte) 0),
  EntityPush((byte) 1),
  EntityPull((byte) 2),
  EntitySwap((byte) 3),
  EnvironmentalProcessPush((byte) 4),
  EnvironmentalProcessPull((byte) 5),
  NotUsed((byte) 6),
  CancelTransfer((byte) 7),
  ManualPullTransfer__Entity((byte) 8),
  ManualPullTransfer__EnvironmentalProcess((byte) 9),
  RemoveEntity((byte) 10);

  private final byte value;

  private TransferTypeEnum8(byte value) {
    this.value = value;
  }

  public byte getValue() {
    return value;
  }
}
