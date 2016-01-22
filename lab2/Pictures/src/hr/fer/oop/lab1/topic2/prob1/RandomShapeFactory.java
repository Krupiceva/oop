/*
 *2. laboratorijska vježba iz OOP-a
 */
package hr.fer.oop.lab1.topic2.prob1;

import static java.lang.Math.min;
import java.util.Random;

/**
 * This class represents Factory for shapes. It implements DrawableShapeCreator
 *
 * @author Dora Mlinarić
 * @version 1.0
 */
public class RandomShapeFactory implements DrawableShapeCreator {

    /**
     * Width of picture and max possible width of every shape
     */
    private final int width;
    /**
     * Height of picture and max possible height of every shape
     */
    private final int height;

    /**
     * Constructor for RandomShapeFactroy. It received values of height and
     * width
     *
     * @param width is max possible width of shape
     * @param height is max possible height of shape
     * @throws IllegalArgumentException if any of values is smaller than zero
     */
    public RandomShapeFactory(int width, int height) {
        if (width < 1 || height < 1) {
            throw new IllegalArgumentException("Width an height of shape must be at least 1");
        }
        this.width = width;
        this.height = height;
    }

    /**
     * This method create random typeOfShape shape. It calculates random values
     * of coordinates and parameters of every shape and create new shape with
     * this values
     *
     * @param typeOfShape is shape name that need to be create
     * @return this shape
     * @throws IllegalArgumentException if name isn't supported (Isn't one of
     * following shapes:Rectangle, Line, Circle, Point or Path
     */
    @Override
    public DrawableShape create(String typeOfShape) {
        DrawableShape shape = null;
        if (typeOfShape.compareTo("Rectangle") == 0) {
            Random randomValue = new Random();
            int topX = randomValue.nextInt(width - 1);
            int topY = randomValue.nextInt(height - 1);
            int widthOfRectangle = randomValue.nextInt(width - topX - 1);
            int heightOfRectangle = randomValue.nextInt(height - topY - 1);
            Rectangle r = null;
            try {
                r = new Rectangle(topX, topY, widthOfRectangle, heightOfRectangle);
            } catch (IllegalArgumentException e) {
                System.out.println("Values of Rectangle couldn't be negative");
            }
            shape = r;
        } else if (typeOfShape.compareTo("Line") == 0) {
            Random randomValue = new Random();
            int startX = randomValue.nextInt(width);
            int startY = randomValue.nextInt(height);
            int endX = randomValue.nextInt(width);
            int endY = randomValue.nextInt(height);
            Line l = null;

            try {
                l = new Line(startX, startY, endX, endY);
            } catch (IllegalArgumentException e) {
                System.out.println("Values of circle couldn't be negative");
            }
            shape = l;
        } else if (typeOfShape.compareTo("Circle") == 0) {
            Random randomValue = new Random();
            int centerX = randomValue.nextInt(width);
            int centerY = randomValue.nextInt(height);
            if (centerX < 2) {
                centerX = 2;
            }
            if (centerY < 2) {
                centerY = 2;
            }
            int potentialRadius;

            int temp1 = min(centerX, centerY);
            int temp2 = min(width - centerX, height - centerY);
            potentialRadius = min(temp1, temp2);
            if (potentialRadius < 2) {
                potentialRadius = 2;
            }

            int radius = randomValue.nextInt(potentialRadius);

            Circle c = null;
            try {
                c = new Circle(centerX, centerY, radius);
            } catch (IllegalArgumentException e) {
                System.out.println("Values of circle coludn't be negative");
            }
            shape = c;
        } else if (typeOfShape.compareTo("Point") == 0) {
            Random randomValue = new Random();
            int x = randomValue.nextInt(width - 1);
            int y = randomValue.nextInt(height - 1);
            Point p = null;
            try {
                p = new Point(x, y);
            } catch (IllegalArgumentException e) {
                System.out.println("Values of line coludn't be negative");
            }
            shape = p;
        } else if (typeOfShape.compareTo("Path") == 0) {
            Path pa = null;
            try {
                pa = new Path(5);
            } catch (IllegalArgumentException e) {
                System.out.println("Number of points int path must be at least one");
            }
            shape = pa;
        } else {
            throw new IllegalArgumentException("This type of shape isn't support");
        }
        return shape;
    }

    /**
     * This method create array of random shapes.
     *
     * @param num is number of shapes that need to be in array
     * @return array of selected shapes
     */
    @Override
    public DrawableShape[] create(int num) {
        if (num < 1) {
            throw new IllegalArgumentException("Array must have at least one shape");
        }
        DrawableShape[] shapes = new DrawableShape[num];
        Random randomValue = new Random();

        for (int i = 0; i < num; i++) {
            String name;
            int whichShape = randomValue.nextInt(3);
            if (whichShape == 0) {
                name = "Line";
            } else if (whichShape == 1) {
                name = "Circle";
            } else {
                name = "Rectangle";
            }
            try {
                shapes[i] = create(name);
            } catch (IllegalArgumentException e) {
                System.out.println("Couldn't recognize type of shape");
            }

        }

        return shapes;
    }
}
