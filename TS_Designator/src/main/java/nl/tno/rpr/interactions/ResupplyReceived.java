// This file was generated by the TNO Bean Generator.
// Any modifications to this file will be lost upon re-generation.
// Generated on: 2020/03/27 12:19:05

package nl.tno.rpr.interactions;

import nl.tno.rpr.datatypes.SupplyStruct;

/** Acknowledge the receipt of supplies. */
public class ResupplyReceived {

  /** Object that is receiving the supplies */
  String ReceivingObject;

  /** Object that is providing the supplies. */
  String SupplyingObject;

  /** List of supplies taken by receiving object. */
  SupplyStruct[] SuppliesData;

  public String getReceivingObject() {
    return this.ReceivingObject;
  }

  public void setReceivingObject(String ReceivingObject) {
    this.ReceivingObject = ReceivingObject;
  }

  public String getSupplyingObject() {
    return this.SupplyingObject;
  }

  public void setSupplyingObject(String SupplyingObject) {
    this.SupplyingObject = SupplyingObject;
  }

  public SupplyStruct[] getSuppliesData() {
    return this.SuppliesData;
  }

  public void setSuppliesData(SupplyStruct[] SuppliesData) {
    this.SuppliesData = SuppliesData;
  }
}