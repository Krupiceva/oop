/*
 * 2. laboratorijska vjezba iz Objektno orijentiranog programiranja
 */
package hr.fer.oop.lab2.topic1.collections;

/**
 * This class demonstrate use of SimpleHashTable
 *
 * @author Dora Mlinarić
 */
public class main {

    /**
     * This method is called when program start
     *
     * @param args command line parameter
     */
    public static void main(String[] args) {
        // create collection:

        int capacity = -1;
        SimpleHashtable examMarks;
        while (true) {
            try {
                examMarks = new SimpleHashtable(capacity);
            } catch (IllegalArgumentException exception) {
                System.out.println("Wrong capacity. Please enter new one.");
                capacity = 2;
                continue;
            }
            break;
        }

        // fill data:
        examMarks.put("Ivana", 2);
        examMarks.put("Ante", 2);
        try {
            examMarks.put(null, 3);
        } catch (NullPointerException exception) {
            System.out.println("Key cannot be null, go to next element.");
        }
        examMarks.put("Jasna", 2);
        examMarks.put("Kristina", 5);
        examMarks.put("Ivana", 5); // overwrites old grade for Ivana
        // query collection:
        Integer kristinaGrade = (Integer) examMarks.get("Kristina");
        System.out.println("Kristina's exam grade is: " + kristinaGrade);
        // What is collection's size? Must be four!
        System.out.println("Number of stored pairs: " + examMarks.size());

        System.out.println(examMarks.containsKey("Emil"));
        System.out.println(examMarks.containsValue(2));
        try {
            System.out.println(examMarks.containsKey(null));
        } catch (NullPointerException e) {
            System.out.println("Key cannot be null.");
        }

        System.out.println(examMarks.sizeOfTable());

        examMarks.toStringPrint();
    }

}
