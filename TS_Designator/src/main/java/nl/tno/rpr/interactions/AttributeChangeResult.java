// This file was generated by the TNO Bean Generator.
// Any modifications to this file will be lost upon re-generation.
// Generated on: 2020/03/27 12:19:05

package nl.tno.rpr.interactions;

import nl.tno.rpr.datatypes.AttributeValuePairStruct;
import nl.tno.rpr.datatypes.ResponseFlagEnum16;

/**
 * A Simulation Management (SIMAN) interaction designed to acknowledge receipt of an
 * AttributeChangeRequest interaction from a Simulation Manager federate, and to inform the
 * Simulation Manager federate whether the attribute was set to the specified value or not.
 */
public class AttributeChangeResult {

  /** The ID of the object replying to the AttributeChangeRequest interaction. */
  String ObjectIdentifier;

  /** Indicates ability to comply. */
  ResponseFlagEnum16 AttributeChangeResult;

  /** The set of attributes and their values that the recipient has been able to update. */
  AttributeValuePairStruct[] AttributeValueSet;

  public String getObjectIdentifier() {
    return this.ObjectIdentifier;
  }

  public void setObjectIdentifier(String ObjectIdentifier) {
    this.ObjectIdentifier = ObjectIdentifier;
  }

  public ResponseFlagEnum16 getAttributeChangeResult() {
    return this.AttributeChangeResult;
  }

  public void setAttributeChangeResult(ResponseFlagEnum16 AttributeChangeResult) {
    this.AttributeChangeResult = AttributeChangeResult;
  }

  public AttributeValuePairStruct[] getAttributeValueSet() {
    return this.AttributeValueSet;
  }

  public void setAttributeValueSet(AttributeValuePairStruct[] AttributeValueSet) {
    this.AttributeValueSet = AttributeValueSet;
  }
}
