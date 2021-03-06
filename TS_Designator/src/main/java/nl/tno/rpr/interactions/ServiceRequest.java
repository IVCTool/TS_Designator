// This file was generated by the TNO Bean Generator.
// Any modifications to this file will be lost upon re-generation.
// Generated on: 2020/03/27 12:19:05

package nl.tno.rpr.interactions;

import nl.tno.rpr.datatypes.ServiceTypeEnum8;
import nl.tno.rpr.datatypes.SupplyStruct;

/**
 * A request for logistics support. The requesting entity issues the interaction to the supplying
 * entity asking for repair or specific supplies.
 */
public class ServiceRequest {

  /** Object requesting service */
  String RequestingObject;

  /** Object that is able to provide the requested service */
  String ServicingObject;

  /** Type of requested service */
  ServiceTypeEnum8 ServiceType;

  /**
   * For a service of resupply, the list of supplies to be exchanged. If the service requested is
   * not resupply, then this parameter shall be omitted.
   */
  SupplyStruct[] SuppliesData;

  public String getRequestingObject() {
    return this.RequestingObject;
  }

  public void setRequestingObject(String RequestingObject) {
    this.RequestingObject = RequestingObject;
  }

  public String getServicingObject() {
    return this.ServicingObject;
  }

  public void setServicingObject(String ServicingObject) {
    this.ServicingObject = ServicingObject;
  }

  public ServiceTypeEnum8 getServiceType() {
    return this.ServiceType;
  }

  public void setServiceType(ServiceTypeEnum8 ServiceType) {
    this.ServiceType = ServiceType;
  }

  public SupplyStruct[] getSuppliesData() {
    return this.SuppliesData;
  }

  public void setSuppliesData(SupplyStruct[] SuppliesData) {
    this.SuppliesData = SuppliesData;
  }
}
