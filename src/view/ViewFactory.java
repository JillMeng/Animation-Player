package view;

import model.IModel;

/**
 * This class is used to construct an instance of the appropriate concrete view.
 */
public class ViewFactory {

  /**
   * Implement a factory of views, with a single static method that takes in a String name for a
   * view—“text”, “svg”, or “visual”— and constructs an instance of the appropriate concrete view.
   *
   * @param arg the given String value used to determine kind of view
   * @param model the given model
   * @return an appropriate type of view
   */
  public static IView makeView(String arg, IModel model, int tickPerSecond) {
    switch (arg) {
      case "text":
        return new TextualView(model, tickPerSecond);
      case "svg":
        return new SVGView(model, tickPerSecond);
      case "visual":
        return new VisualView(model, tickPerSecond);
      case "playback":
        return new EditView(model, tickPerSecond);
      default:
        throw new IllegalArgumentException("Invalid view.");
    }
  }
}
