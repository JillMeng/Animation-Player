package controller;

import view.IView;

public interface IController {
  void setView(IView view);
  void start();
  void pause();
  void resume();
  void restart();
  void enableLooping();
  void disableLooping();
  void increaseSpeed();
  void decreaseSpeed();
}
