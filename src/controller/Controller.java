package controller;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

import javax.swing.*;

import model.AnimationBuilder;
import model.AnimationReader;
import model.IModel;
import model.Model;
import view.EditView;
import view.IView;
import view.MyPanel;
import view.ViewFactory;

public class Controller extends JPanel implements IController {

  private Model model;
  private EditView view;
  private Timer timer;
  private int tick = 0;
  private MyPanel panel;
  boolean looping;

  /**
   * Construct the controller that can take in a model and show a view.
   * @param model a non-null animation Model
   */
  public Controller(Model model, EditView view, int tickPerSecond) {
    this.model = model;
    this.view = view;
    this.looping = false;

    timer = new Timer(1000 / tickPerSecond, new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        if (tick >= model.longestTime()) {
          if (!looping){
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
//    view.getPanel().getTimer().stop();
    timer.stop();
  }

  @Override
  public void resume() {
//    view.getPanel().getTimer().restart();
    timer.restart();
  }

  @Override
  public void restart() {
//    view.getPanel().getTimer().start();
//    view.getPanel().getTimer().setDelay(1000 / view.getPanel().getTickPerSecond());
//    view.getPanel().setTick(0);
    tick = 0;
    timer.restart();
  }

  @Override
  public void enableLooping(boolean isLooping) {
    looping = isLooping;
    if (!timer.isRunning()){
      timer.start();
    }
  }

  @Override
  public void setTickPerSecond(int tickPerSecond){
    this.timer.setDelay(1000/tickPerSecond);
  }

  @Override
  public void deleteShape(String shapeName) {
    model.deleteShape(shapeName);
  }
}
