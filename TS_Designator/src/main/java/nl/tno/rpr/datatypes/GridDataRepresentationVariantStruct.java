// This file was generated by the TNO Bean Generator.
// Any modifications to this file will be lost upon re-generation.
// Generated on: 2020/03/27 12:19:05

package nl.tno.rpr.datatypes;

/** Record specifying either type 0 or type 1 or type 2 data representation */
public class GridDataRepresentationVariantStruct {

  /** Discriminant */
  EnvironmentDataRepresentationEnum16 DataRepresentation;

  /** Specifies type 0 data representation alternative */
  GridValueType0Struct Type0;

  /** Specifies type 1 data representation alternative */
  GridValueType1Struct Type1;

  /** Specifies type 2 data representation alternative */
  GridValueType2Struct Type2;

  public EnvironmentDataRepresentationEnum16 getDataRepresentation() {
    return this.DataRepresentation;
  }

  public void setDataRepresentation(EnvironmentDataRepresentationEnum16 DataRepresentation) {
    this.DataRepresentation = DataRepresentation;
  }

  public GridValueType0Struct getType0() {
    return this.Type0;
  }

  public void setType0(GridValueType0Struct Type0) {
    this.Type0 = Type0;
  }

  public GridValueType1Struct getType1() {
    return this.Type1;
  }

  public void setType1(GridValueType1Struct Type1) {
    this.Type1 = Type1;
  }

  public GridValueType2Struct getType2() {
    return this.Type2;
  }

  public void setType2(GridValueType2Struct Type2) {
    this.Type2 = Type2;
  }
}
