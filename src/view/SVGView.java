package view;

import controller.IController;
import model.Action;
import model.IModel;
import model.IMotion;
import model.IShape;

/**
 * This class represents a SVG View that implements IView interface.
 */
public class SVGView implements IView {

  private IModel model;
  int tickPerSecond;
  int timer;

  /**
   * Constructs a SVG View using given model.
   *
   * @param model the given model used to construct the SVG View
   */
  public SVGView(IModel model, int tickPerSecond) {
    this.model = model;
    this.tickPerSecond = tickPerSecond;
//    tickPerSecond = model.getTickPerSecond();
    timer = 1000 / tickPerSecond;
  }


  @Override
  public String showView() {
    StringBuilder output = new StringBuilder();
    output.append("<svg width=\"1000\" height=\"1000\" version=\"1.1\" "
            + "xmlns=\"http://www.w3.org/2000/svg\">\n\n");

    for (IShape aShape : model.getShapeList()) {

      if (aShape.getType().equals("rectangle")) {
        output.append("<rect id=\"" + aShape.getName() + "\" x=\"" + aShape.getX() + "\" y=\""
                + aShape.getY() + "\" width=\"" + aShape.getW() + "\" height=\"" + aShape.getH()
                + "\" ");
        output.append("fill=\"rgb(" + aShape.getR() + "," + aShape.getG() + "," + aShape.getB()
                + ")\" from=\"" + aShape.getAppearT() * timer
                + "ms\" dur=\"" + (aShape.getDisappearT() - aShape.getAppearT()) * timer
                + "ms\" visibility=\"hidden\" >\n\n");

        for (IMotion aMotion : model.getMotionList()) {

          if (aMotion.getShapeName().equals(aShape.getName())) {
            var actionSet = aMotion.getActionSet();

            if (actionSet.contains(Action.ChangePosition)) {
              if (aMotion.getX1() != aMotion.getX2()) {
                output.append("\t<animate attributeType=\"xml\" begin=\""
                        + aMotion.getT1() * timer + "ms\" dur=\""
                        + (aMotion.getT2() - aMotion.getT1()) * timer
                        + "ms\" attributeName=\"");
                output.append("x\" from=\"" + aMotion.getX1() + "\" to=\""
                        + aMotion.getX2() + "\" fill=\"freeze\" />\n\n");
              }
              if (aMotion.getY1() != aMotion.getY2()) {
                output.append("\t<animate attributeType=\"xml\" begin=\""
                        + aMotion.getT1() * timer + "ms\" dur=\""
                        + (aMotion.getT2() - aMotion.getT1()) * timer
                        + "ms\" attributeName=\"");
                output.append("y\" from=\"" + aMotion.getY1() + "\" to=\""
                        + aMotion.getY2() + "\" fill=\"freeze\" />\n\n");
              }
            }

            if (actionSet.contains(Action.ChangeColor)) {
              output.append("\t<animate attributeName=\"fill\" attributeType=\"xml\" from=\"rgb("
                      + aMotion.getR1() + "," + aMotion.getG1() + "," + aMotion.getB1()
                      + ")\" to=\"rgb(" + aMotion.getR2() + "," + aMotion.getG2() + ","
                      + aMotion.getB2() + ")\" begin=\"" + aMotion.getT1() * timer + "ms\" dur=\""
                      + (aMotion.getT2() - aMotion.getT1()) * timer
                      + "ms\" fill=\"freeze\" />\n\n");
            }

            if (actionSet.contains(Action.ChangeScale)) {
              if (aMotion.getW1() != aMotion.getW2()) {
                output.append("\t<animate attributeType=\"xml\" begin=\""
                        + aMotion.getT1() * timer + "ms\" dur=\""
                        + (aMotion.getT2() - aMotion.getT1()) * timer
                        + "ms\" attributeName=\"");
                output.append("w\" from=\"" + aMotion.getW1() + "\" to=\""
                        + aMotion.getW2() + "\" fill=\"freeze\" />\n\n");
              }
              if (aMotion.getH1() != aMotion.getH2()) {
                output.append("\t<animate attributeType=\"xml\" begin=\""
                        + aMotion.getT1() * timer + "ms\" dur=\""
                        + (aMotion.getT2() - aMotion.getT1()) * timer
                        + "ms\" attributeName=\"");
                output.append("h\" from=\"" + aMotion.getH1() + "\" to=\""
                        + aMotion.getH2() + "\" fill=\"freeze\" />\n\n");
              }
            }
            if (actionSet.contains(Action.ChangePosition)
                    && actionSet.contains(Action.ChangeColor)) {
              if (aMotion.getX1() != aMotion.getX2()) {
                output.append("\t<animate attributeType=\"xml\" begin=\""
                        + aMotion.getT1() * timer + "ms\" dur=\""
                        + (aMotion.getT2() - aMotion.getT1()) * timer
                        + "ms\" attributeName=\"");
                output.append("x\" from=\"" + aMotion.getX1() + "\" to=\""
                        + aMotion.getX2() + "\" fill=\"freeze\" />\n\n");
              }
              if (aMotion.getY1() != aMotion.getY2()) {
                output.append("\t<animate attributeType=\"xml\" begin=\""
                        + aMotion.getT1() * timer + "ms\" dur=\""
                        + (aMotion.getT2() - aMotion.getT1()) * timer
                        + "ms\" attributeName=\"");
                output.append("y\" from=\"" + aMotion.getY1() + "\" to=\""
                        + aMotion.getY2() + "\" fill=\"freeze\" />\n\n");
              }
              output.append("\t<animate attributeName=\"fill\" attributeType=\"xml\" from=\"rgb("
                      + aMotion.getR1() + "," + aMotion.getG1() + ","
                      + aMotion.getB1() + ")\" to=\"rgb(" + aMotion.getR2() + ","
                      + aMotion.getG2() + "," + aMotion.getB2() + ")\" begin=\""
                      + aMotion.getT1() * timer + "ms\" dur=\""
                      + (aMotion.getT2() - aMotion.getT1()) * timer
                      + "ms\" fill=\"freeze\" />\n\n");
            }
            if (actionSet.contains(Action.ChangePosition)
                    && actionSet.contains(Action.ChangeScale)) {
              if (aMotion.getX1() != aMotion.getX2()) {
                output.append("\t<animate attributeType=\"xml\" begin=\""
                        + aMotion.getT1() * timer + "ms\" dur=\""
                        + (aMotion.getT2() - aMotion.getT1()) * timer
                        + "ms\" attributeName=\"");
                output.append("x\" from=\"" + aMotion.getX1() + "\" to=\""
                        + aMotion.getX2() + "\" fill=\"freeze\" />\n\n");
              }
              if (aMotion.getY1() != aMotion.getY2()) {
                output.append("\t<animate attributeType=\"xml\" begin=\""
                        + aMotion.getT1() * timer + "ms\" dur=\""
                        + (aMotion.getT2() - aMotion.getT1()) * timer
                        + "ms\" attributeName=\"");
                output.append("y\" from=\"" + aMotion.getY1() + "\" to=\""
                        + aMotion.getY2() + "\" fill=\"freeze\" />\n\n");
              }
              if (aMotion.getW1() != aMotion.getW2()) {
                output.append("\t<animate attributeType=\"xml\" begin=\""
                        + aMotion.getT1() * timer + "ms\" dur=\""
                        + (aMotion.getT2() - aMotion.getT1()) * timer
                        + "ms\" attributeName=\"");
                output.append("w\" from=\"" + aMotion.getW1() + "\" to=\""
                        + aMotion.getW2() + "\" fill=\"freeze\" />\n\n");
              }
              if (aMotion.getH1() != aMotion.getH2()) {
                output.append("\t<animate attributeType=\"xml\" begin=\""
                        + aMotion.getT1() * timer + "ms\" dur=\""
                        + (aMotion.getT2() - aMotion.getT1()) * timer
                        + "ms\" attributeName=\"");
                output.append("h\" from=\"" + aMotion.getH1() + "\" to=\""
                        + aMotion.getH2() + "\" fill=\"freeze\" />\n\n");
              }
            }
            if (actionSet.contains(Action.ChangeColor)
                    && actionSet.contains(Action.ChangeScale)) {
              output.append("\t<animate attributeName=\"fill\" attributeType=\"xml\" from=\"rgb("
                      + aMotion.getR1() + "," + aMotion.getG1() + ","
                      + aMotion.getB1() + ")\" to=\"rgb(" + aMotion.getR2() + ","
                      + aMotion.getG2() + "," + aMotion.getB2() + ")\" begin=\""
                      + aMotion.getT1() * timer + "ms\" dur=\""
                      + (aMotion.getT2() - aMotion.getT1()) * timer
                      + "ms\" fill=\"freeze\" />\n\n");
              if (aMotion.getW1() != aMotion.getW2()) {
                output.append("\t<animate attributeType=\"xml\" begin=\""
                        + aMotion.getT1() * timer + "ms\" dur=\""
                        + (aMotion.getT2() - aMotion.getT1()) * timer
                        + "ms\" attributeName=\"");
                output.append("w\" from=\"" + aMotion.getW1() + "\" to=\""
                        + aMotion.getW2() + "\" fill=\"freeze\" />\n\n");
              }
              if (aMotion.getH1() != aMotion.getH2()) {
                output.append("\t<animate attributeType=\"xml\" begin=\""
                        + aMotion.getT1() * timer + "ms\" dur=\""
                        + (aMotion.getT2() - aMotion.getT1()) * timer
                        + "ms\" attributeName=\"");
                output.append("h\" from=\"" + aMotion.getH1() + "\" to=\""
                        + aMotion.getH2() + "\" fill=\"freeze\" />\n\n");
              }
            }
            if (actionSet.contains(Action.ChangePosition) && actionSet.contains(Action.ChangeColor)
                    && actionSet.contains(Action.ChangeScale)) {
              if (aMotion.getX1() != aMotion.getX2()) {
                output.append("\t<animate attributeType=\"xml\" begin=\""
                        + aMotion.getT1() * timer + "ms\" dur=\""
                        + (aMotion.getT2() - aMotion.getT1()) * timer
                        + "ms\" attributeName=\"");
                output.append("x\" from=\"" + aMotion.getX1() + "\" to=\""
                        + aMotion.getX2() + "\" fill=\"freeze\" />\n\n");
              }
              if (aMotion.getY1() != aMotion.getY2()) {
                output.append("\t<animate attributeType=\"xml\" begin=\""
                        + aMotion.getT1() * timer + "ms\" dur=\""
                        + (aMotion.getT2() - aMotion.getT1()) * timer
                        + "ms\" attributeName=\"");
                output.append("y\" from=\"" + aMotion.getY1() + "\" to=\""
                        + aMotion.getY2() + "\" fill=\"freeze\" />\n\n");
              }
              output.append("\t<animate attributeName=\"fill\" attributeType=\"xml\" "
                      + "from=\"rgb(" + aMotion.getR1() + "," + aMotion.getG1() + ","
                      + aMotion.getB1() + ")\" to=\"rgb("
                      + aMotion.getR2() + "," + aMotion.getG2() + "," + aMotion.getB2()
                      + ")\" begin=\"" + aMotion.getT1() * timer + "ms\" dur=\""
                      + (aMotion.getT2() - aMotion.getT1()) * timer
                      + "ms\" fill=\"freeze\" />\n\n");
              if (aMotion.getW1() != aMotion.getW2()) {
                output.append("\t<animate attributeType=\"xml\" begin=\""
                        + aMotion.getT1() * timer + "ms\" dur=\""
                        + (aMotion.getT2() - aMotion.getT1()) * timer
                        + "ms\" attributeName=\"");
                output.append("w\" from=\"" + aMotion.getW1() + "\" to=\""
                        + aMotion.getW2() + "\" fill=\"freeze\" />\n\n");
              }
              if (aMotion.getH1() != aMotion.getH2()) {
                output.append("\t<animate attributeType=\"xml\" begin=\""
                        + aMotion.getT1() * timer + "ms\" dur=\""
                        + (aMotion.getT2() - aMotion.getT1()) * timer + "ms\" attributeName=\"");
                output.append("h\" from=\"" + aMotion.getH1() + "\" to=\"" + aMotion.getH2()
                        + "\" fill=\"freeze\" />\n\n");
              }
            }
            else {
              output.append("\t<set attributeType=\"xml\" begin=\""
                      + aMotion.getT1() * timer + "ms\" dur=\""
                      + (aMotion.getT2() - aMotion.getT1()) * timer
                      + "ms\" attributeName=\"visibility\" from=\"hidden\" to=\"visible\" "
                      + "fill=\"freeze\" />\n\n");
            }
          }
        }
        output.append("</rect>\n\n");
      }

      if (aShape.getType().equals("oval") || aShape.getType().equals("ellipse")) {
        output.append("<ellipse id=\"" + aShape.getName() + "\" cx=\"" + aShape.getX() + "\" cy=\""
                + aShape.getY() + "\" rx=\"" + aShape.getW() / 2 + "\" ry=\"" + aShape.getH() / 2
                + "\" ");
        output.append("fill=\"rgb(" + aShape.getR() + "," + aShape.getG() + "," + aShape.getB()
                + ")\" from=\"" + aShape.getAppearT() * timer
                + "ms\" dur=\"" + (aShape.getDisappearT() - aShape.getAppearT())
                * timer + "ms\" visibility=\"hidden\" >\n\n");

        for (IMotion aMotion : model.getMotionList()) {

          if (aMotion.getShapeName().equals(aShape.getName())) {
            var actionSet = aMotion.getActionSet();

            if (actionSet.contains(Action.ChangePosition)) {
              if (aMotion.getX1() != aMotion.getX2()) {
                output.append("\t<animate attributeType=\"xml\" begin=\""
                        + aMotion.getT1() * timer + "ms\" dur=\""
                        + (aMotion.getT2() - aMotion.getT1()) * timer
                        + "ms\" attributeName=\"");
                output.append("cx\" from=\"" + aMotion.getX1() + "\" to=\""
                        + aMotion.getX2() + "\" fill=\"freeze\" />\n\n");
              }
              if (aMotion.getY1() != aMotion.getY2()) {
                output.append("\t<animate attributeType=\"xml\" begin=\""
                        + aMotion.getT1() * timer + "ms\" dur=\""
                        + (aMotion.getT2() - aMotion.getT1()) * timer
                        + "ms\" attributeName=\"");
                output.append("cy\" from=\"" + aMotion.getY1() + "\" to=\""
                        + aMotion.getY2() + "\" fill=\"freeze\" />\n\n");
              }
            }
            if (actionSet.contains(Action.ChangeColor)) {
              output.append("\t<animate attributeName=\"fill\" attributeType=\"xml\" from=\"rgb("
                      + aMotion.getR1() + "," + aMotion.getG1() + "," + aMotion.getB1()
                      + ")\" to=\"rgb(" + aMotion.getR2() + "," + aMotion.getG2() + ","
                      + aMotion.getB2() + ")\" begin=\"" + aMotion.getT1() * timer + "ms\" dur=\""
                      + (aMotion.getT2() - aMotion.getT1()) * timer
                      + "ms\" fill=\"freeze\" />\n\n");
            }
            if (actionSet.contains(Action.ChangeScale)) {
              if (aMotion.getW1() != aMotion.getW2()) {
                output.append("\t<animate attributeType=\"xml\" begin=\""
                        + aMotion.getT1() * timer + "ms\" dur=\""
                        + (aMotion.getT2() - aMotion.getT1()) * timer
                        + "ms\" attributeName=\"");
                output.append("cx\" from=\"" + aMotion.getW1() + "\" to=\""
                        + aMotion.getW2() + "\" fill=\"freeze\" />\n\n");
              }
              if (aMotion.getH1() != aMotion.getH2()) {
                output.append("\t<animate attributeType=\"xml\" begin=\""
                        + aMotion.getT1() * timer + "ms\" dur=\""
                        + (aMotion.getT2() - aMotion.getT1()) * timer
                        + "ms\" attributeName=\"");
                output.append("cy\" from=\"" + aMotion.getH1() + "\" to=\""
                        + aMotion.getH2() + "\" fill=\"freeze\" />\n\n");
              }
            }
            if (actionSet.contains(Action.ChangePosition)
                    && actionSet.contains(Action.ChangeColor)) {
              if (aMotion.getX1() != aMotion.getX2()) {
                output.append("\t<animate attributeType=\"xml\" begin=\""
                        + aMotion.getT1() * timer + "ms\" dur=\""
                        + (aMotion.getT2() - aMotion.getT1()) * timer
                        + "ms\" attributeName=\"");
                output.append("cx\" from=\"" + aMotion.getX1() + "\" to=\""
                        + aMotion.getX2() + "\" fill=\"freeze\" />\n\n");
              }
              if (aMotion.getY1() != aMotion.getY2()) {
                output.append("\t<animate attributeType=\"xml\" begin=\""
                        + aMotion.getT1() * timer + "ms\" dur=\""
                        + (aMotion.getT2() - aMotion.getT1()) * timer
                        + "ms\" attributeName=\"");
                output.append("cy\" from=\"" + aMotion.getY1() + "\" to=\""
                        + aMotion.getY2() + "\" fill=\"freeze\" />\n\n");
              }
              output.append("\t<animate attributeName=\"fill\" attributeType=\"xml\" from=\"rgb("
                      + aMotion.getR1() + "," + aMotion.getG1() + "," + aMotion.getB1()
                      + ")\" to=\"rgb(" + aMotion.getR2() + "," + aMotion.getG2() + ","
                      + aMotion.getB2() + ")\" begin=\"" + aMotion.getT1() * timer + "ms\" dur=\""
                      + (aMotion.getT2() - aMotion.getT1()) * timer
                      + "ms\" fill=\"freeze\" />\n\n");
            }
            if (actionSet.contains(Action.ChangePosition)
                    && actionSet.contains(Action.ChangeScale)) {
              if (aMotion.getX1() != aMotion.getX2()) {
                output.append("\t<animate attributeType=\"xml\" begin=\""
                        + aMotion.getT1() * timer + "ms\" dur=\""
                        + (aMotion.getT2() - aMotion.getT1()) * timer
                        + "ms\" attributeName=\"");
                output.append("cx\" from=\"" + aMotion.getX1() + "\" to=\""
                        + aMotion.getX2() + "\" fill=\"freeze\" />\n\n");
              }
              if (aMotion.getY1() != aMotion.getY2()) {
                output.append("\t<animate attributeType=\"xml\" begin=\""
                        + aMotion.getT1() * timer + "ms\" dur=\""
                        + (aMotion.getT2() - aMotion.getT1()) * timer
                        + "ms\" attributeName=\"");
                output.append("cy\" from=\"" + aMotion.getY1() + "\" to=\""
                        + aMotion.getY2() + "\" fill=\"freeze\" />\n\n");
              }
              if (aMotion.getW1() != aMotion.getW2()) {
                output.append("\t<animate attributeType=\"xml\" begin=\""
                        + aMotion.getT1() * timer + "ms\" dur=\""
                        + (aMotion.getT2() - aMotion.getT1()) * timer
                        + "ms\" attributeName=\"");
                output.append("rx\" from=\"" + aMotion.getW1() + "\" to=\""
                        + aMotion.getW2() + "\" fill=\"freeze\" />\n\n");
              }
              if (aMotion.getH1() != aMotion.getH2()) {
                output.append("\t<animate attributeType=\"xml\" begin=\""
                        + aMotion.getT1() * timer + "ms\" dur=\""
                        + (aMotion.getT2() - aMotion.getT1()) * timer
                        + "ms\" attributeName=\"");
                output.append("ry\" from=\"" + aMotion.getH1() + "\" to=\""
                        + aMotion.getH2() + "\" fill=\"freeze\" />\n\n");
              }
            }
            if (actionSet.contains(Action.ChangeColor)
                    && actionSet.contains(Action.ChangeScale)) {
              output.append("\t<animate attributeName=\"fill\" attributeType=\"xml\" from=\"rgb("
                      + aMotion.getR1() + "," + aMotion.getG1() + "," + aMotion.getB1()
                      + ")\" to=\"rgb(" + aMotion.getR2() + "," + aMotion.getG2() + ","
                      + aMotion.getB2() + ")\" begin=\"" + aMotion.getT1() * timer + "ms\" dur=\""
                      + (aMotion.getT2() - aMotion.getT1()) * timer
                      + "ms\" fill=\"freeze\" />\n\n");
              if (aMotion.getW1() != aMotion.getW2()) {
                output.append("\t<animate attributeType=\"xml\" begin=\""
                        + aMotion.getT1() * timer + "ms\" dur=\""
                        + (aMotion.getT2() - aMotion.getT1()) * timer
                        + "ms\" attributeName=\"");
                output.append("rx\" from=\"" + aMotion.getW1() + "\" to=\""
                        + aMotion.getW2() + "\" fill=\"freeze\" />\n\n");
              }
              if (aMotion.getH1() != aMotion.getH2()) {
                output.append("\t<animate attributeType=\"xml\" begin=\""
                        + aMotion.getT1() * timer + "ms\" dur=\""
                        + (aMotion.getT2() - aMotion.getT1()) * timer
                        + "ms\" attributeName=\"");
                output.append("ry\" from=\"" + aMotion.getH1() + "\" to=\""
                        + aMotion.getH2() + "\" fill=\"freeze\" />\n\n");
              }
            }
            if (actionSet.contains(Action.ChangePosition) && actionSet.contains(Action.ChangeColor)
                    && actionSet.contains(Action.ChangeScale)) {
              if (aMotion.getX1() != aMotion.getX2()) {
                output.append("\t<animate attributeType=\"xml\" begin=\""
                        + aMotion.getT1() * timer + "ms\" dur=\""
                        + (aMotion.getT2() - aMotion.getT1()) * timer
                        + "ms\" attributeName=\"");
                output.append("cx\" from=\"" + aMotion.getX1() + "\" to=\""
                        + aMotion.getX2() + "\" fill=\"freeze\" />\n\n");
              }
              if (aMotion.getY1() != aMotion.getY2()) {
                output.append("\t<animate attributeType=\"xml\" begin=\""
                        + aMotion.getT1() * timer + "ms\" dur=\""
                        + (aMotion.getT2() - aMotion.getT1()) * timer
                        + "ms\" attributeName=\"");
                output.append("cy\" from=\"" + aMotion.getY1() + "\" to=\""
                        + aMotion.getY2() + "\" fill=\"freeze\" />\n\n");
              }
              output.append("\t<animate attributeName=\"fill\" attributeType=\"xml\" from=\"rgb("
                      + aMotion.getR1() + "," + aMotion.getG1() + "," + aMotion.getB1()
                      + ")\" to=\"rgb(" + aMotion.getR2() + "," + aMotion.getG2() + ","
                      + aMotion.getB2() + ")\" begin=\"" + aMotion.getT1() * timer + "ms\" dur=\""
                      + (aMotion.getT2() - aMotion.getT1()) * timer
                      + "ms\" fill=\"freeze\" />\n\n");
              if (aMotion.getW1() != aMotion.getW2()) {
                output.append("\t<animate attributeType=\"xml\" begin=\""
                        + aMotion.getT1() * timer + "ms\" dur=\""
                        + (aMotion.getT2() - aMotion.getT1()) * timer
                        + "ms\" attributeName=\"");
                output.append("rx\" from=\"" + aMotion.getW1() + "\" to=\""
                        + aMotion.getW2() + "\" fill=\"freeze\" />\n\n");
              }
              if (aMotion.getH1() != aMotion.getH2()) {
                output.append("\t<animate attributeType=\"xml\" begin=\""
                        + aMotion.getT1() * timer + "ms\" dur=\""
                        + (aMotion.getT2() - aMotion.getT1()) * timer
                        + "ms\" attributeName=\"");
                output.append("ry\" from=\"" + aMotion.getH1() + "\" to=\""
                        + aMotion.getH2() + "\" fill=\"freeze\" />\n\n");
              }
            }
            else {
              output.append("\t<set attributeType=\"xml\" begin=\""
                      + aMotion.getT1() * timer + "ms\" dur=\""
                      + (aMotion.getT2() - aMotion.getT1()) * timer
                      + "ms\" attributeName=\"visibility\" from=\"hidden\" to=\"visible\" "
                      + "fill=\"freeze\" />\n\n");
            }
          }
        }
        output.append("</ellipse>\n\n");
      }
    }
    output.append("</svg>");
    return output.toString();
  }

  @Override
  public void showVisual() {
    throw new UnsupportedOperationException("This operation is unsupported.");
  }

  @Override
  public void draw(int tick) {

  }

  @Override
  public void refresh() {

  }

  @Override
  public void addFeatures(IController features) {

  }

  @Override
  public void makeVisible() {

  }


}


