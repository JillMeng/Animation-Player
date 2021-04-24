package controller;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import model.Model;
import view.IView;

/**
 * A controller class that includes all the methods listed in the IController interface.
 */
public class Controller extends JPanel implements IController {

  private Model model;
  private IView view;
  private Timer timer;
  private int tick = 0;
  boolean looping;

  /**
   * Construct the controller that can take in a model and show a view.
   *
   * @param model a non-null animation Model
   */
  public Controller(Model model, IView view, int tickPerSecond) {
    this.model = model;
    this.view = view;
    this.looping = false;

    timer = new Timer(1000 / tickPerSecond, new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        if (tick >= model.longestTime()) {
          if (!looping) {
            timer.stop();
            return;
          } else {
            tick = 0;
          }
        }
        view.draw(tick++);
        view.refresh();
      }
    });
  }

  @Override
  public void setView() {
    view.addFeatures(this);
  }

  @Override
  public void start() {
    view.makeVisible();
    timer.start();
  }

  @Override
  public void pause() {
    timer.stop();
  }

  @Override
  public void resume() {
    timer.restart();
  }

  @Override
  public void restart() {
    tick = 0;
    timer.restart();
  }

  @Override
  public void enableLooping(boolean isLooping) {
    looping = isLooping;
    if (!timer.isRunning()) {
      timer.start();
    }
  }

  @Override
  public void setTickPerSecond(int tickPerSecond) {
    this.timer.setDelay(1000 / tickPerSecond);
  }

  @Override
  public void deleteShape(String shapeName) {
    model.deleteShape(shapeName);
  }

  public Timer getTimer() {
    return this.timer;
  }

}
