package model;

import java.lang.reflect.Array;
import java.util.List;

/**
 * This interface represents a model of our animation.
 */
public interface IModel {

  /**
   * Adds a shape s to the shape list.
   *
   * @param s the given shape to be added to the list
   */
  void addShape(IShape s);

  /**
   * Adds a motion to the motion list.
   *
   * @param m the given motion to beadded to the list
   * @return
   */
  void addMotion(IMotion m) throws IllegalArgumentException;

  /**
   * Returns the list of shapes in the model.
   *
   * @return the list of shapes
   */
  List<IShape> getShapeList();

  /**
   * Returns the list of motions in the model.
   *
   * @return the list of motion
   */
  List<IMotion> getMotionList();


  /**
   * Returns the speed of the animation.
   *
   * @return the speed of the animation, which is defined by tick per second
   */
  int getTickPerSecond();

  /**
   * Returns a list of shapes with statuses at a given time t.
   * 
   * @param t the given time to get the current statuses of shapes in the list
   * @return a list of shapes with statuses at a given time
   */
  List<IShape> getCurrentStatus(int t);

  /**
   * Returns the initial x-position of the top-left corner.
   * 
   * @return the initial x-position of the top-left corner
   */
  int getBoundX();
  
  /**
   * Returns the initial y-position of the top-left corner.
   *
   * @return the initial y-position of the top-left corner
   */
  int getBoundY();

  /**
   * Returns the width dimension of the canvas.
   * 
   * @return the width dimension of the canvas
   */
  int getBoundWidth();

  /**
   * Returns the height dimension of the canvas.
   * 
   * @return the height dimension of the canvas
   */
  int getBoundHeight();

  /**
   * Sets the initial x-position of the top-left corner to the given boundX.
   * 
   * @param boundX the given value to be set as initial x-position of the top-left corner
   */
  void setBoundX(int boundX);

  /**
   * Sets the initial y-position of the top-left corner to the given boundY.
   *
   * @param boundY the given value to be set as initial y-position of the top-left corner
   */
  void setBoundY(int boundY);

  /**
   * Sets the width dimension of the canvas to the given boundWidth.
   * 
   * @param boundWidth the given width dimension
   */
  void setBoundWidth(int boundWidth);

  /**
   * Sets the height dimension of the canvas to the given boundHeight.
   * 
   * @param boundHeight the given height dimension
   */
  void setBoundHeight(int boundHeight);

//  /**
//   * set the speed of the animation to the given tickPerSecond.
//   *
//   * @param tickPerSecond the given tickPerSecond to be set as speed
//   */
//  void setTickPerSecond(int tickPerSecond);

  /**
   * Returns the maximum end time of the motion in the motion list.
   *
   * @return the maximum end time of the motion in the motion list
   */
  int longestTime();

  String[] getShapeNames();
}
