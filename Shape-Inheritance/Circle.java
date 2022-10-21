import java.util.*;
import java.io.*;
import java.awt.*;

/**
 * This is the class for the Circle
 */
public class Circle extends Shape {
  private int radius;

  /**
   * We will set the x and y to the one in the super class
   * and we will then use those to get the coordinates
   * and then we will draw our shape. We set the radius to
   * the radius of the circle
   * 
   * @param x
   * @param y
   * @param radius
   */
  public Circle(int x, int y, int radius) {
    super(x, y);
    this.radius = radius;
  }

  /**
   * This is the method to get the area of the circle.
   */
  public double getArea() {
    return Math.PI * radius * radius;
  }

  /**
   * This is used to draw the Square
   * I made it so that there is a random color generator
   * and it uses those colors to fill in the Square
   * random color and random size
   * 
   */
  public void draw(Graphics drawer) {
    Random rand = new Random();
    float r = rand.nextFloat();
    float g = rand.nextFloat();
    float b = rand.nextFloat();
    Color randomColor = new Color(r, g, b);
    drawer.setColor(randomColor);
    drawer.fillOval(getX(), getY(), radius, radius);

  }

  /**
   * This returns the radius of the Circle
   * 
   * @return
   */
  public int getRadius() {
    return this.radius;
  }

  /**
   * This sets the radius of the circle.
   * 
   * @param radius
   */
  public void setRadius(int radius) {
    this.radius = radius;
  }
}
