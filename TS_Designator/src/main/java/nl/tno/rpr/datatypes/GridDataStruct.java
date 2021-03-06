// This file was generated by the TNO Bean Generator.
// Any modifications to this file will be lost upon re-generation.
// Generated on: 2020/03/27 12:19:05

package nl.tno.rpr.datatypes;

/** Record specifying grid data representation */
public class GridDataStruct {

  /** Specifies the environmental data sample */
  EnvironmentDataSampleTypeEnum16 SampleType;

  /** Specifies grid data representation alternatives */
  GridDataRepresentationVariantStruct DataRepresentation__A__Alternatives;

  public EnvironmentDataSampleTypeEnum16 getSampleType() {
    return this.SampleType;
  }

  public void setSampleType(EnvironmentDataSampleTypeEnum16 SampleType) {
    this.SampleType = SampleType;
  }

  public GridDataRepresentationVariantStruct getDataRepresentation__A__Alternatives() {
    return this.DataRepresentation__A__Alternatives;
  }

  public void setDataRepresentation__A__Alternatives(
      GridDataRepresentationVariantStruct DataRepresentation__A__Alternatives) {
    this.DataRepresentation__A__Alternatives = DataRepresentation__A__Alternatives;
  }
}
