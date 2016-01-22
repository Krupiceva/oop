/*
 *2. laboratorijska vjezba iz OOP-a
 */
package hr.fer.oop.lab1.topic2.prob1;

import hr.fer.oop.lab1.topic2.pic.Picture;
import java.util.Random;

/**
 * This class represents path of given points and implements class DrwableShap;
 *
 * @author Dora Mlinarić 0036480184
 * @version 11
 */
public class Path implements DrawableShape {

    /**
     * array of points
     */
    protected Point[] points;

    /**
     * Draw a path of received points. Make a line of every 2 neighboring points
     *
     * @param pic is picture with drawing
     */
    @Override
    public void drawOnPicture(Picture pic) {
        for (int i = 0; i < points.length - 1; i++) {
            Line line = new Line(points[i].x, points[i].y, points[i + 1].x, points[i + 1].y);
            line.drawOnPicture(pic);
        }
    }

    /**
     * Constructor for path. It creates random points.
     *
     * @param noOfPoints is number of points that need to be create
     * @throws IllegalArgumentException if number of points is smaller then 1
     */
    public Path(int noOfPoints) {
        if (noOfPoints < 1) {
            throw new IllegalArgumentException("Cannot create zero points.");
        }
        points = new Point[noOfPoints];
        Random r = new Random();
        for (int i = 0; i < noOfPoints; i++) {
            int x = r.nextInt(Constants.MAX_X) + 1;
            int y = r.nextInt(Constants.MAX_Y) + 1;
            Point p = new Point(x, y);
            points[i] = p;
        }
    }

    /**
     * Constructor for path. It creates path of received array of points
     *
     * @param points is array of points that need to be put in path
     */
    public Path(Point[] points) {
        this.points = new Point[points.length];
        for (int i = 0; i < points.length; i++) {
            this.points[i] = new Point(points[i]);
        }
    }

    public Path(int x1, int y1, int x2, int y2, int... xy) {
        //we'll assume that number of arguments is even (later we'll use exceptions)
        points = new Point[2 + xy.length / 2];
        points[0] = new Point(x1, y1);
        points[1] = new Point(x2, y2);
        for (int i = 0; i < xy.length / 2; i++) {
            points[i + 2] = new Point(xy[2 * i], xy[2 * i + 1]);
        }
    }

    /**
     * Getter for points
     *
     * @return array of points in path
     */
    public Point[] getPoints() {
        return points;
    }

    /**
     * This method calculate length of path
     *
     * @return length of path
     */
    public double length() {
        double d = 0;
        for (int i = 0; i < points.length - 1; i++) {
            Point a = points[i];
            Point b = points[i + 1];
            d += Math.sqrt((b.x - a.x) * (b.x - a.x) + (b.y - a.y) * (b.y - a.y));
        }
        return d;
    }

}
