/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.fer.oop.lab3.topic1.shell;

/**
 *
 * @author Dorchy
 */
public interface ShellCommand {
    
    public String getCommandName();
    public String getCommandDescription();
    public CommandStatus execute(Environment environment, String line);
    
}
