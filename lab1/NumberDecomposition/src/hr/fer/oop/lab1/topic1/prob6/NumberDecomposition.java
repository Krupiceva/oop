/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.fer.oop.lab1.topic1.prob6;

/**
 *
 * @author Dora Mlinarić 0036480184
 */
public class NumberDecomposition {
    
    /**
     * This method is called once the program is run.
     * Decomposes number on prime factors
     * Arguments are described below
     * @param args Command line arguments.
     */
    
    public static void main(String[] args){
       if(args.length!=1){
           System.err.println("You must enter one argument.");
           System.exit(1);
       }
       
       int number = Integer.parseInt(args[0]);
       if(number<=1){
           System.err.println("Argument must be grater than 1.");
           System.exit(1);
       }
       
       System.out.println("You requested decomposition of number " + number + " onto prime factors. Here they are:");
       
       int i=2;
       int counter=1;
       
       while(i<=number){
           if(number%i==0){
               System.out.println(counter + ". " + i);
               number=number / i;
               counter++;
           }
           else i++;
       }
    }
    
}
