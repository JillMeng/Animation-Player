package controller;


import javax.swing.*;

public interface IController {
  void setView();
  void start();
  void pause();
  void resume();
  void restart();
  void enableLooping(boolean isLooping);
  void setTickPerSecond(int tickPerSecond);
  void deleteShape(String shapeName);
  Timer getTimer();
}
