package view;


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
   * Get the panel to return the current shapes at tick.
   * @param tick the given tick.
   */
  void draw(int tick);

  /**
   * Get the panel to repaint component in the paintComponent method.
   */
  void refresh();

  /**
   * A method that sets the features to call the corresponding method in the controller.
   * @param features he corresponding features in the controller.
   */
  void addFeatures(IController features);

  /**
   * Set the view to be visible.
   */
  void makeVisible();
}
