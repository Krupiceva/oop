/*
 * 2. laboratorijska vjezba iz Objektno orijentiranog programiranja
 */
package hr.fer.oop.lab2.topic1.calculator;

/**
 * This interface have two methods
 *
 * @author Dora Mlinarić
 * @version 1.0
 */
public interface ICalculator {

    /**
     * This method returns Display value in any time
     *
     * @return string value of Display
     */
    String getDisplay();

    /**
     * This method is called when button is pressed
     *
     * @param button represents button of calculator
     */
    void press(Button button);

}
