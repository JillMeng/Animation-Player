package view;

import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;

import controller.IController;
import model.IModel;

/**
 * This class represents a visual view that implements IView interface.
 */
public class VisualView implements IView {

  MyPanel panel;
  IModel model;
  int tickPerSecond;

  /**
   * Constructs a visual view using given model.
   *
   * @param model1 the given model used to construct a visual view
   */
  public VisualView(IModel model1, int tickPerSecond) {
    super();
    this.tickPerSecond = tickPerSecond;
    panel = new MyPanel(model1, tickPerSecond);
    model = model1;
  }

  @Override
  public String showView() {
    throw new UnsupportedOperationException("This operation is unsupported.");
  }

  @Override
  public void showVisual() {
    SwingUtilities.invokeLater(() -> {
      visualGo();
    });
  }

  @Override
  public void showErrorMessage(String error) {

  }

  @Override
  public void addFeatures(IController features) {

  }

  @Override
  public void setPanel(MyPanel panel) {

  }

  @Override
  public MyPanel getPanel() {
    return null;
  }

//  @Override
//  public int getTickPerSecond() {
//    return this.tickPerSecond;
//  }

//  @Override
//  public void setTickPerSecond(int tickPerSecond) {
//    this.tickPerSecond = tickPerSecond;
//  }

  /**
   * Used to show the visual view.
   */
  public void visualGo() {

    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLocation(model.getBoundX(),model.getBoundY());
    frame.setSize(model.getBoundWidth(),model.getBoundHeight());

    frame.getContentPane().add(panel, BorderLayout.CENTER);
    frame.pack();
    frame.setVisible(true);

    JScrollPane scrollPane = new JScrollPane(panel);
    frame.add(scrollPane);
    scrollPane.setVisible(true);

  }
}
