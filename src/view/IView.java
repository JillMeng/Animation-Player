package view;

import java.awt.*;
import java.util.Timer;

import controller.IController;

/**
 * This interface represents a view of animation.
 */
public interface IView {

  /**
   * Returns the string output of textual view and svg view.
   *
   * @return the string output of textual view and svg view
   */
  String showView();

  /**
   * Show visual view.
   */
  void showVisual();

  /**
   * Transmit an error message to the view, in case
   * the command could not be processed correctly
   * @param error
   */
  void showErrorMessage(String error);

  void draw(int tick);

  void refresh();

  void addFeatures(IController features);

  void makeVisible();
}
