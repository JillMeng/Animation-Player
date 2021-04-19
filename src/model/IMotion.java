package model;

import java.util.Set;

/**
 * This is an interface of motions.
 */
public interface IMotion {

  /**
   * Returns a String format that describes the motion.
   *
   * @return a string format of motion
   */
  String printMotion();

  /**
   * Returns a set of actions.
   *
   * @return a set of actions
   */
  Set<Action> getActionSet();

  /**
   * Returns the shape name id.
   *
   * @return the name id of the shape
   */
  String getShapeName();

  /**
   * Returns the start time of the motion.
   *
   * @return the start time of the motion
   */
  int getT1();

  /**
   * Returns the initial x-position of the shape.
   *
   * @return the initial x-position of the shape
   */
  int getX1();

  /**
   * Returns the initial y-position of the shape.
   *
   * @return the initial y-position of the shape
   */
  int getY1();

  /**
   * Returns the initial width of the shape.
   *
   * @return the initial width of the shape
   */
  int getW1();

  /**
   * Returns the initial height of the shape.
   *
   * @return the initial height of the shape
   */
  int getH1();

  /**
   * Returns the initial red color-value of the shape.
   *
   * @return the initial red color-value of the shape
   */
  int getR1();

  /**
   * Returns the initial green color-value of the shape.
   *
   * @return the initial green color-value of the shape
   */
  int getG1();

  /**
   * Returns the initial blue color-value of the shape.
   *
   * @return the initial blue color-value of the shape
   */
  int getB1();

  /**
   * Returns the end time of this motion.
   *
   * @return the end time of this motion
   */
  int getT2();

  /**
   * Returns the final x-position of the shape.
   *
   * @return the final x-position of the shape
   */
  int getX2();

  /**
   * Returns the final y-position of the shape.
   *
   * @return the final y-position of the shape
   */
  int getY2();

  /**
   * Returns the final width of the shape.
   *
   * @return the final width of the shape
   */
  int getW2();

  /**
   * Returns the final height of the shape.
   *
   * @return the final height of the shape
   */
  int getH2();

  /**
   * Returns the final red color-value of the shape.
   *
   * @return the final red color-value of the shape
   */
  int getR2();

  /**
   * Returns the final green color-value of the shape.
   *
   * @return the final green color-value of the shape
   */
  int getG2();

  /**
   * Returns the final blue color-value of the shape.
   *
   * @return the final blue color-value of the shape
   */
  int getB2();

}
