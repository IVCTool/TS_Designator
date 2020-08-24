// This file was generated by the TNO Bean Generator.
// Any modifications to this file will be lost upon re-generation.
// Generated on: 2020/03/27 12:19:05

package nl.tno.rpr.interactions;

import nl.tno.rpr.datatypes.EntityCoordinateVectorStruct;

/**
 * The act or instance of coming together with solid impact in an elastic manner. An elastic
 * collision allows a higher fidelity collision to be modeled, taking into account linear and
 * rotational momentum transfer, variable elasticity, and momentum transfer that is dependent on
 * surface orientation.
 */
public class CollisionElastic extends Collision {

  /** The degree that energy is conserved in a collision. */
  float CoefficientOfRestitution;

  /** X-X Component of the positive semi-definite Collision Intermediate Result matrix. */
  float IntermediateResultXX;

  /** X-Y Component of the positive semi-definite Collision Intermediate Result matrix. */
  float IntermediateResultXY;

  /** X-Z Component of the positive semi-definite Collision Intermediate Result matrix. */
  float IntermediateResultXZ;

  /** Y-Y Component of the positive semi-definite Collision Intermediate Result matrix. */
  float IntermediateResultYY;

  /** Y-Z Component of the positive semi-definite Collision Intermediate Result matrix. */
  float IntermediateResultYZ;

  /** Z-Z Component of the positive semi-definite Collision Intermediate Result matrix. */
  float IntermediateResultZZ;

  /** The normal vector to the surface at the point of collision detection. */
  EntityCoordinateVectorStruct UnitSurfaceNormal;

  public float getCoefficientOfRestitution() {
    return this.CoefficientOfRestitution;
  }

  public void setCoefficientOfRestitution(float CoefficientOfRestitution) {
    this.CoefficientOfRestitution = CoefficientOfRestitution;
  }

  public float getIntermediateResultXX() {
    return this.IntermediateResultXX;
  }

  public void setIntermediateResultXX(float IntermediateResultXX) {
    this.IntermediateResultXX = IntermediateResultXX;
  }

  public float getIntermediateResultXY() {
    return this.IntermediateResultXY;
  }

  public void setIntermediateResultXY(float IntermediateResultXY) {
    this.IntermediateResultXY = IntermediateResultXY;
  }

  public float getIntermediateResultXZ() {
    return this.IntermediateResultXZ;
  }

  public void setIntermediateResultXZ(float IntermediateResultXZ) {
    this.IntermediateResultXZ = IntermediateResultXZ;
  }

  public float getIntermediateResultYY() {
    return this.IntermediateResultYY;
  }

  public void setIntermediateResultYY(float IntermediateResultYY) {
    this.IntermediateResultYY = IntermediateResultYY;
  }

  public float getIntermediateResultYZ() {
    return this.IntermediateResultYZ;
  }

  public void setIntermediateResultYZ(float IntermediateResultYZ) {
    this.IntermediateResultYZ = IntermediateResultYZ;
  }

  public float getIntermediateResultZZ() {
    return this.IntermediateResultZZ;
  }

  public void setIntermediateResultZZ(float IntermediateResultZZ) {
    this.IntermediateResultZZ = IntermediateResultZZ;
  }

  public EntityCoordinateVectorStruct getUnitSurfaceNormal() {
    return this.UnitSurfaceNormal;
  }

  public void setUnitSurfaceNormal(EntityCoordinateVectorStruct UnitSurfaceNormal) {
    this.UnitSurfaceNormal = UnitSurfaceNormal;
  }
}