/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.fer.oop.lab3.topic1;

/**
 * This class demonstrate how SimpleHashTable works
 *
 * @author Dora Mlinaric
 */
public class Main {

    public static void main(String[] args) {
        // create collection:
        SimpleHashtable examMarks = new SimpleHashtable(20);
        // fill data:
        examMarks.put("Ivana", Integer.valueOf(2));
        examMarks.put("Ante", Integer.valueOf(2));
        examMarks.put("Jasna", Integer.valueOf(2));
        examMarks.put("Kristina", Integer.valueOf(5));
        examMarks.put("Ivana", Integer.valueOf(5)); // overwrites old grade for Ivana

        for (Object entrya : examMarks) {
        for (Object entry : examMarks) {
            SimpleHashtable.TableEntry pair = (SimpleHashtable.TableEntry) entry;
            System.out.printf("%s => %s%n", pair.getKey(), pair.getValue());
        }
        }

    }

}
