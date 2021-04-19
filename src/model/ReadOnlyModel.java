package model;

import java.util.List;

public class ReadOnlyModel implements IModel{
  @Override
  public List<IShape> getShapeList() {
    return null;
  }

  @Override
  public List<IMotion> getMotionList() {
    return null;
  }

  @Override
  public int getTickPerSecond() {
    return 0;
  }

  @Override
  public List<IShape> getCurrentStatus(int i) {
    return null;
  }

  @Override
  public int getBoundX() {
    return 0;
  }

  @Override
  public int getBoundY() {
    return 0;
  }

  @Override
  public int getBoundWidth() {
    return 0;
  }

  @Override
  public int getBoundHeight() {
    return 0;
  }

  @Override
  public int longestTime() {
    return 0;
  }
}
