package model;

import java.util.HashSet;
import java.util.Set;

/**
 * This class represents a motion in the animation that implements all the operations from IMotion.
 */
public class Motion implements IMotion {

  private String name;
  private int t1;
  private int x1;
  private int y1;
  private int w1;
  private int h1;
  private int r1;
  private int g1;
  private int b1;
  private int t2;
  private int x2;
  private int y2;
  private int w2;
  private int h2;
  private int r2;
  private int g2;
  private int b2;

  /**
   * Consctructs a motion using shape's name, start time, start x-position, start y-position,
   * start width, start height, start r-component of color, start g-component of color,
   * start b-component of color, end time, end x-position, end y-position,
   * end width, end height, end r-component of color, end g-component of color,
   * end b-component of color.
   *
   * @param name name of shape that has the motion
   * @param t1 start time of the motion
   * @param x1 start x-position of the shape
   * @param y1 start y-position of the shape
   * @param w1 start width of the shape
   * @param h1 start height of the shape
   * @param r1 start r-component of color of the shape
   * @param g1 start g-component of color of the shape
   * @param b1 start b-component of color of the shape
   * @param t2 end time of the motion
   * @param x2 end x-position of the shape
   * @param y2 end y-position of the shape
   * @param w2 end width of the shape
   * @param h2 end height of the shape
   * @param r2 end r-component of color of the shape
   * @param g2 end g-component of color of the shape
   * @param b2 end b-component of color of the shape
   */
  public Motion(String name,
                        int t1, int x1, int y1, int w1, int h1, int r1, int g1, int b1,
                        int t2, int x2, int y2, int w2, int h2, int r2, int g2, int b2) {
    this.name = name;
    this.t1 = t1;
    this.x1 = x1;
    this.y1 = y1;
    this.w1 = w1;
    this.h1 = h1;
    this.r1 = r1;
    this.g1 = g1;
    this.b1 = b1;
    this.t2 = t2;
    this.x2 = x2;
    this.y2 = y2;
    this.w2 = w2;
    this.h2 = h2;
    this.r2 = r2;
    this.g2 = g2;
    this.b2 = b2;
  }

  @Override
  public String printMotion() {
    if (this.x1 != this.x1 || this.y1 != this.y2) {
      return String.format("%s moves from (%d, %d) to (%d, %d) from time t=%d to t=%d",
              this.name, x1, y1, x2, y2, t1, t2);
    }
    if (this.r1 != this.r2 || this.g1 != this.g2 || this.b1 != this.b2) {
      return String.format("%s changes from rgb(%d,%d,%d) to rgb(%d,%d,%d) from time t=%d to t=%d",
              this.name, this.r1, this.g1, this.b1,
              this.r2, this.g2, this.b2, t1, t2);
    }
    if (this.w1 != this.w2) {
      return String.format("%s changes width from %d to %d from time t=%d to t=%d",
              this.name, w1, w2, t1, t2);
    }
    if (this.h1 != this.h2) {
      return String.format("%s changes height from %d to %d from time t=%d to t=%d",
              this.name, h1, h2, t1, t2);
    }
    return "";
  }

  @Override
  public Set<Action> getActionSet() {
    var results = new HashSet<Action>();

    if (this.r1 != this.r2 || this.g1 != this.g2 || this.b1 != this.b2) {
      results.add(Action.ChangeColor);
    }
    if (this.x1 != this.x2 || this.y1 != this.y2) {
      results.add(Action.ChangePosition);
    }
    if (this.w1 != this.w2 || this.h1 != this.h2) {
      results.add(Action.ChangeScale);
    }
    return results;
  }

  @Override
  public String getShapeName() {
    return name;
  }

  @Override
  public int getT1() {
    return t1;
  }

  @Override
  public int getX1() {
    return x1;
  }

  @Override
  public int getY1() {
    return y1;
  }

  @Override
  public int getW1() {
    return w1;
  }

  @Override
  public int getH1() {
    return h1;
  }

  @Override
  public int getR1() {
    return r1;
  }

  @Override
  public int getG1() {
    return g1;
  }

  @Override
  public int getB1() {
    return b1;
  }

  @Override
  public int getT2() {
    return t2;
  }

  @Override
  public int getX2() {
    return x2;
  }

  @Override
  public int getY2() {
    return y2;
  }

  @Override
  public int getW2() {
    return w2;
  }

  @Override
  public int getH2() {
    return h2;
  }

  @Override
  public int getR2() {
    return r2;
  }

  @Override
  public int getG2() {
    return g2;
  }

  @Override
  public int getB2() {
    return b2;
  }
}
