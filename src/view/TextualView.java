package view;

import java.util.stream.Collectors;

import controller.IController;
import model.IModel;
import model.IMotion;
import model.IShape;

/**
 * This class represents a textual view that implements IView interface.
 */
public class TextualView implements IView {

  private IModel model;
  private int tickPerSecond;

  /**
   * Constructs a textual view using the given model.
   *
   * @param model the given model used to construct the textual view
   */
  public TextualView(IModel model, int tickPerSecond) {
    this.model = model;
    this.tickPerSecond = tickPerSecond;
  }

  @Override
  public String showView() {
    StringBuilder output = new StringBuilder();
    output.append(model.getShapeList().stream()
            .map(IShape::getCreateOutput).collect(Collectors.joining("\n")));
    output.append("\n\n");

    output.append(model.getShapeList().stream()
            .map(IShape::getTimeOutput).collect(Collectors.joining("\n")));
    output.append("\n\n");

    output.append(model.getMotionList().stream()
            .map(IMotion::printMotion)
            .filter(x -> !x.isBlank()).collect(Collectors.joining("\n")));

    return output.toString();
  }

  @Override
  public void showVisual() {
    throw new UnsupportedOperationException("This operation is unsupported.");
  }

  @Override
  public void showErrorMessage(String error) {

  }

  @Override
  public void addFeatures(IController features) {

  }

  @Override
  public void setPanel(MyPanel panel) {

  }

  @Override
  public MyPanel getPanel() {
    return null;
  }

//  @Override
//  public void setTickPerSecond(int tickPerSecond) {
//
//  }
}
