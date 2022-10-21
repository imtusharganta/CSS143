import java.awt.*;
import java.util.*;
import java.io.*;

/**
 * Tushar Ganta
 * CSS 143
 * Shapes and Inheritance
 */
/**
 * This is the Square class
 */
public class Square extends Shape {
  /**
   * To get the side length of the square
   */
  private int side;

  /**
   * uses super constructor to set the X and Y in the shape class
   */
  public Square(int x, int y, int side) {
    super(x, y);
    this.side = side;
  }

  /**
   * return the area of the square
   */
  public double getArea() {
    return side * side;
  }

  /**
   * This is used to draw the Square
   * I made it so that there is a random color generator
   * and it uses those colors to fill in the Square
   * random color and random size
   * 
   */
  public void draw(Graphics window) {
    Random rand = new Random();
    float r = rand.nextFloat();
    float g = rand.nextFloat();
    float b = rand.nextFloat();
    Color randomColor = new Color(r, g, b);
    window.setColor(randomColor);
    window.fillRect(getX(), getY(), side, side);
  }

  /**
   * This returns the side length
   * 
   * @return
   */
  public int getSide() {
    return side;
  }

  /**
   * This sets the side length of the square
   * 
   * @param side
   */
  public void setSide(int side) {
    this.side = side;
  }
}
