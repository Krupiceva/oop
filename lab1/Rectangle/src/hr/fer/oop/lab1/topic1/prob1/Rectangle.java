/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.fer.oop.lab1.topic1.prob1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Dora Mlinarić 0036480184
 */
public class Rectangle {

    /**
     * This method read numbers from system input
     *
     * @param string is string name
     * @return string convert in a number
     * @throws IOException
     */
    public static double Input(String string) throws IOException {
        double num;
        while (true) {
            System.out.println("Please provide " + string + ": ");
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String line = reader.readLine();
            boolean empty = line.isEmpty();

            if (empty) {
                System.err.println("Nothing was given.");
                continue;
            }
            num = Double.parseDouble(line);
            if (num < 0) {
                System.err.println(string + " is negative");
                continue;
            }
            break;
        }
        return num;
    }

    /**
     * This method calculate area of a rectangle
     *
     * @param Width is width of a rectangle
     * @param Height is height of a rectangle
     * @return area
     */
    public static double AreaCalculate(double Width, double Height) {
        return (Width * Height);
    }

    /**
     * This method calculate circumference of a rectangle
     *
     * @param Width is width of a rectangle
     * @param Height is height of a rectangle
     * @return
     */
    public static double CircumferenceCalculate(double Width, double Height) {
        return (2 * Width + 2 * Height);
    }

    /**
     * This method is called once the program is run. Arguments are described
     * below
     *
     * @param args Command line arguments.
     */
    public static void main(String[] args) throws IOException {
        double width = 0;
        double height = 0;
        if (args.length == 0) {
            width = Input("Width");
            height = Input("Height");
        } else if (args.length != 2) {
            System.err.println("Invalid number of arguments was provided.");
            System.exit(1);
        } else {
            width = Double.parseDouble(args[0]);
            height = Double.parseDouble(args[1]);
        }

        double area = AreaCalculate(width, height);
        double circumference = CircumferenceCalculate(width, height);

        System.out.println("You have specified a rectangle with width " + width + " and height " + height + ". Its area is " + area + "  and\n"
                + "its perimeter is " + circumference + ".");

    }

}
