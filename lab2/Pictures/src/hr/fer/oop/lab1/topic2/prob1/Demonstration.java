/*
 *2.laboratorijska vjezba iz OOP-a
 */
package hr.fer.oop.lab1.topic2.prob1;

import hr.fer.oop.lab1.topic2.pic.Picture;
import hr.fer.oop.lab1.topic2.pic.PictureDisplay;

/**
 * This class is main class and demonstrate creating and drawing a random shapes
 *
 * @author Dora Mlinarić 0036480184
 * @version 1.1
 */
public class Demonstration {

    /**
     * Width of picture
     */
    public static final int WIDTH = 100;
    /**
     * Height of picture
     */
    public static final int HEIGHT = 100;

    /**
     * This method is called once the program is run. Demonstrates drawing of
     * character. Arguments are described below
     *
     * @param args Command line arguments.
     */
    public static void main(String[] args) {

        DrawableShapeCreator factory = new RandomShapeFactory(WIDTH, HEIGHT);
        DrawableShape[] shapes = null;
        try {
            shapes = factory.create(0);
        } catch (IllegalArgumentException e) {
            System.out.println("Shapes must have at least one shape.");
        }
        shapes = factory.create(5);
        Picture pic = new Picture(WIDTH, HEIGHT);

        for (DrawableShape s : shapes) {
            try {
                s.drawOnPicture(pic);
            } catch (NullPointerException e) {
                System.out.println("No shape in this element of array.");
            }
        }

        PictureDisplay.showPicture(pic, 6);

    }

}
