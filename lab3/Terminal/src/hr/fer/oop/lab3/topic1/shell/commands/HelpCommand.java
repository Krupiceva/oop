/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.fer.oop.lab3.topic1.shell.commands;

import hr.fer.oop.lab3.topic1.SimpleHashtable;
import hr.fer.oop.lab3.topic1.shell.CommandStatus;
import hr.fer.oop.lab3.topic1.shell.Environment;
import hr.fer.oop.lab3.topic1.shell.ShellCommand;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dorchy
 */
public class HelpCommand extends AbstractCommand {

    public HelpCommand() {
        super("HELP", "List all commands and their description.");
    }

    @Override
    public CommandStatus execute(Environment environment, String line) {
        for (Object c : environment.commands()) {
            SimpleHashtable.TableEntry command = (SimpleHashtable.TableEntry) c;
            AbstractCommand comm = (AbstractCommand) command.getValue();
            try {
                environment.writeLine(comm.getCommandName() + "-" + comm.getCommandDescription());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return CommandStatus.CONTINUE;
    }
}
