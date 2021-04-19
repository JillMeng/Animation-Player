package view;

import java.awt.Dimension;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Graphics2D;
import java.awt.Graphics;

import javax.swing.JPanel;
import javax.swing.Timer;

import model.IModel;
import model.IShape;

/**
 * This class represents a panel that is used to draw all the shapes at a given time point.
 */
public class MyPanel extends JPanel {
  private IModel model;
  private Timer timer;
  private int tick = 0;

  /**
   * Constructs a panel using given model.
   *
   * @param model the model used to construct the panel
   */
  public MyPanel(IModel model) {
    this.model = model;
    this.setPreferredSize(new Dimension(model.getBoundWidth(),model.getBoundHeight()));
    this.setBackground(Color.WHITE);

    timer = new Timer(1000 / model.getTickPerSecond(), new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        if (tick >= model.longestTime()) {
          timer.stop();
          return;
        }
        tick++;
        repaint();
      }
    });

    timer.setRepeats(true);
    timer.start();
  }

  /**
   * Draw all the shapes from the model at a time point.
   *
   * @param g the graphic to be paint
   */
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D graphics2D = (Graphics2D) g;
    //Draw all the shapes from the model at tick
    for (IShape shape : model.getCurrentStatus(tick)) {
      graphics2D.setColor(shape.getRGB());
      switch (shape.getType()) {
        case "rectangle":
          graphics2D.fillRect(shape.getX(), shape.getY(), shape.getW(), shape.getH());
          break;
        case "oval":
        case "ellipse":
          graphics2D.fillOval(shape.getX(), shape.getY(), shape.getW(), shape.getH());
          break;
        default:
          throw new IllegalArgumentException("Cannot draw such shape.");
      }
    }
  }
}
