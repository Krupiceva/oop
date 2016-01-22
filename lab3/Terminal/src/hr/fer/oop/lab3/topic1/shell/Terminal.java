/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.fer.oop.lab3.topic1.shell;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author Dorchy
 */
public class Terminal {
    private final int ID;
    private Path currentPath=Paths.get(".").normalize().toAbsolutePath();
    
    public Terminal(int ID){
        this.ID=ID;
    }
    
    public int getId(){
        return ID;
    }
    
    public Path getCurrentPath(){
        return currentPath;
    }
    
    public void setCurrentPath(Path currentPath){
        this.currentPath=currentPath;
    }
}
