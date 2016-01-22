/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.fer.oop.lab1.topic1.prob4;

/**
 *
 * @author Dora Mlinarić 0036480184
 */
public class Roots {
    
    /**
     * This method is called once the program is run.
     * Arguments are described below
     * @param args Command line arguments.
     */
    
    public static void main (String[] args){
        if (args.length!=3){
            System.err.println("Invalid number of arguments.");
            System.exit(1);
        }
        
        if(Integer.parseInt(args[2])<1){
            System.err.println("Root must be grater than 1.");
            System.exit(1);
        }
        float Re = Float.parseFloat(args[0]);
        float Im = Float.parseFloat(args[1]);
        int n = Integer.parseInt(args[2]);
        printRoots (Re, Im, n);
        
    }
    
    /**
     * Print roots of complex number
     * convert complex number in trig. form
     * @param Re is real part of complex number
     * @param Im is imaginary part of complex number
     * @param n is root
     */
    
    public static void printRoots (float Re, float Im, int n){
        
        System.out.println("You requested calculation of " + n + ". roots. Solutions are:");
        
        double modul = Math.sqrt(Re * Re + Im * Im);
        modul = Math.pow(modul, 1/(double) n);
        
        double arg = Math.atan(Im / Re);
        
        for (int k=0; k<n; k++){
           float ReTrig = (float) (modul * Math.cos((arg + 2 * k * Math.PI) / (double) n));
           float ImTrig = (float) (modul * Math.sin((arg + 2 * k * Math.PI) / (double) n));
           System.out.println((k + 1) + ") " + (int) ReTrig + (ImTrig < 0 ? " - " : " + ") + (int) Math.abs(ImTrig) + "i");
        }
    }
}
