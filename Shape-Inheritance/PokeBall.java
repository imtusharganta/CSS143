import java.awt.*;

public class PokeBall extends Shape {
  private int radius;

  public PokeBall(int x, int y, int radius) {
    super(x, y);
    this.radius = radius;
  }

  public void draw(Graphics g) {
    /**
     * This is used to draw the red part of the Pokeball
     * We use fillArc because we want to fill half of the ball
     * and the top is going to be red. We will set it to -180
     * so that will get us our top half.
     */
    g.setColor(Color.RED);
    g.fillArc(getX(), getY(), radius, radius, -180, -180);

    /**
     * This is used for the bottom of the pokeball.
     * We will use the fillArc and set it to 180 so it is the bottom half
     */
    g.setColor(Color.WHITE);
    g.fillArc(getX(), getY(), radius, radius, 180, 180);

    /**
     * [""]
     * This creates the black line
     * Thip-=[s creates the black line
     */
    g.setColor(Color.BLACK);
    g.fillRect(getX(), getY() + (radius / 2), radius, (radius / 50));

    /**
     * This is used to get the white middle circle of the pokeball
     * AKA the button of the pokeball
     */
    g.setColor(Color.WHITE);
    g.fillOval(getX() + ((radius / 4) + radius / 2) / 2, getY() + (((radius)) / 3) + (radius / 17), (radius / 4),
        (radius / 4));

    /**
     * This is for the Outer Black circle
     */
    g.setColor(Color.BLACK);
    g.drawOval(getX(), getY(), radius, radius);

    /**
     * This is for the inner black circle.
     */
    g.setColor(Color.BLACK);
    g.drawOval(getX() + ((radius / 4) + radius / 2) / 2, getY() + (((radius)) / 3) + (radius / 17), (radius / 4),
        (radius / 4));
  }

  public double getArea() {
    return ((Math.PI * radius * radius));
  }
}
