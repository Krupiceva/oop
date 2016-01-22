/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.fer.oop.lab3.topic1.shell.commands;

import hr.fer.oop.lab3.topic1.shell.CommandStatus;
import hr.fer.oop.lab3.topic1.shell.Environment;
import hr.fer.oop.lab3.topic1.shell.Terminal;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dora Mlinaric
 */
public class TerminalCommand extends AbstractCommand {

    /**
     * Constructor for TerminalCommand
     */
    public TerminalCommand() {
        super("TERMINAL", "Activate terminal with given ID or making new one if that doesn't exist");
    }

    /**
     * This method change active terminal, if terminal do not exist make new one
     *
     * @param environment is environment in shell
     * @param line is accepted argument and represents ID of terminal
     * @return CommandStatus.CONTINUE
     */
    @Override
    public CommandStatus execute(Environment environment, String line) {
        int ID = 0;
        try {
            ID = Integer.valueOf(line);
        } catch (NumberFormatException e) { //if ID isn't number
            try {
                environment.writeLine("ID must be number");
                return CommandStatus.CONTINUE;
            } catch (IOException ex) {
                Logger.getLogger(TerminalCommand.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (environment.getActiveTerminal().getId() == ID) { //if new terminal is current terminal
            try {
                environment.writeLine("Terminal " + Integer.toString(ID) + " is already active");
            } catch (IOException ex) {
                Logger.getLogger(TerminalCommand.class.getName()).log(Level.SEVERE, null, ex);
            }
            return CommandStatus.CONTINUE;
        }

        Terminal newTerminal = environment.getOrCreateTerminal(ID); //if isn't current, make new one or activate one in list
        environment.setActiveTerminal(newTerminal);
        try {
            environment.writeLine("Changed current terminal to " + Integer.toString(ID));

        } catch (IOException ex) {
            Logger.getLogger(TerminalCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
        return CommandStatus.CONTINUE;
    }

}
