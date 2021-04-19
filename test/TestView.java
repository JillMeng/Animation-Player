import org.junit.Test;

import model.IModel;
import model.Model;
import model.Shape;
import model.Motion;
import view.IView;
import view.SVGView;
import view.TextualView;

import static org.junit.Assert.assertEquals;

/**
 * This class represents all the unit tests for textual view and svg view.
 */
public class TestView {

  IView textView;
  IView svgView;

  @Test
  public void testTextView() {
    Shape r = new Shape("R", "rectangle", 200, 200, 50, 100,
            1, 0, 0, 1, 100);
    Shape c = new Shape("C", "oval", 500, 100, 60, 30,
            0, 0, 1, 6, 100);
    Motion move = new Motion("R", 10, 200,
            200, 50, 100, 1, 0, 0, 50, 300, 300,
            50, 100, 1, 0, 0);
    IModel model = new Model();
    model.addShape(r);
    model.addShape(c);
    model.addMotion(move);
    textView = new TextualView(model);

    assertEquals("Create rgb(1,0,0) rectangle R with corner at (200, 200), "
                    + "width 50 and height 100\n"
                    + "Create rgb(0,0,1) oval C with center at (500, 100), radius 60 and 30\n\n"
                    + "R appears at time t=1 and disappears at time t=100\n"
                    + "C appears at time t=6 and disappears at time t=100\n\n"
                    + "R moves from (200, 200) to (300, 300) from time t=10 to t=50",
            textView.showView());
  }

  @Test
  public void testSVGView() {
    Shape r = new Shape("R", "rectangle", 200, 200, 50, 100,
            1, 0, 0, 1, 100);
    Shape c = new Shape("C", "oval", 500, 100, 60, 30,
            0, 0, 1, 6, 100);
    Motion move = new Motion("R", 10, 200,
            200, 50, 100, 1, 0, 0, 50, 300, 300,
            50, 100, 1, 0, 0);
    Motion move1 = new Motion("C", 20, 500, 100, 60, 30,
            0, 0, 1, 30, 600, 100, 60, 30, 0, 0, 1);
    Motion move2 = new Motion("C", 20, 500, 100, 60, 30,
            0, 0, 1, 30, 600, 400, 60, 30, 0, 0, 1);
    IModel model = new Model();
    model.addShape(r);
    model.addShape(c);
    model.addMotion(move);
    model.setTickPerSecond(20);
    svgView = new SVGView(model);
    assertEquals("<svg width=\"1000\" height=\"1000\" version=\"1.1\" "
            + "xmlns=\"http://www.w3.org/2000/svg\">\n" + "\n"
            + "<rect id=\"R\" x=\"200\" y=\"200\" width=\"50\" height=\"100\" "
            + "fill=\"rgb(1,0,0)\" from=\"50ms\" dur=\"4950ms\" visibility=\"hidden\" >\n" +
            "\n" +
            "\t<animate attributeType=\"xml\" begin=\"500ms\" dur=\"2000ms\" attributeName=\"x\" "
            + "from=\"200\" to=\"300\" fill=\"freeze\" />\n" +
            "\n" +
            "\t<animate attributeType=\"xml\" begin=\"500ms\" dur=\"2000ms\" attributeName=\"y\" "
            + "from=\"200\" to=\"300\" fill=\"freeze\" />\n" +
            "\n" +
            "\t<set attributeType=\"xml\" begin=\"500ms\" dur=\"2000ms\" "
            + "attributeName=\"visibility\" from=\"hidden\" to=\"visible\" fill=\"freeze\" />\n" +
            "\n" +
            "</rect>\n" +
            "\n" +
            "<ellipse id=\"C\" cx=\"500\" cy=\"100\" rx=\"30\" ry=\"15\" fill=\"rgb(0,0,1)\" "
            + "from=\"300ms\" dur=\"4700ms\" visibility=\"hidden\" >\n" +
            "\n" +
            "</ellipse>\n" +
            "\n" +
            "</svg>", svgView.showView());
  }
}
