/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.fer.oop.lab3.topic1.shell;

import java.io.IOException;

/**
 *
 * @author Dorchy
 */
public interface Environment {
    
    public String readLine() throws IOException;
    public void write(String string) throws IOException;
    public void writeLine(String string) throws IOException;
    public Terminal getActiveTerminal();
    public void setActiveTerminal(Terminal terminal);
    public Terminal getOrCreateTerminal(int ID);
    public Terminal[] listTerminals();
    public Iterable commands();
    
}
