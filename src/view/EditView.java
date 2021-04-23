package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import controller.IController;
import model.IModel;

public class EditView extends JFrame implements IView {

  private JButton startButton, pauseButton, resumeButton, restartButton, enableLoopingButton,
          disableLoopingButton, increaseSpeedButton, decreaseSpeedButton;

  private MyPanel panel;
  private JPanel buttonPanel;
  private JScrollPane scrollPane;
  private final IModel model;
  private int tickPerSecond;
  private JTextField input;
  private JCheckBox checkBox;


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

    //input textfield
    input = new JTextField(15);
    buttonPanel.add(input);

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

//    // enable looping button
//    enableLoopingButton = new JButton("Enable Looping");
//    enableLoopingButton.setActionCommand("Enable Looping Button");
//    this.add(enableLoopingButton);
//
//    // disable looping button
//    disableLoopingButton = new JButton("Disable Looping");
//    disableLoopingButton.setActionCommand("Disable Looping Button");
//    this.add(disableLoopingButton);

    // increase speed button
    increaseSpeedButton = new JButton("Accelerate");
    increaseSpeedButton.setActionCommand("Increase Speed Button");
    buttonPanel.add(increaseSpeedButton);

    // decrease speed button
    decreaseSpeedButton = new JButton("Decelerate");
    decreaseSpeedButton.setActionCommand("Decrease Speed Button");
    buttonPanel.add(decreaseSpeedButton);

    this.pack();
    this.setVisible(true);
  }

  public void addFeatures(IController features) {
    startButton.addActionListener(evt -> features.start());
    pauseButton.addActionListener(evt -> features.pause());
    resumeButton.addActionListener(evt -> features.resume());
    restartButton.addActionListener(evt -> features.restart());
//    enableLoopingButton.addActionListener(evt -> features.enableLooping());
//    disableLoopingButton.addActionListener(evt -> features.disableLooping());
    increaseSpeedButton.addActionListener(evt -> features.increaseSpeed());
    decreaseSpeedButton.addActionListener(evt -> features.decreaseSpeed());
    checkBox.addActionListener(evt -> features.enableLooping());
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
  }

  @Override
  public void showErrorMessage(String error) {
    JOptionPane.showMessageDialog(this, error, "Error", JOptionPane.ERROR_MESSAGE);
  }


}
