/*
 * 2.laboratorijska vjezba iz OOP-a 
 */
package hr.fer.oop.lab1.topic2.prob1;

import hr.fer.oop.lab1.topic2.pic.Picture;

/**
 * This class represents new Rectangle and it implements class DrawableShape
 *
 * @author Dora Mlinarić 0036480184
 * @version 1.1
 */
public class Rectangle implements DrawableShape {

    /**
     * x coordinate of upper left top
     */
    private int topX;

    /**
     * y coordinate of upper left top
     */
    private int topY;

    /**
     * width of rectangle
     */
    private int width;

    /**
     * height of rectangle
     */
    private int height;

    /**
     * Constructor for rectangle.
     *
     * @param topX is x coordinate of upper left top
     * @param topY is y coordinate of upper left top
     * @param width is width of rectangle
     * @param height is height of rectangle
     * @throws IllegalArgumentException if any of parameters is smaller than
     * zero
     */
    public Rectangle(int topX, int topY, int width, int height) {

        if (topX < 0 || topY < 0 || width < 0 || height < 0) {
            throw new IllegalArgumentException("Coordinates, width or height must be grater than 0.");
        }

        this.topX = topX;
        this.topY = topY;
        this.width = width;
        this.height = height;
    }

    /**
     * Constructor for rectangle. It received new rectangle
     *
     * @param r is new rectangle
     */
    public Rectangle(Rectangle r) {
        this(r.topX, r.topY, r.width, r.height);
    }

    /**
     * Draw a rectangle with matrix from point (topX,topY)
     *
     * @param pic picture with drawing
     */
    @Override
    public void drawOnPicture(Picture pic) {
        for (int i = this.topX; i < this.width + this.topX; i++) {
            for (int j = this.topY; j < this.height + this.topY; j++) {
                pic.turnPixelOn(i, j);
            }

        }

    }

    /**
     * Getter for rectangle.
     *
     * @return x coordinate of upper left top
     */
    public int getTopX() {
        return topX;
    }

    /**
     * Setter for rectangle. It sets new value of x coordinate of upper left top
     *
     * @param newTopX is new value
     * @throws IllegalArgumentException if value is smaller then zero
     */
    public void setTopX(int newTopX) {
        if (topX < 0) {
            throw new IllegalArgumentException("Coordinate cannot be negative");
        }
        topX = newTopX;
    }

    /**
     * Getter for rectangle.
     *
     * @return y coordinate of upper left top
     */
    public int getTopY() {
        return topY;
    }

    /**
     * Setter for rectangle. It sets new value of y coordinate of upper left top
     *
     * @param newTopY is new value
     * @throws IllegalArgumentException if value is smaller then zero
     */
    public void setTopY(int newTopY) {
        if (topY < 0) {
            throw new IllegalArgumentException("Coordinate cannot be negative");
        }
        topY = newTopY;
    }

    /**
     * Getter for rectangle
     *
     * @return width of rectangle
     */
    public int getWidth() {
        return width;
    }

    /**
     * Setter for rectangle. It sets new value of width
     *
     * @param newWidth is new width
     * @throws IllegalArgumentException if value is smaller then zero
     */
    public void setWidth(int newWidth) {
        if (width < 0) {
            throw new IllegalArgumentException("Width cannot be negative");
        }
        width = newWidth;
    }

    /**
     * Getter for rectangle
     *
     * @return height of rectangle
     */
    public int getHeight() {
        return height;
    }

    /**
     * Setter for rectangle. It sets new value of height
     *
     * @param newHeight is new width
     * @throws IllegalArgumentException if value is smaller then zero
     */
    public void setHight(int newHeight) {
        if (height < 0) {
            throw new IllegalArgumentException("Height cannot be negative");
        }
        height = newHeight;
    }

    /**
     * This method calculate perimeter of rectangle
     *
     * @return value of perimeter
     */
    public int getPerimeter() {
        return (2 * width + 2 * height);
    }

    /**
     * This method calculate area of rectangle
     *
     * @return value of area
     */
    public int getArea() {
        return width * height;
    }
}
