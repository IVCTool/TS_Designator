// This file was generated by the TNO Bean Generator.
// Any modifications to this file will be lost upon re-generation.
// Generated on: 2020/03/27 12:19:05

package nl.tno.rpr.datatypes;

/** Record specifying either a geometry or a state record */
public class EnvironmentRecVariantStruct {

  /** Discriminant */
  EnvironmentRecordTypeEnum32 Type;

  /** Specifies Point 1 geometry record alternative */
  WorldLocationStruct Point1GeometryData;

  /** Specifies Point 2 geometry record alternative */
  Point2GeomRecStruct Point2GeometryData;

  /** Specifies Line 1 geometry record alternative */
  Line1GeomRecStruct Line1GeometryData;

  /** Specifies Line 2 geometry record alternative */
  Line2GeomRecStruct Line2GeometryData;

  /** Specifies Bounding Sphere geometry record alternative */
  Sphere1GeomRecStruct BoundingSphereGeometryData;

  /** Specifies Sphere 1 geometry record alternative */
  Sphere1GeomRecStruct Sphere1GeometryData;

  /** Specifies Sphere 2 geometry record alternative */
  Sphere2GeomRecStruct Sphere2GeometryData;

  /** Specifies Ellipsoid 1 geometry record alternative */
  Ellipsoid1GeomRecStruct Ellipsoid1GeometryData;

  /** Specifies Ellipsoid 2 geometry record alternative */
  Ellipsoid2GeomRecStruct Ellipsoid2GeometryData;

  /** Specifies Cone 1 geometry record alternative */
  Cone1GeomRecStruct Cone1GeometryData;

  /** Specifies Cone 2 geometry record alternative */
  Cone2GeomRecStruct Cone2GeometryData;

  /** Specifies Rectangular Volume 1 geometry record alternative */
  RectVol1GeomRecStruct RectVol1GeometryData;

  /** Specifies Rectangular Volume 2 geometry record alternative */
  RectVol2GeomRecStruct RectVol2GeometryData;

  /** Specifies Gaussian Plume geometry record alternative */
  GaussPlumeGeomRecStruct GaussPlumeGeometryData;

  /** Specifies Gaussian Puff geometry record alternative */
  GaussPuffGeomRecStruct GaussPuffGeometryData;

  /** Specifies Uniform geometry record alternative */
  UniformGeomRecStruct UniformGeometryData;

  /** Specifies COMBIC state record alternative */
  COMBICStateRecStruct COMBICStateData;

  /** Specifies Flare state record alternative */
  FlareStateRecStruct FlareStateData;

  /** Specifies Rectangular Volume 3 geometry record alternative */
  RectVol3GeomRecStruct RectVol3GeometryData;

  public EnvironmentRecordTypeEnum32 getType() {
    return this.Type;
  }

  public void setType(EnvironmentRecordTypeEnum32 Type) {
    this.Type = Type;
  }

  public WorldLocationStruct getPoint1GeometryData() {
    return this.Point1GeometryData;
  }

  public void setPoint1GeometryData(WorldLocationStruct Point1GeometryData) {
    this.Point1GeometryData = Point1GeometryData;
  }

  public Point2GeomRecStruct getPoint2GeometryData() {
    return this.Point2GeometryData;
  }

  public void setPoint2GeometryData(Point2GeomRecStruct Point2GeometryData) {
    this.Point2GeometryData = Point2GeometryData;
  }

  public Line1GeomRecStruct getLine1GeometryData() {
    return this.Line1GeometryData;
  }

  public void setLine1GeometryData(Line1GeomRecStruct Line1GeometryData) {
    this.Line1GeometryData = Line1GeometryData;
  }

  public Line2GeomRecStruct getLine2GeometryData() {
    return this.Line2GeometryData;
  }

  public void setLine2GeometryData(Line2GeomRecStruct Line2GeometryData) {
    this.Line2GeometryData = Line2GeometryData;
  }

  public Sphere1GeomRecStruct getBoundingSphereGeometryData() {
    return this.BoundingSphereGeometryData;
  }

  public void setBoundingSphereGeometryData(Sphere1GeomRecStruct BoundingSphereGeometryData) {
    this.BoundingSphereGeometryData = BoundingSphereGeometryData;
  }

  public Sphere1GeomRecStruct getSphere1GeometryData() {
    return this.Sphere1GeometryData;
  }

  public void setSphere1GeometryData(Sphere1GeomRecStruct Sphere1GeometryData) {
    this.Sphere1GeometryData = Sphere1GeometryData;
  }

  public Sphere2GeomRecStruct getSphere2GeometryData() {
    return this.Sphere2GeometryData;
  }

  public void setSphere2GeometryData(Sphere2GeomRecStruct Sphere2GeometryData) {
    this.Sphere2GeometryData = Sphere2GeometryData;
  }

  public Ellipsoid1GeomRecStruct getEllipsoid1GeometryData() {
    return this.Ellipsoid1GeometryData;
  }

  public void setEllipsoid1GeometryData(Ellipsoid1GeomRecStruct Ellipsoid1GeometryData) {
    this.Ellipsoid1GeometryData = Ellipsoid1GeometryData;
  }

  public Ellipsoid2GeomRecStruct getEllipsoid2GeometryData() {
    return this.Ellipsoid2GeometryData;
  }

  public void setEllipsoid2GeometryData(Ellipsoid2GeomRecStruct Ellipsoid2GeometryData) {
    this.Ellipsoid2GeometryData = Ellipsoid2GeometryData;
  }

  public Cone1GeomRecStruct getCone1GeometryData() {
    return this.Cone1GeometryData;
  }

  public void setCone1GeometryData(Cone1GeomRecStruct Cone1GeometryData) {
    this.Cone1GeometryData = Cone1GeometryData;
  }

  public Cone2GeomRecStruct getCone2GeometryData() {
    return this.Cone2GeometryData;
  }

  public void setCone2GeometryData(Cone2GeomRecStruct Cone2GeometryData) {
    this.Cone2GeometryData = Cone2GeometryData;
  }

  public RectVol1GeomRecStruct getRectVol1GeometryData() {
    return this.RectVol1GeometryData;
  }

  public void setRectVol1GeometryData(RectVol1GeomRecStruct RectVol1GeometryData) {
    this.RectVol1GeometryData = RectVol1GeometryData;
  }

  public RectVol2GeomRecStruct getRectVol2GeometryData() {
    return this.RectVol2GeometryData;
  }

  public void setRectVol2GeometryData(RectVol2GeomRecStruct RectVol2GeometryData) {
    this.RectVol2GeometryData = RectVol2GeometryData;
  }

  public GaussPlumeGeomRecStruct getGaussPlumeGeometryData() {
    return this.GaussPlumeGeometryData;
  }

  public void setGaussPlumeGeometryData(GaussPlumeGeomRecStruct GaussPlumeGeometryData) {
    this.GaussPlumeGeometryData = GaussPlumeGeometryData;
  }

  public GaussPuffGeomRecStruct getGaussPuffGeometryData() {
    return this.GaussPuffGeometryData;
  }

  public void setGaussPuffGeometryData(GaussPuffGeomRecStruct GaussPuffGeometryData) {
    this.GaussPuffGeometryData = GaussPuffGeometryData;
  }

  public UniformGeomRecStruct getUniformGeometryData() {
    return this.UniformGeometryData;
  }

  public void setUniformGeometryData(UniformGeomRecStruct UniformGeometryData) {
    this.UniformGeometryData = UniformGeometryData;
  }

  public COMBICStateRecStruct getCOMBICStateData() {
    return this.COMBICStateData;
  }

  public void setCOMBICStateData(COMBICStateRecStruct COMBICStateData) {
    this.COMBICStateData = COMBICStateData;
  }

  public FlareStateRecStruct getFlareStateData() {
    return this.FlareStateData;
  }

  public void setFlareStateData(FlareStateRecStruct FlareStateData) {
    this.FlareStateData = FlareStateData;
  }

  public RectVol3GeomRecStruct getRectVol3GeometryData() {
    return this.RectVol3GeometryData;
  }

  public void setRectVol3GeometryData(RectVol3GeomRecStruct RectVol3GeometryData) {
    this.RectVol3GeometryData = RectVol3GeometryData;
  }
}
