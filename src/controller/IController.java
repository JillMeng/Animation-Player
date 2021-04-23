package controller;


public interface IController {
  void setView();
  void start();
  void pause();
  void resume();
  void restart();
  void enableLooping();
  void increaseSpeed();
  void decreaseSpeed();
}
