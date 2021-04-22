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

  private IModel model;
  private IView view;
  private Timer timer;
  private int tickPerSecond;
  private int tick = 0;
  private MyPanel panel;
  boolean looping;

  /**
   * Construct the controller that can take in a model and show a view.
   * @param model a non-null animation Model
   */
  public Controller(IModel model, int tickPerSecond) {
    this.model = model;
    this.tickPerSecond = tickPerSecond;
    this.looping = false;
  }

  public void setView(IView view) {
    this.view = view;
//    view.setTickPerSecond(tickPerSecond);
    view.addFeatures(this);

  }

  @Override
  public void start() {
    view.getPanel().setVisible(true);
    view.getPanel().getTimer().start();
  }

  @Override
  public void pause() {
    view.getPanel().getTimer().stop();
  }

  @Override
  public void resume() {
    view.getPanel().getTimer().restart();
  }

  @Override
  public void restart() {
    view.getPanel().getTimer().start();
    view.getPanel().getTimer().setDelay(1000 / view.getPanel().getTickPerSecond());
    view.getPanel().setTick(0);
  }

  @Override
  public void enableLooping() {

  }

  @Override
  public void disableLooping() {

  }

  @Override
  public void increaseSpeed() {
    view.getPanel().getTimer().setDelay(view.getPanel().getTickPerSecond() + 1);
  }

  @Override
  public void decreaseSpeed() {
    view.getPanel().getTimer().setDelay(1000 / view.getPanel().getTickPerSecond() - 1);
  }

  //callback to reset the view
//  @Override
//  public void go() {
//    this.view.setCommandButtonListener(this);
//    this.view.makeVisible();
//  }
//  @Override
//  public void processInput(String text) {
//    model.setString(text);
//
//    // clear input text field
//    view.clearInputString();
//    // finally echo the string in view
//    view.setEchoOutput(model.getString());
//
//    // set focus back to main frame so that keyboard events work
//    view.resetFocus();
//
//  }

  //Use action performed to callback/reset view command
  //  @Override
  //  public void actionPerformed(ActionEvent e) {
  //    String command = view.getTurtleCommand();
  //    String status;
  //
  //    try {
  //      status = processCommand(command);
  //    }
  //    catch (Exception ex) {
  //      view.showErrorMessage(ex.getMessage());
  //    }
  //    view.setLines(model.getLines());
  //    //set turtle position and heading
  //    view.setTurtlePosition(model.getPosition());
  //    view.setTurtleHeading(model.getHeading());
  //    view.refresh();
  //  }

//  timer = new Timer(1000 / model.getTickPerSecond(), new ActionListener() {
//    @Override
//    public void actionPerformed(ActionEvent e) {
//      if (tick >= model.longestTime()) {
//        timer.stop();
//        return;
//      }
//      tick++;
//      repaint();
//    }
//  });
//
//    timer.setRepeats(true);
//    timer.start();

}
