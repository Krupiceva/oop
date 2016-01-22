/*
 * 2. laboratorijska vjezba iz Objektno orijentiranog programiranja
 */
package hr.fer.oop.lab2.topic1.calculator;

/**
 * This class represents button for mathematic operators It extends class Button
 *
 * @author Dora Mlinarić
 * @version 1.0
 */
public class OperatorButton extends Button {

    public static final OperatorButton plus = new OperatorButton("+");

    public static final OperatorButton minus = new OperatorButton("-");

    /**
     * Constructor for operator button. It calls constructor of mother class and
     * give it name of a operator
     *
     * @param buttonName is string value of name for operator
     */
    public OperatorButton(String buttonName) {

        super(buttonName);
    }

}
