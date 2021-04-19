import org.junit.Before;
import org.junit.Test;

import model.IModel;
import model.ReadWriteModel;
import model.Motion;
import model.Shape;
import view.IView;
import view.TextualView;

import static org.junit.Assert.assertEquals;

/**
 * This class represents all the unit tests for IModel interface.
 */
public class TestModel {

  private IModel model;

  @Before
  public void setup() {
    model = new ReadWriteModel();
  }

  @Test
  public void testAddShape() {
    Shape r = new Shape("R", "rectangle", 200, 200, 50, 100,
            1, 0, 0, 1, 100);
    Shape c = new Shape("C", "oval", 500, 100, 60, 30,
            0, 0, 1, 6, 100);
    Motion move = new Motion("R", 10, 200,
            200, 50, 100, 1, 0, 0, 50, 300, 300,
            50, 100, 1, 0, 0);
    model.addShape(r);
    model.addShape(c);
    model.addMotion(move);
    IView textView = new TextualView(model);

    assertEquals("Create rgb(1,0,0) rectangle R with corner at (200, 200), "
                    + "width 50 and height 100\n"
                    + "Create rgb(0,0,1) oval C with center at (500, 100), radius 60 and 30\n"
                    + "\n"
                    + "R appears at time t=1 and disappears at time t=100\n"
                    + "C appears at time t=6 and disappears at time t=100\n"
                    + "\n"
                    + "R moves from (200, 200) to (300, 300) from time t=10 to t=50",
            textView.showView());
  }

  @Test
  public void testGetCurrentStatus() {
    Shape r = new Shape("R", "rectangle", 200, 200, 50, 100,
            1, 0, 0, 1, 100);
    Shape c = new Shape("C", "oval", 500, 100, 60, 30,
            0, 0, 1, 6, 100);
    Motion move = new Motion("R", 10, 200,
            200, 50, 100, 1, 0, 0, 50, 300, 300,
            50, 100, 1, 0, 0);

    model.addShape(r);
    model.addShape(c);
    model.addMotion(move);

    assertEquals("R", model.getCurrentStatus(30).get(0).getName());
    assertEquals(250, model.getCurrentStatus(30).get(0).getX());
    assertEquals(250, model.getCurrentStatus(30).get(0).getY());

  }


  @Test(expected = IllegalArgumentException.class)
  public void actionPositionOverlap() {
    Shape r = new Shape("R", "rectangle", 200, 200, 50, 100,
            1, 0, 0, 1, 100);
    Shape c = new Shape("C", "oval", 500, 100, 60, 30,
            0, 0, 1, 6, 100);
    Motion move1 = new Motion("R", 10, 200,
            200, 50, 100, 1, 0, 0, 50, 300, 300,
            50, 100, 1, 0, 0);
    Motion move2 = new Motion("R", 20, 300,
            300, 50, 100, 1, 0, 0, 90, 600, 600,
            50, 100, 1, 0, 0);

    model.addShape(r);
    model.addShape(c);
    model.addMotion(move1);
    model.addMotion(move2);
  }

  @Test(expected = IllegalArgumentException.class)
  public void actionPositionColorOverlap() {
    Shape r = new Shape("R", "rectangle", 200, 200, 50, 100,
            1, 0, 0, 1, 100);
    Shape c = new Shape("C", "oval", 500, 100, 60, 30,
            0, 0, 1, 6, 100);
    Motion changeColor1 = new Motion("R", 10, 200,
            200, 50, 100, 1, 0, 0, 50, 300, 300,
            50, 100, 255, 0, 0);
    Motion changeColor2 = new Motion("R", 30, 300,
            300, 50, 100, 1, 0, 0, 90, 600, 600,
            50, 100, 0, 255, 0);

    model.addShape(r);
    model.addShape(c);
    model.addMotion(changeColor1);
    model.addMotion(changeColor2);
  }

  @Test(expected = IllegalArgumentException.class)
  public void actionPositionScaleOverlap() {
    Shape r = new Shape("R", "rectangle", 200, 200, 50, 100,
            1, 0, 0, 1, 100);
    Shape c = new Shape("C", "oval", 500, 100, 60, 30,
            0, 0, 1, 6, 100);
    Motion changePositionColor1 = new Motion("R", 10, 200,
            200, 100, 100, 255, 0, 0, 50, 300, 300,
            50, 100, 255, 0, 0);
    Motion changePositionColor2 = new Motion("R", 30, 300,
            300, 50, 100, 1, 0, 0, 90, 600, 600,
            80, 100, 1, 0, 0);

    model.addShape(r);
    model.addShape(c);
    model.addMotion(changePositionColor1);
    model.addMotion(changePositionColor2);
  }

}



