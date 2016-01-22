/*
 *2. laboratorijka vjezba iz OOP-a
 */
package hr.fer.oop.lab1.topic2.prob1;

/**
 * This interface have two methods for creating a shape.
 *
 * @author Dora Mlinarić
 * @version 1.0
 */
public interface DrawableShapeCreator {

    /**
     * This method make array of shapes
     *
     * @param num is number of shapes that need to be in array.
     * @return this array
     */
    public DrawableShape[] create(int num);

    /**
     * This method create one specified shape
     *
     * @param typeOfShape name of shape that need to be create
     * @return this shape
     */
    public DrawableShape create(String typeOfShape);

}
