import java.awt.Desktop;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import controller.Controller;
import controller.IController;
import model.AnimationReader;
import model.AnimationBuilder;
import model.Model;
import model.IModel;
import view.EditView;
import view.IView;
import view.ViewFactory;

/**
 * This class has main method for our project.
 */
public final class EasyAnimator {

  /**
   * Constructs a main method.
   *
   * @param args the command line argument to be taken in
   * @throws IOException if filereader cannot read file
   */
  public static void main(String[] args) throws IOException {

    AnimationReader reader = new AnimationReader();
    AnimationBuilder<IModel> builder = new Model.Builder();
    IModel model = new Model();
    String output = "";

    if ((Arrays.stream(args).filter(x -> x.equals("-in")).count() == 0)
            || (Arrays.stream(args).filter(x -> x.equals("-view")).count() == 0)) {

      JFrame frame = new JFrame();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setLocation(100,100);
      frame.setSize(100,100);

      JOptionPane.showMessageDialog(frame,
              "Invalid comment line input",
              "Error",
              JOptionPane.ERROR_MESSAGE);
    }

    for (int i = 0; i < args.length; i++) {
      if (args[i].equals("-in")) {
        //create instances whichever the appropriate view,
        // create a file reader (built-in), pass that to the animation reader
        Readable readable = new FileReader(args[i + 1]);
        model = reader.parseFile(readable, builder);
      }
    }

    int tickPerSecond = 1;
    for (int i = 0; i < args.length; i++) {
      if (args[i].equals("-speed")) {
        int speed = Integer.parseInt(args[i + 1]);
        tickPerSecond = speed;
      }
    }

    for (int i = 0; i < args.length; i++) {
      if (args[i].equals("-view")) {
        IView outputView = ViewFactory.makeView(args[i + 1], model, tickPerSecond);
        IController controller = new Controller((Model) model, outputView, tickPerSecond);
//        controller.setView();
        if (args[i + 1].equals("visual")) {
          controller.setView();
          outputView.showVisual();
        }
        else if (args[i + 1].equals("playback")) {
          controller.setView();
        }
        else {
          output = outputView.showView();
        }
      }
    }

    boolean hasOut = false;
    for (int i = 0; i < args.length; i++) {
      if (args[i].equals("-out")) {
        File file = new File(args[i + 1]);
        FileWriter fileWriter = new FileWriter(file);
        fileWriter.write(output);
        fileWriter.close();
        Desktop desktop = Desktop.getDesktop();
        desktop.open(file);
        hasOut = true;
      }
    }
    if (!hasOut) {
      System.out.println(output);
    }
  }
}
