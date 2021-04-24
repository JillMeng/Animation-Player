package view;

import java.awt.*;

import javax.swing.*;

import controller.IController;
import model.IModel;

/**
 * This view class implements IView interface and build a frame where all the UI panel and features
 * are added.
 */
public class EditView extends JFrame implements IView {

  private JButton startButton, pauseButton, resumeButton, restartButton,
          increaseSpeedButton, decreaseSpeedButton, deleteShapeButton;
  private MyPanel panel;
  private JPanel buttonPanel;
  private JScrollPane scrollPane;
  private final IModel model;
  private int tickPerSecond;
  private JCheckBox checkBox;
  private JLabel speedLabel;
  private JComboBox shapeBox;


  public EditView(IModel model, int tickPerSecond) {
    super();
    this.model = model;
    this.tickPerSecond = tickPerSecond;

    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLocation(this.model.getBoundX(), this.model.getBoundY());
    this.setSize(this.model.getBoundWidth(), this.model.getBoundHeight());

    //use a borderlayout with drawing panel in center and button panel in south
    this.setLayout(new BorderLayout());
    panel = new MyPanel(model, tickPerSecond);
    panel.setPreferredSize(new Dimension(model.getBoundWidth(), model.getBoundHeight()));
    this.add(panel, BorderLayout.CENTER);

    //scrollPane
    scrollPane = new JScrollPane(panel);
    this.add(scrollPane);
    scrollPane.setVisible(true);

    //button panel
    buttonPanel = new JPanel();
    buttonPanel.setLayout(new FlowLayout());
    this.add(buttonPanel, BorderLayout.SOUTH);

    //input text field
    shapeBox = new JComboBox<String>(model.getShapeNames());
    buttonPanel.add(shapeBox);

    // delete shape
    deleteShapeButton = new JButton("Delete");
    deleteShapeButton.setActionCommand("Delete Shape Button");
    buttonPanel.add(deleteShapeButton);

    //checkboxes
    checkBox = new JCheckBox("Enable looping ");
    checkBox.setActionCommand("Enable looping");
    buttonPanel.add(checkBox);

    // start button
    startButton = new JButton("Start");
    startButton.setActionCommand("Start Button");
    buttonPanel.add(startButton);

    // pause button
    pauseButton = new JButton("Pause");
    pauseButton.setActionCommand("Pause Button");
    buttonPanel.add(pauseButton);

    // resume button
    resumeButton = new JButton("Resume");
    resumeButton.setActionCommand("Resume Button");
    buttonPanel.add(resumeButton);

    // restart button
    restartButton = new JButton("Restart");
    restartButton.setActionCommand("Restart Button");
    buttonPanel.add(restartButton);

    // increase speed button
    increaseSpeedButton = new JButton("Accelerate");
    increaseSpeedButton.setActionCommand("Increase Speed Button");
    buttonPanel.add(increaseSpeedButton);

    // decrease speed button
    decreaseSpeedButton = new JButton("Decelerate");
    decreaseSpeedButton.setActionCommand("Decrease Speed Button");
    buttonPanel.add(decreaseSpeedButton);

    speedLabel = new JLabel("Current Speed:" + (this.tickPerSecond));
    buttonPanel.add(speedLabel);

    this.pack();
    this.setVisible(true);
  }

  public void addFeatures(IController features) {
    startButton.addActionListener(evt -> features.start());
    pauseButton.addActionListener(evt -> features.pause());
    resumeButton.addActionListener(evt -> features.resume());
    restartButton.addActionListener(evt -> features.restart());
    increaseSpeedButton.addActionListener(evt -> {
      tickPerSecond += 5;
      speedLabel.setText("Speed:" + (this.tickPerSecond));
      features.setTickPerSecond(tickPerSecond);
    });
    decreaseSpeedButton.addActionListener(evt -> {
      if (tickPerSecond > 5) {
        tickPerSecond -= 5;
      }
      speedLabel.setText("Speed:" + (this.tickPerSecond));
      features.setTickPerSecond(tickPerSecond);
    });
    checkBox.addActionListener(evt -> {
      features.enableLooping(checkBox.isSelected());
    });
    deleteShapeButton.addActionListener(evt -> {
      features.deleteShape(shapeBox.getSelectedItem().toString());
      shapeBox.removeItem(shapeBox.getSelectedItem().toString());
    });
  }

  public void makeVisible() {
    panel.setVisible(true);
  }

  public void refresh() {
    panel.repaint();
  }

  public void draw(int tick) {
    panel.drawShapes(tick);
  }

  @Override
  public String showView() {
    throw new UnsupportedOperationException("Cannot perform such operation.");
  }

  @Override
  public void showVisual() {
    throw new UnsupportedOperationException("Cannot perform such operation.");
  }

}
