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
public class XcopyCommand extends AbstractCommand {
    public XcopyCommand(){
        super("XCOPY", "Recursive copy all fodlers and subfolders.");
    }
    
    @Override
    public CommandStatus execute(Environment environment, String line) {
        return CommandStatus.CONTINUE;
    }
    
}
