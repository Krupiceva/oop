/*
 * 2. laboratorijska vjezba iz Objektno orijentiranog programiranja
 */
package hr.fer.oop.lab2.topic1.calculator;

/**
 * This class represents one register of memory. It could have one value (full
 * or empty)
 *
 * @author Dora Mlinarić
 * @version 1.0
 */
public class Register {

    /**
     * One value of register
     */
    private Object value = null;

    /**
     * Constructor for Register. It initialize value on null when object is
     * first created
     */
    public Register() {
        this.value = null;
    }

    /**
     * This method return value of register
     *
     * @return value of register
     */
    public final Object getValue() {
        return value;
    }

    /**
     * This method set new value
     *
     * @param value is new value of register
     */
    public void setValue(Object value) {
        this.value = value;
    }

    /**
     * This method clear register value
     */
    public final void clear() {
        value = null;
    }

    /**
     * This method convert value to string
     *
     * @return string value of register value
     */
    @Override
    public String toString() {
        return String.valueOf(value);
    }

}
