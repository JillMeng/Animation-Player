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

public class EditView extends JFrame implements IView, ItemListener, ListSelectionListener {

  private JButton startButton, pauseButton, resumeButton, restartButton, enableLoopingButton,
          disableLoopingButton, increaseSpeedButton, decreaseSpeedButton;

  MyPanel panel;
  IModel model;
  int tickPerSecond;



  public EditView(IModel model, int tickPerSecond) {
    super();
    this.model = model;
    this.tickPerSecond = tickPerSecond;
    panel = new MyPanel(model, tickPerSecond);
    panel.getTimer().stop();
    panel.setVisible(false);
//    panel = new MyPanel(model);
//    this.panel = new MyPanel(model);
//    this.timer = panel.getTimer();

    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLocation(this.model.getBoundX(), this.model.getBoundY());
    this.setSize(this.model.getBoundWidth(), this.model.getBoundHeight());

    this.setLayout(new FlowLayout());

    // start button
    startButton = new JButton("Start");
    startButton.setActionCommand("Start Button");
    this.add(startButton);

    // pause button
    pauseButton = new JButton("Pause");
    pauseButton.setActionCommand("Pause Button");
    this.add(pauseButton);

    // resume button
    resumeButton = new JButton("Resume");
    resumeButton.setActionCommand("Resume Button");
    this.add(resumeButton);

    // restart button
    restartButton = new JButton("Restart");
    restartButton.setActionCommand("Restart Button");
    this.add(restartButton);

    // enable looping button
    enableLoopingButton = new JButton("Enable Looping");
    enableLoopingButton.setActionCommand("Enable Looping Button");
    this.add(enableLoopingButton);

    // disable looping button
    disableLoopingButton = new JButton("Disable Looping");
    disableLoopingButton.setActionCommand("Disable Looping Button");
    this.add(disableLoopingButton);

    // increase speed button
    increaseSpeedButton = new JButton("Increase Speed");
    increaseSpeedButton.setActionCommand("Increase Speed Button");
    this.add(increaseSpeedButton);

    // decrease speed button
    decreaseSpeedButton = new JButton("Decrease Speed");
    decreaseSpeedButton.setActionCommand("Decrease Speed Button");
    this.add(decreaseSpeedButton);

    this.getContentPane().add(panel, BorderLayout.CENTER);
    this.pack();
    this.setVisible(true);

    JScrollPane scrollPane = new JScrollPane(panel);
    this.add(scrollPane);
    scrollPane.setVisible(true);

//    //button panel
//    buttonPanel = new JPanel();
//    buttonPanel.setLayout(new FlowLayout());
//    this.add(buttonPanel, BorderLayout.SOUTH);
//
//    //input textfield
//    input = new JTextField(15);
//    buttonPanel.add(input);
//
//    //buttons
//    commandButton = new JButton("Execute");
//    buttonPanel.add(commandButton);
//
//    //quit button
//    quitButton = new JButton("Quit");
//    quitButton.addActionListener((ActionEvent e) -> System.exit(0));
//    buttonPanel.add(quitButton);

    this.pack();


  }

  public void addFeatures(IController features) {
    startButton.addActionListener(evt -> features.start());
    pauseButton.addActionListener(evt -> features.pause());
    resumeButton.addActionListener(evt -> features.resume());
    restartButton.addActionListener(evt -> features.restart());
    enableLoopingButton.addActionListener(evt -> features.enableLooping());
    disableLoopingButton.addActionListener(evt -> features.disableLooping());
    increaseSpeedButton.addActionListener(evt -> features.increaseSpeed());
    decreaseSpeedButton.addActionListener(evt -> features.decreaseSpeed());
  }

  public void makeVisible() {
    this.setVisible(true);
  }

  public void refresh() {
    this.repaint();
  }

  @Override
  public String showView() {
    throw new UnsupportedOperationException("Cannot perform such operation.");
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


  @Override
  public void showErrorMessage(String error) {
    JOptionPane.showMessageDialog(this,error,"Error",JOptionPane.ERROR_MESSAGE);
  }

  @Override
  public void itemStateChanged(ItemEvent e) {

  }

  @Override
  public void valueChanged(ListSelectionEvent e) {

  }

  public void setPanel(MyPanel panel) {
    this.panel = panel;
  }

  public MyPanel getPanel() {
    return panel;
  }

//  @Override
//  public void setTickPerSecond(int tickPerSecond) {
//    this.tickPerSecond = tickPerSecond;
//  }

//  public Timer getTimer() {
//    return timer;
//  }
}
