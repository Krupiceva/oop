/*
 * 2. laboratorijska vjezba iz Objektno orijentiranog programiranja
 */
package hr.fer.oop.lab2.topic1.calculator;

/**
 * This class presents enumeration for buttons
 *
 * @author Dora Mlinarić
 * @version 1.0
 */
public class Button {

    /* Name of a button */
    private final String buttonName;

    public static final Button equals = new Button("=");

    public static final Button clear = new Button("C");

    /**
     * Constructor for Button It joins received string to button name
     *
     * @param buttonName represents name of button
     */
    public Button(String buttonName) {
        this.buttonName = buttonName;
    }

    /**
     * This method return string value of button name
     *
     * @return string (name of a button)
     */
    @Override
    public String toString() {
        return buttonName;
    }

}
