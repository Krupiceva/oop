/*
 *2. laboratorijska vjezba iz OOP-a
 */
package hr.fer.oop.lab1.topic2.prob1;

import hr.fer.oop.lab1.topic2.pic.Picture;

/**
 * This class represents Line and it implements class DrawableShape
 *
 * @author Dora Mlinarić 0036480184
 * @version 11
 */
public class Line implements DrawableShape {

    /**
     * X coordinate of start point
     */
    public int startX;
    /**
     * Y coordinate of start point
     */
    public int startY;
    /**
     * X coordinate of end point
     */
    public int endX;
    /**
     * Y coordinate of end point
     */
    public int endY;

    /**
     * Constructor for line
     *
     * @param startX is x coordinate of start point
     * @param startY is y coordinate of start point
     * @param endX is x coordinate of end point
     * @param endY is y coordinate of end point
     * @throws IllegalArgumentException if any of parameters is smaller then
     * zero
     */
    public Line(int startX, int startY, int endX, int endY) {

        if (startX < 0 || startY < 0 || endX < 0 || endY < 0) {
            throw new IllegalArgumentException("Coordinates cannot be negative");
        }

        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
    }

    /**
     * Constructor for Line. It calls constructor of mother class
     *
     * @param l is new line
     */
    public Line(Line l) {
        this(l.startX, l.startY, l.endX, l.endY);
    }

    /**
     * Bresenham's line algorithm (simply)
     * http://en.wikipedia.org/wiki/Bresenham%27s_line_algorithm#Simplification
     *
     * @param pic picture for drawing
     */
    @Override
    public void drawOnPicture(Picture pic) {

        int x1 = this.startX;
        int y1 = this.startY;
        int x2 = this.endX;
        int y2 = this.endY;

        int dx = Math.abs(x2 - x1);
        int dy = Math.abs(y2 - y1);

        int sx = (x1 < x2) ? 1 : -1;
        int sy = (y1 < y2) ? 1 : -1;

        int err = dx - dy;

        while (true) {
            pic.turnPixelOn(x1, y1);
            if (x1 == x2 && y1 == y2) {
                break;
            }
            int e2 = 2 * err;
            if (e2 > -dy) {
                err = err - dy;
                x1 += sx;
            }
            if (e2 < dx) {
                err = err + dx;
                y1 += sy;
            }
        }

    }

}
