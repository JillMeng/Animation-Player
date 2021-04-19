package controller;

import java.awt.event.ActionEvent;

import javax.swing.*;

import model.IModel;
import view.IView;

public class Controller implements IController{

  private final IModel model;
  private final IView view;
  private Timer timer;
  private int tick = 0;

  /**
   * Construct the controller that can take in a model and show a view.
   * @param model a non-null animation Model
   * @param view the view
   */
  public Controller(IModel model, IView view) {
    this.model = model;
    this.view = view;
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
