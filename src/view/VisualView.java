package view;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;

import model.IModel;

/**
 * This class represents a visual view that implements IView interface.
 */
public class VisualView implements IView {

  MyPanel panel;
  IModel model;

  /**
   * Constructs a visual view using given model.
   *
   * @param model1 the given model used to construct a visual view
   */
  public VisualView(IModel model1) {
    super();
    panel = new MyPanel(model1);
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
