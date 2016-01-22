/*
 * 2. laboratorijska vjezba iz Objektno orijentiranog programiranja
 */
package hr.fer.oop.lab2.topic1.calculator;

/**
 * This class demonstrate simple calculator
 *
 * @author Dora Mlinarić
 * @version 1.0
 */
public class Demonstration {

    /**
     * This method is called when programs start
     *
     * @param args is command line argument
     */
    public static void main(String[] args) {
        SimpleCalc c = new SimpleCalc();

        c.pressDigit(1);
        System.out.println(c.toString());
        c.pressDigit(0);
        System.out.println(c.toString());
        c.pressMinus();
        System.out.println(c.toString());
        c.pressDigit(2);
        System.out.println(c.toString());
        c.pressDigit(9);
        System.out.println(c.toString());
        c.pressPlus();
        System.out.println(c.toString());
        c.pressDigit(3);
        System.out.println(c.toString());
        c.pressEquals();
        System.out.println(c.toString());
        c.pressClear();
        System.out.println(c.toString());

        c.press(DigitButton.b1);
        System.out.println(c.toString());
        c.press(DigitButton.b0);
        System.out.println(c.toString());
        c.press(OperatorButton.minus);
        System.out.println(c.toString());
        c.press(DigitButton.b2);
        System.out.println(c.toString());
        c.press(DigitButton.b9);
        System.out.println(c.toString());
        c.press(OperatorButton.plus);
        System.out.println(c.toString());
        c.press(DigitButton.b3);
        System.out.println(c.toString());
        c.press(Button.equals);
        System.out.println(c.toString());
        c.press(Button.clear);
        System.out.println(c.toString());
    }

}
