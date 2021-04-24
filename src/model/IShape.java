package model;

import java.awt.Color;

/**
 * This interface represents a shape.
 */
public interface IShape {
  /**
   * Returns the name id of the shape.
   *
   * @return the name id of the shape
   */
  String getName();

  /**
   * Returns the type of the shape.
   *
   * @return the type of the shape
   */
  String getType();

  /**
   * Returns the x-position of the shape.
   *
   * @return the x-position of the shape
   */
  int getX();

  /**
   * Returns the y-position of the shape.
   *
   * @return the y-position of the shape
   */
  int getY();

  /**
   * Returns the width of the shape.
   *
   * @return the width of the shape
   */
  int getW();

  /**
   * Returns the height of the shape.
   *
   * @return the height of the shape
   */
  int getH();

  /**
   * Returns the red color-value of the shape.
   *
   * @return the red color-value of the shape
   */
  int getR();

  /**
   * Returns the green color-value of the shape.
   *
   * @return the green color-value of the shape
   */
  int getG();

  /**
   * Returns the blue color-value of the shape.
   *
   * @return the blue color-value of the shape
   */
  int getB();

  /**
   * Returns the appear time of the shape.
   *
   * @return the appear time of the shape
   */
  int getAppearT();

  void setAppearT(int t1);

  /**
   * Returns the disappear time of the shape.
   *
   * @return the disappear time of the shape
   */
  int getDisappearT();

  void setDisappearT(int t2);

  /**
   * Returns the text output when creating the shape.
   *
   * @return the text output when creating the shape
   */
  String getCreateOutput();

  /**
   * Returns the text output of the time interval of the shape.
   *
   * @return the text output of the time interval of the shape
   */
  String getTimeOutput();

  /**
   * Returns a color with r, g, b values.
   *
   * @return a color with r, g, b values
   */
  Color getRGB();

  /**
   * Sets the x-position of the shape to the given x.
   *
   * @param x the given x to be set as the shape's x-position
   */
  void setX(int x);

  /**
   * Sets the y-position of the shape to the given y.
   *
   * @param y the given y to be set as the shape's y-position
   */
  void setY(int y);

  /**
   * Sets the width of the shape to the given w.
   *
   * @param w the given w to be set as the shape's width
   */
  void setW(int w);

  /**
   * Sets the height of the shape to the given h.
   *
   * @param h the given h to be set as the shape's height
   */
  void setH(int h);

  /**
   * Sets the shape's r component of color to the given r.
   *
   * @param r the given r component of color
   */
  void setR(int r);

  /**
   * Sets the shape's g component of color to the given g.
   *
   * @param g the given g component of color
   */
  void setG(int g);

  /**
   * Sets the shape's b component of color to the given b.
   *
   * @param b the given b component of color
   */
  void setB(int b);

  /**
   * Sets the order of shapes in the shape list using the given int order.
   *
   * @param order the order used to set the order of shapes in the shape list
   */
  void setShapeOrder(int order);

  /**
   * Returns the order of shapes in the shape list.
   *
   * @return the order of shapes in the shape list
   */
  int getShapeOrder();

  void setVisibility(boolean isVisbile);

  boolean getVisibility();
}
