package model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * This class represents a model of animation that implements all the operations from the IModel
 * interface.
 */
public class Model implements IModel {
  List<IShape> shapeList;
  List<IMotion> motionList;

  int tickPerSecond;
  int boundX;
  int boundY;
  int boundWidth;
  int boundHeight;

  /**
   * Constructs a model without parameter, and set shapeList and motionList as two linked lists.
   */
  public Model() {
    shapeList = new LinkedList<>();
    motionList = new LinkedList<>();
  }

  @Override
  public void addShape(IShape s) {
    for (int i = 0; i < shapeList.size(); i++) {
      if (s.getName().equals(shapeList.get(i).getName())) {
        throw new IllegalArgumentException("Shape already existed.");
      } else {
        continue;
      }
    }
    s.setShapeOrder(shapeList.size());
    shapeList.add(s);
  }

  /**
   * Returns the true or false based on whether there is overlap between motion m and the existing
   * motion list.
   *
   * @param m the motion to be checked
   * @return true or false based on the check result
   */
  public boolean checkOverlap(IMotion m) {
    if (motionList.isEmpty()) {
      return false;
    }
    //pass in a new motion and filter the existing motions for the corresponding shape
    List<IMotion> groupedMotions = motionList.stream()
            .filter(x -> x.getShapeName().equals(m.getShapeName())).collect(Collectors.toList());
    //In the existing motion list, find the duplicate actions that are the same with m
    for (IMotion existM : groupedMotions) {
      List<Action> actionIntersections = existM.getActionSet().stream()
              .filter(x -> m.getActionSet().contains(x)).collect(Collectors.toList());
      if (actionIntersections.size() > 0 && (m.getT1() < existM.getT2()
              && existM.getT1() <= m.getT1())) {
        return true;
      }
    }
    return false;
  }

  @Override
  public void addMotion(IMotion m) {
    if (checkOverlap(m)) {
      throw new IllegalArgumentException("Action overlap.");
    }
    motionList.add(m);
  }

  @Override
  public List<IShape> getShapeList() {
    return shapeList;
  }

  @Override
  public List<IMotion> getMotionList() {
    return motionList;
  }

  @Override
  public int getTickPerSecond() {
    return this.tickPerSecond;
  }

  @Override
  public int getBoundX() {
    return boundX;
  }

  @Override
  public int getBoundY() {
    return boundY;
  }

  @Override
  public int getBoundWidth() {
    return boundWidth;
  }

  @Override
  public int getBoundHeight() {
    return boundHeight;
  }

  @Override
  public void setBoundX(int boundX) {
    this.boundX = boundX;
  }

  @Override
  public void setBoundY(int boundY) {
    this.boundY = boundY;
  }

  @Override
  public void setBoundWidth(int boundWidth) {
    this.boundWidth = boundWidth;
  }

  @Override
  public void setBoundHeight(int boundHeight) {
    this.boundHeight = boundHeight;
  }


  @Override
  public int longestTime() {
    return motionList.stream()
            .max(Comparator.comparing(IMotion::getT2)).get().getT2();
  }

  @Override
  public String[] getShapeNames() {
    return shapeList.stream().filter(IShape::getVisibility)
            .map(IShape::getName).toArray(String[]::new);
  }

  public void deleteShape(String shapeName) {
    for (IShape shape : shapeList) {
      if (shape.getName().equals(shapeName)) {
        shape.setVisibility(false);
      }
    }
  }


  public double tweenHelper(int start, int end, int startStatus, int endStatus, int tick) {
    return (startStatus * (double) (end - tick) / (double) (end - start)
            + endStatus * (double) (tick - start) / (double) (end - start));
  }

  @Override
  public List<IShape> getCurrentStatus(int t) {

    List<IShape> currentShapes = new ArrayList<>();

    //Group all the motions by the shape name
    Map<String, List<IMotion>> maps = motionList.stream()
            .collect(Collectors.groupingBy(item -> item.getShapeName()));

    //Create a Hash may to get the String name as the Key and IShape object as the value.
    Map<String, IShape> mapping = shapeList.stream()
            .collect(Collectors.toMap(IShape::getName, x -> x));

    //Loop through the maps to and apply the grouped motion to the corresponding shape
    for (var motionEntry : maps.entrySet()) {
      IShape aShape = mapping.get(motionEntry.getKey());

      for (IMotion aMotion : motionEntry.getValue()) {
        int tickCopy = Math.min(aMotion.getT2(), t);
        if (tickCopy >= aMotion.getT1() && tickCopy <= aMotion.getT2()) {
          int x = (int) tweenHelper(aMotion.getT1(), aMotion.getT2(),
                  aMotion.getX1(), aMotion.getX2(), tickCopy);
          int y = (int) tweenHelper(aMotion.getT1(), aMotion.getT2(),
                  aMotion.getY1(), aMotion.getY2(), tickCopy);
          int w = (int) tweenHelper(aMotion.getT1(), aMotion.getT2(),
                  aMotion.getW1(), aMotion.getW2(), tickCopy);
          int h = (int) tweenHelper(aMotion.getT1(), aMotion.getT2(),
                  aMotion.getH1(), aMotion.getH2(), tickCopy);
          int r = (int) tweenHelper(aMotion.getT1(), aMotion.getT2(),
                  aMotion.getR1(), aMotion.getR2(), tickCopy);
          int g = (int) tweenHelper(aMotion.getT1(), aMotion.getT2(),
                  aMotion.getG1(), aMotion.getG2(), tickCopy);
          int b = (int) tweenHelper(aMotion.getT1(), aMotion.getT2(),
                  aMotion.getB1(), aMotion.getB2(), tickCopy);
          aShape.setX(x);
          aShape.setY(y);
          aShape.setW(w);
          aShape.setH(h);
          aShape.setR(r);
          aShape.setG(g);
          aShape.setB(b);
        }
      }
      currentShapes.add(aShape);
    }
    return currentShapes.stream()
            .sorted(Comparator.comparing(x -> x.getShapeOrder())).collect(Collectors.toList());
  }

  /**
   * This class represents an animation builder that implements AnimationBuilder interface.
   */
  public static final class Builder implements AnimationBuilder<IModel> {

    IModel model;

    /**
     * Constructs an animation builder.
     */
    public Builder() {
      model = new Model();
    }

    @Override
    public IModel build() {
      return this.model;
    }

    @Override
    public AnimationBuilder<IModel> setBounds(int x, int y, int width, int height) {
      model.setBoundX(x);
      model.setBoundY(y);
      model.setBoundWidth(width);
      model.setBoundHeight(height);
      return this;
    }

    @Override
    public AnimationBuilder<IModel> declareShape(String name, String type) {

      IShape shape = new Shape(name, type);
      model.addShape(shape);
      return this;
    }

    @Override
    public AnimationBuilder<IModel> addMotion(String name, int t1, int x1, int y1, int w1,
                                              int h1, int r1, int g1, int b1, int t2, int x2,
                                              int y2, int w2, int h2, int r2, int g2, int b2) {
      IMotion motion = new Motion(name, t1, x1, y1, w1, h1, r1, g1, b1,
              t2, x2, y2, w2, h2, r2, g2, b2);

      model.addMotion(motion);

      //Reset the value of the shape
      List<IMotion> motions = model.getMotionList().stream()
              .filter(s -> s.getShapeName().contains(name))
              .collect(Collectors.toList());
      IMotion firstMotion = motions.stream().min(Comparator.comparing(IMotion::getT1)).get();
      IMotion lastMotion = motions.stream().max(Comparator.comparing(IMotion::getT2)).get();

      for (int i = 0; i < model.getShapeList().size(); i++) {
        if (name.equals(model.getShapeList().get(i).getName()) && t1 == firstMotion.getT1()) {
          IShape shape = new Shape(name, model.getShapeList().get(i)
                  .getType(), x1, y1, w1, h1, r1, g1, b1, firstMotion.getT1(), lastMotion.getT2());
          shape.setShapeOrder(model.getShapeList().get(i).getShapeOrder());
          model.getShapeList().set(i, shape);
        }
      }
      return this;
    }
  }
}
