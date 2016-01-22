/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.fer.oop.lab1.topic1.prob5;

/**
 *
 * @author Dora Mlinarić 0036480184
 */
public class PrimeNumbers {
    
    /**
     * This method is called once the program is run.
     * Calculate root of a complex number
     * Arguments are described below
     * @param args Command line arguments.(Complex number)
     */
    
    public static void main(String[] args){
        int limit = Integer.parseInt(args[0]);
        
        if(limit<=0){
            System.err.println("Number must be grater than 0");
            System.exit(1);
        }
        
        System.out.println("You requested calculation of " + limit + " prime numbers. Here they are:");
        System.out.println("1. 2");
        
        int counter=1;
        int number=3;
        int i=2;
        
        while(counter<limit){
            int div=2;
            boolean prim=true;
            
            while(div<number){
                if(number%div==0){
                    prim=false;
                    break;
                }
                div++;
            }
            if(prim==true){
                System.out.println(i + ". " + number);
                counter++;
                i++;
            }
            number++;
        }
        
    }
    
}
