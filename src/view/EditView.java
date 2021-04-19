package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import model.IModel;

public class EditView extends JFrame implements IView, ItemListener, ListSelectionListener {

  MyPanel panel;
  IModel model;


  public EditView(IModel model) {
    super();
    panel = new MyPanel(model);
    this.model = model;

    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLocation(this.model.getBoundX(), this.model.getBoundY());
    this.setSize(this.model.getBoundWidth(), this.model.getBoundHeight());

    this.getContentPane().add(panel, BorderLayout.CENTER);
    this.pack();
//    this.setVisible(true);

    JScrollPane scrollPane = new JScrollPane(panel);
    this.add(scrollPane);
//    scrollPane.setVisible(true);

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
}
