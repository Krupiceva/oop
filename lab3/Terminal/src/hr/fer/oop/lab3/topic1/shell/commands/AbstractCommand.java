/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.fer.oop.lab3.topic1.shell.commands;

import hr.fer.oop.lab3.topic1.shell.ShellCommand;

/**
 *
 * @author Dorchy
 */
public abstract class AbstractCommand implements ShellCommand{

    String commandName;
    String commandDescription;

    public AbstractCommand(String name, String description) {
        commandName = name;
        commandDescription = description;

    }
    
    @Override
    public String getCommandName(){
        return commandName;
    }
    
    @Override
    public String getCommandDescription(){
        return commandDescription;
    }

}
