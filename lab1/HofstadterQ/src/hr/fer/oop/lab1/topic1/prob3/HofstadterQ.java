/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.fer.oop.lab1.topic1.prob3;

/**
 * @author Dora Mlinarić 0036480184
 */
public class HofstadterQ {
    
    /**
     * This method is called once the program is run.
     * Arguments are described below
     * @param args Command line arguments.
     */
    
    public static void main (String[] args){
        
        long num = Long.parseLong(args[0]);
        if (num<0){
            System.err.println("Number is negative.");
            System.exit(1);
        }
        long Qsequence = calcH(num);
        System.out.println("You requested calculation of " + num + ". number of Hofstadter's Q-sequence. The requested\n" +
"number is " + Qsequence + ".");
    }
    
    /**
     * calculate i-ti number of Hofstadter Q-sequence
     *  http://en.wikipedia.org/wiki/Hofstadter_sequence
     * @param i requested number
     * @return Q-sequence
     */
    
    public static long calcH (long i){
        if (i<=2) return 1;
        else return calcH(i-calcH(i-1)) + calcH(i-calcH(i-2));
        
    }
    
}
