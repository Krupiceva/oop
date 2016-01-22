/*
 2. laboratorijska vjezba iz OOP-a
 */
package hr.fer.oop.lab1.topic2.prob1;

import hr.fer.oop.lab1.topic2.pic.Picture;

/**
 * This class represents circle. It implements class DrawableShape
 *
 * @author Dora Mlinarić
 * @version 1.1
 */
public class Circle implements DrawableShape {

    /**
     * x coordinate of circle center
     */
    private int centerX;

    /**
     * y coordinate of circle center
     */
    private int centerY;

    /**
     * radius of circle
     */
    private int radius;

    /**
     * constructor for circle. Receives center and radius
     *
     * @param centerX x coordinate of center
     * @param centerY y coordinate of center
     * @param radius radius of circle
     * @throws IllegalArgumentException if any of parameters is smaller than
     * zero
     */
    public Circle(int centerX, int centerY, int radius) {

        if (centerX < 0 || centerY < 0 || radius < 0) {
            throw new IllegalArgumentException("Coordinate or radius cannot be negativ.");
        }

        this.centerX = centerX;
        this.centerY = centerY;
        this.radius = radius;
    }

    /**
     * Constructor for circle receives new circle and it calls main constructor
     *
     * @param c new circle
     */
    public Circle(Circle c) {
        this(c.centerX, c.centerY, c.radius);
    }

    /**
     * Draw a circle with equation r^2>=(i-x)^2 + (j-y)^2. First it puts circle
     * in rectangle size of 2*radius and checks x,y in side of that rectangle
     *
     * @param pic is picture in with is drawing
     */
    @Override
    public void drawOnPicture(Picture pic) {

        int xTop = this.centerX - this.radius;
        int yTop = this.centerY - this.radius;

        for (int i = xTop; i <= 2 * this.radius + xTop; i++) {
            for (int j = yTop; j <= 2 * this.radius + yTop; j++) {
                if ((this.radius * this.radius) >= ((Math.pow(i - this.centerX, 2)) + (Math.pow(j - this.centerY, 2)))) {
                    pic.turnPixelOn(i, j);
                }
            }
        }
    }

    /**
     * Getter for x coordinate of center
     *
     * @return x coordinate of circles center
     */
    public int getCenterX() {
        return centerX;
    }

    /**
     * Setter for Circle
     *
     * @param newCenterX is new x coordinate of center
     * @throws IllegalArgumentException if coordinate is smaller then zero
     */
    public void setCenterX(int newCenterX) {

        if (newCenterX < 0) {
            throw new IllegalArgumentException("Coordinate cannot be negativ");
        }

        centerX = newCenterX;
    }

    /**
     * Getter for y coordinate of center
     *
     * @return y coordinate of circles center
     */
    public int getCenterY() {
        return centerY;
    }

    /**
     * Setter for Circle
     *
     * @param newCenterY is new y coordinate of center
     * @throws IllegalArgumentException if coordinate is smaller then zero
     */
    public void setCenterY(int newCenterY) {

        if (newCenterY < 0) {
            throw new IllegalArgumentException("Coordinate cannot be negativ");
        }

        centerY = newCenterY;
    }

    /**
     * Getter for radius
     *
     * @return radius of Circle
     */
    public int getRadius() {
        return radius;
    }

    /**
     * Setter for radius
     *
     * @param newRadius is new radius of Circle
     * @throws IllegalArgumentException if new radius is smaller than zero
     */
    public void setRadius(int newRadius) {

        if (radius < 0) {
            throw new IllegalArgumentException("Radius cannot be negativ");
        }

        radius = newRadius;
    }

    /**
     * This method calculate perimeter of circle
     *
     * @return this perimeter
     */
    public int getPerimeter() {
        return (int) (2 * radius * Math.PI);
    }

    /**
     * This method calculate area if circle
     *
     * @return this area
     */
    public int getArea() {
        return (int) (radius * radius * Math.PI);
    }

}
