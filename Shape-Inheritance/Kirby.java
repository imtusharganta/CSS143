import java.awt.*;
import java.util.*;
import java.io.*;

/**
 * Tushar Ganta
 * CSS 143
 * Shapes and Inheritance
 */
/**
 * This is the class which creates kirby
 */
public class Kirby extends Shape {
    private int radius;

    /**
     * This sets the radius of the kirby, and it sets the x and y into the shape
     * class
     * in which we inherit from.
     * 
     * @param x
     * @param y
     * @param radius
     */
    public Kirby(int x, int y, int radius) {
        super(x, y);
        this.radius = radius;
    }

    public void draw(Graphics g) {
        /**
         * This is for the legs
         */
        Color legs = new Color(222, 68, 119);
        g.setColor(legs);
        g.fillOval(getX() - ((radius / 20)), getY() + (2 * (radius / 3)) + ((radius / 6)), (radius / 2),
                (radius / 3));
        g.fillOval(getX() + (2 * (radius / 4)), getY() + (2 * (radius / 3)) + ((radius / 6)), (radius / 2),
                (radius / 3));

        /**
         * This is for the arms
         */
        Color outline = new Color(255, 151, 207);
        Color arms = new Color(255, 149, 196);
        g.setColor(arms);
        // left arm
        g.fillOval(getX() - (3 * (radius / 20)), getY() + ((radius / 3)), (radius / 2),
                (radius / 3));
        // right arm
        g.fillOval(getX() + (2 * (radius / 3)), getY() + ((radius / 3)), (radius / 2),
                (radius / 3));
        g.setColor(outline);
        // left outline
        g.drawOval(getX() - (3 * (radius / 20)), getY() + ((radius / 3)), (radius / 2),
                (radius / 3));
        // right outline
        g.drawOval(getX() + (2 * (radius / 3)), getY() + ((radius / 3)), (radius / 2),
                (radius / 3));

        /**
         * This is to get the body of Kirby
         * and outline the body
         */
        Color body = new Color(246, 146, 189);
        g.setColor(body);
        g.fillOval(getX(), getY(), radius, radius);
        g.setColor(outline);
        g.drawOval(getX(), getY(), radius, radius);

        /**
         * This is for the cheeks
         */
        Color cheeks = new Color(255, 119, 170);
        g.setColor(cheeks);
        // left cheek
        g.fillOval(getX() - (2 * (radius / 16) / 24) + (radius / 22),
                getY() + ((radius / 4) + (2 * (radius / 8))),
                (radius / 2) / 2,
                (radius / 3) / 3);
        // right cheek
        g.fillOval(getX() + (4 * (radius / 6)) + (radius / 22), getY() + ((2 * (radius / 4))),
                (radius / 2) / 2,
                (radius / 3) / 3);

        /**
         * This makes the blacks of the eyes
         */
        Color eyes = new Color(0, 0, 0);
        g.setColor(eyes);
        // left eye
        g.fillOval(getX() + (2 * (radius / 4) / 2), getY() + ((radius / 6) + (radius / 8)),
                (radius / 2) / 4,
                2 * ((radius / 3) / 3));
        // right eye
        g.fillOval(getX() + ((radius) * 2 / 3) - ((2 * radius) / 26), getY() + ((radius / 6) + (radius / 8)),
                (radius / 2) / 4,
                2 * ((radius / 3) / 3));

        /**
         * These are what make the whites of the eyeball
         */
        Color eyeballs = new Color(255, 255, 255);
        g.setColor(eyeballs);
        // left eyeball
        g.fillOval(getX() + (2 * (radius / 4) / 2), getY() + ((radius / 6) + (radius / 8)),
                (radius / 2) / 4,
                2 * ((radius / 6) / 3));
        // right eyeball
        g.fillOval(getX() + ((radius) * 2 / 3) - ((2 * radius) / 26), getY() + ((radius / 6) + (radius / 8)),
                (radius / 2) / 4,
                2 * ((radius / 6) / 3));

        /**
         * These are what makes the blues of the eyeball
         */
        Color blue = new Color(51, 64, 238);
        g.setColor(blue);
        // left eyeball
        g.fillOval(getX() + (2 * (radius / 4) / 2), getY() + ((radius / 6) + (radius / 4)),
                (radius / 2) / 4,
                2 * ((radius / 6) / 3));
        // right eyeball
        g.fillOval(getX() + ((radius) * 2 / 3) - ((2 * radius) / 26), getY() + ((radius / 6) + (radius / 4)),
                (radius / 2) / 4,
                2 * ((radius / 6) / 3));

        /**
         * This makes the mouth
         */
        g.setColor(legs);
        g.fillArc(getX() + (2 * radius) / 5, getY() + (2 * radius) / 4, radius / 6, radius / 6, 180, 180);

    }

    /**
     * This returns the area of the 5 circles of the kirby.
     */
    public double getArea() {
        return (5 * (Math.PI * radius * radius));
    }

}
