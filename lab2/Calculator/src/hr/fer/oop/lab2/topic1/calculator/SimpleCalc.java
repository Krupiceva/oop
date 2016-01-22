/*
 * 2. laboratorijska vjezba iz Objektno orijentiranog programiranja
 */
package hr.fer.oop.lab2.topic1.calculator;

/**
 * This class implements interface ICalculator
 *
 * @author Dora Mlinarič
 * @version 1.0
 */
public class SimpleCalc implements ICalculator {

    private final Register memory = new Register();
    private final Register display = new Register();
    private final Register operator = new Register();

    /**
     * This method convert value of Display in string
     *
     * @return string value of register Display
     */
    @Override
    public String getDisplay() {
        return String.valueOf(display);
    }

    /**
     * This method find out which button is pressed. It call method for every
     * button
     *
     * @param button is pressed button
     */
    @Override
    public void press(Button button) {
        if (button == Button.equals) {
            pressEquals();
        } else if (button == Button.clear) {
            pressClear();
        } else if (button == OperatorButton.plus) {
            pressPlus();
        } else if (button == OperatorButton.minus) {
            pressMinus();
        } else {
            pressDigit(Integer.valueOf(button.toString()));
        }

    }

    /**
     * This method is called when operator equals is pressed. It preforms
     * operation which is saved in register Operator. It preforms it on Register
     * Display and Memory and save it to register Display. In the end clears
     * Memory and Operator registers. If equals is pressed before operation
     * program ends
     */
    public void pressEquals() {
        if (operator.getValue() != null) {
            if (operator.toString().compareTo("+") == 0) {
                display.setValue((String.valueOf(Integer.parseInt(memory.toString()) + Integer.parseInt(display.toString()))));
            } else {
                display.setValue((String.valueOf(Integer.parseInt(memory.toString()) - Integer.parseInt(display.toString()))));
            }

            memory.clear();
            operator.clear();
        } else {
            System.err.println("You press equals before you determined operation");
            System.exit(1);
        }
    }

    /**
     * This method is called when operator plus is pressed. It puts addition
     * operation in register Operator. In memory register puts Display register
     * and clear Display register. If both of register are full call pressEquals
     * before and then continue. If both of register are empty, clear Operator
     * register
     */
    public void pressPlus() {

        //If Memory and Display registers are both full
        if (memory.getValue() != null && display.getValue() != null) {
            pressEquals();
        }

        operator.setValue("+");
        memory.setValue(display.getValue());
        display.clear();

        //If Memory and Display registers are both empty
        if (memory.getValue() == null && display.getValue() == null) {
            pressClear();
        }
    }

    /**
     * This method is called when operator minus is pressed. It puts subtraction
     * operation in register Operator. In memory register puts Display register
     * and clear Display register. If both of register are full call pressEquals
     * before and then continue. If both of register are empty, clear Operator
     * register
     */
    public void pressMinus() {

        //If Memory and Display registers are both full
        if (memory.getValue() != null && display.getValue() != null) {
            pressEquals();
        }

        operator.setValue("-");
        memory.setValue(display.getValue());
        display.clear();

        //If Memory and Display registers are both empty
        if (memory.getValue() == null && display.getValue() == null) {
            pressClear();
        }
    }

    /**
     * This method is called when C (clear) button is pressed It clear values of
     * all registers
     */
    public void pressClear() {
        display.clear();
        memory.clear();
        operator.clear();
    }

    /**
     * This method is called when some digit is pressed. It puts string value of
     * digit in Display register. If this button is pressed repetitive, it
     * connect digits to one number
     *
     * @param num is one digit
     */
    public void pressDigit(int num) {
        /**
         * String value of Display
         */
        String tempDisp = String.valueOf(display);

        if (display.getValue() == null) {
            display.setValue(String.valueOf(num));
        } else {
            tempDisp = tempDisp + String.valueOf(num);
            display.setValue(tempDisp);
        }
    }

    /**
     * This method represents full Display of calculator. It show only registers
     * which is not empty
     *
     * @return string value of calculators Display
     */
    @Override
    public String toString() {
        String outPut = "";
        String outPutDisp = "";
        String outPutMem = "";
        String outPutOper = "";

        if (display.getValue() != null) {
            outPutDisp = " D = " + display.toString();
        }
        if (memory.getValue() != null) {
            outPutMem = " M = " + memory.toString();
        }
        if (operator.getValue() != null) {
            outPutOper = " O = " + operator.toString();
        }
        outPut = "(" + outPutDisp + outPutMem + outPutOper + " )";
        return outPut;
    }

}
