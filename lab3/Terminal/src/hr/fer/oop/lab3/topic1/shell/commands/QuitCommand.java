/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.fer.oop.lab3.topic1.shell.commands;

import hr.fer.oop.lab3.topic1.shell.CommandStatus;
import hr.fer.oop.lab3.topic1.shell.Environment;

/**
 *
 * @author Dorchy
 */
public class QuitCommand extends AbstractCommand {
    public QuitCommand(){
        super("QUIT", "Exit the shell");
    }
    
    @Override
    public CommandStatus execute(Environment environment, String line){
        return CommandStatus.EXIT;
    }
    
}
