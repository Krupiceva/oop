/*
 * 2. laboratorijska vjezba iz Objektno orijentiranog programiranja
 */
package hr.fer.oop.lab2.topic1.calculator;

/**
 * This class represents buttons for digits It extends class Button
 *
 * @author Dora Mlinarić
 * @version 1.0
 */
public class DigitButton extends Button {

    public static final DigitButton b0 = new DigitButton(0);

    public static final DigitButton b1 = new DigitButton(1);

    public static final DigitButton b2 = new DigitButton(2);

    public static final DigitButton b3 = new DigitButton(3);

    public static final DigitButton b4 = new DigitButton(4);

    public static final DigitButton b5 = new DigitButton(5);

    public static final DigitButton b6 = new DigitButton(6);

    public static final DigitButton b7 = new DigitButton(7);

    public static final DigitButton b8 = new DigitButton(8);

    public static final DigitButton b9 = new DigitButton(9);

    /**
     * Constructor for digit button. It called constructor of mother class and
     * give string value of digits
     *
     * @param buttonName is integer value of digits
     */
    public DigitButton(int buttonName) {
        super(Integer.toString(buttonName));
    }

}
