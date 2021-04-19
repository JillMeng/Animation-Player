package model;

import java.awt.Color;

/**
 * This class represents a shape that implements the IShape interface.
 */
public class Shape implements IShape {

  String name;
  String type;
  int x;
  int y;
  int w;
  int h;
  int r;
  int g;
  int b;
  int appearT;
  int disappearT;
  int shapeOrder;

  /**
   * Construct a shape using given name, type, x-position, y-position, width, height,
   * r-component of color, g-component of color, b component of color, appear time, disappear time.
   *
   * @param name name of the shape
   * @param type type of the shape
   * @param x x-position of the shape
   * @param y y-position of the shape
   * @param w width of the shape
   * @param h height of the shape
   * @param r r-component of color of the shape
   * @param g g-component of color of the shape
   * @param b b-component of color of the shape
   * @param appearT appear time of the shape
   * @param disappearT disappear time of the shape
   */
  public Shape(String name, String type, int x, int y, int w, int h, int r,
               int g, int b, int appearT, int disappearT) {
    this.name = name;
    this.type = type;
    this.x = x;
    this.y = y;
    this.w = w;
    this.h = h;
    this.r = r;
    this.g = g;
    this.b = b;
    this.appearT = appearT;
    this.disappearT = disappearT;
  }

  /**
   * Constructs a shape using given name of shape and type of shape.
   *
   * @param name shape's name
   * @param type shape's type
   */
  public Shape(String name, String type) {
    this.name = name;
    this.type = type;
  }

  @Override
  public String getName() {
    return this.name;
  }

  @Override
  public String getType() {
    return this.type;
  }

  @Override
  public int getX() {
    return this.x;
  }

  @Override
  public int getY() {
    return this.y;
  }

  @Override
  public int getW() {
    return this.w;
  }

  @Override
  public int getH() {
    return this.h;
  }

  @Override
  public int getR() {
    return this.r;
  }

  @Override
  public int getG() {
    return this.g;
  }

  @Override
  public int getB() {
    return this.b;
  }

  @Override
  public int getAppearT() {
    return this.appearT;
  }

  @Override
  public int getDisappearT() {
    return this.disappearT;
  }

  @Override
  public Color getRGB() {
    return new Color(this.r, this.g, this.b);
  }

  @Override
  public String getCreateOutput() {
    String create = "";
    if (this.type.equals("rectangle")) {
      create = String.format("Create rgb(%d,%d,%d) %s %s with corner at (%d, %d), "
                      + "width %d and height %d", this.r, this.g, this.b,
              this.type, this.name, this.x, this.y, this.w, this.h);
    }
    else if (this.type.equals("oval") || this.type.equals("ellipse")) {
      create = String.format("Create rgb(%d,%d,%d) %s %s with center at (%d, %d), "
                      + "radius %d and %d", this.r, this.g, this.b,
              this.type, this.name, this.x, this.y, this.w, this.h);
    }
    return create;
  }

  @Override
  public String getTimeOutput() {
    String time = String.format("%s appears at time t=%d and disappears at time t=%d",
            this.name, this.appearT, this.disappearT);
    return time;
  }

  @Override
  public void setX(int x) {
    this.x = x;
  }

  @Override
  public void setY(int y) {
    this.y = y;
  }

  @Override
  public void setW(int w) {
    this.w = w;
  }

  @Override
  public void setH(int h) {
    this.h = h;
  }

  @Override
  public void setR(int r) {
    this.r = r;
  }

  @Override
  public void setG(int g) {
    this.g = g;
  }

  @Override
  public void setB(int b) {
    this.b = b;
  }

  @Override
  public void setShapeOrder(int order) {
    shapeOrder = order;
  }

  @Override
  public int getShapeOrder() {
    return shapeOrder;
  }

  @Override
  public void setAppearT(int t1) {
    this.appearT = t1;
  }

  @Override
  public void setDisappearT(int t2) {
    this.disappearT = t2;
  }
}
