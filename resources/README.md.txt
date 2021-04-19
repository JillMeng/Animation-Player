# Model
For our model, we created three interfaces, which are IShape, IAction and IStatus.
## IShape, AbstractIShape, Shape, ShapeType, Shapes
IShape mainly focuses on representing shapes. It is implemented by AbstractIShape, which is an abstract superclass that hold all the common code and attributes for Shape. We have Shape class that extends the AbstractIShape. We designed the AbstractIShape since we originally thought we are going to have Rectangle and Oval classes. But then we realize that we can combine Rectangle and Oval into Shape class. For Assignment 6, we don't have enough time to combine AbstractIShape and Shape into one class, but we will redesign this part to combine this two in the next assignment. We then have ShapeType enum class that has RECTANGLE and OVAL. Shapes is a class we created to hold our shapes in a list. The relationship between Shapes and Shape is Shapes "has-a" Shape. For next assignment, we will consider to add an IShapes interface for user convenience.
## IAction, Action, ActionType
Interface IAction is mainly used to represent the action with time tick, including start tick and end tick, and status of the animation, including start status and end status. Action implements all the methods from IAction. ActionType is an enum class that stores all the action type we defined, which includes ChangePosition, ChangeColor and ChangeScale.
## IStatus, Position, Color, Scale
IStatus is the interface used to get current status of the animation since we think user might want to check status of all shapes at some point. Position is used to get current position status of the shape, Color is used to get current color status of the shape, and Scale is used to get current scale status of the shape. 
## Relationships between the above three parts
Since AbstracIShape and Shape will have Position, Color and Scale, so there are "has-a" relationships between AbstractIShape and Position, Color, Scale, and there are also "has-a" relationships between Shape and Position, Color, Scale. Since Action will get start status and end status, so Action "extends" iStatus.
## One thing to mention about our design
We only have Shapes that hold a list of shape, instead of having two classes for both shape list and action list, because we want to have action list initialized in each shape so that action is grouped by each shape. In this way, when we want to access action of a shape, we don't need to go over the whole action lists, instead we only need to go to the shape and find one of its actions.
# Assignment 7
## Updates
We reconstructed our model with three interfaces: IShape, IMotion, IModel. We now have all parameters related to shapes in the Shpae class that implements IShape interface. We have all motion related parameters and methods in the Motion class that implements IMotion interface. The Model class implements IModel and it has two lists: shape list that contains all the shapes of our animation, and motion list that contains all the motions of our animation. 
We had to reconstruct our getCurrentStatus method at a given tick with two lists.
## IView
We have created this Interface and implmented three types of views.
## ViewFactory
There are three type of views with a single static method that takes in a String and name for a view—“text”, “svg”, or “visual” as well as a Model object; it constructs an instance of the appropriate concrete view.
## ViusalView
Implements IView. In this class, we created a method that construct a JFrame object. It reprensents the given canvis size and location. We take in a model object and created a panel that we will be drawing our shapes on.
MyPanel: The panel we build to draw all the shapes at a given time point. We also add the timer in this class that implements the ActionListener. we repreatly increase the time tick and call the timer method at 1s/speed delay. This allows us to draw the shapes with 1s/speed interval. 
As we are not required to build the controller for this assignment, we add the timer in MyPanel class. We will move the timer to controller in our next Assignment.
## TextualView
this class represents our textual output.
## SVGView
This class represents our SVG view and the output is in SVG format.
