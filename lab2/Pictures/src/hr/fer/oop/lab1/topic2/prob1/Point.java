/*
 * 2. laboratorijska vjezba iz OOP-a
 */
package hr.fer.oop.lab1.topic2.prob1;

import hr.fer.oop.lab1.topic2.pic.Picture;

/**
 * This class represents path and implements class DrawableShape
 *
 * @author Dora Mlinarić 0036480184
 */
public class Point implements DrawableShape {

    /**
     * x coordinate of point
     */
    public int x;
    /**
     * y coordinate of point
     */
    public int y;

    /**
     * constructor, receives coordinate
     *
     * @param x x coordinate
     * @param y y coordinate
     */
    public Point(int x, int y) {
        if (x < 0 || y < 0) {
            throw new IllegalArgumentException("Coordinate cannot be negative.");
        }
        this.x = x;
        this.y = y;
    }

    /**
     * constructor, receives new point.
     *
     * @param t
     */
    public Point(Point t) {
        this(t.x, t.y);
    }

    /**
     * draw a point, color the selected pixel
     *
     * @param pic with drawing
     */
    @Override
    public void drawOnPicture(Picture pic) {
        pic.turnPixelOn(this.x, this.y);
    }

}
