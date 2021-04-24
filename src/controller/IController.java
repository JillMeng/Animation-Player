package controller;

import javax.swing.*;

/**
 * Represents a Controller for the EasyAnimation: handle user input by executing them
 * using the model; convey move outcomes to the user in the view.
 */
public interface IController {

  /**
   * Add UI features to the view to display.
   */
  void setView();
  /**
   * Set view object as visible to the user, and start the animation.
   */
  void start();

  /**
   * Pause the animation.
   */
  void pause();

  /**
   * Resume the animation.
   */
  void resume();

  /**
   * Restart the animation.
   */
  void restart();

  /**
   * When checked, the animation will automatically restart once it reaches the end.
   * @param isLooping a boolean status to set the looping statement.
   */
  void enableLooping(boolean isLooping);

  /**
   * Set the delay of the timer.
   * @param tickPerSecond tick that has been passed in.
   */
  void setTickPerSecond(int tickPerSecond);

  /**
   * A method that use to delete a specified shape.
   * @param shapeName the given shape that will be delayedd.
   */
  void deleteShape(String shapeName);

  /**
   * A getter method to get the timer.
   * @return the timer.
   */
  Timer getTimer();
}
