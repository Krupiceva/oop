/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.fer.oop.lab3.topic1.shell.commands;

import hr.fer.oop.lab3.topic1.shell.CommandStatus;
import hr.fer.oop.lab3.topic1.shell.Environment;
import hr.fer.oop.lab3.topic1.shell.Terminal;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dora Mlinaric
 */
public class CdCommand extends AbstractCommand {

    /**
     * Constructor for command
     */
    public CdCommand() {
        super("CD", "Command for navigation through directories");
    }

    /**
     * This method change active directory in shell
     *
     * @param e is environment in shell
     * @param arg is accepted string witch represents directory
     * @return CommandStatus.CONTINUE
     */
    @Override
    public CommandStatus execute(Environment e, String arg) throws IOException {
        Terminal activeTerminal = e.getActiveTerminal();
        Path current = activeTerminal.getCurrentPath();

        if (arg.equals("..")) {
            Path parent = current.getParent();
            activeTerminal.setCurrentPath(parent);
            //try {
                e.writeLine("Current directory is now set to " + parent.toString() + ".");
//            } catch (IOException ex) {
//                Logger.getLogger(CdCommand.class.getName()).log(Level.SEVERE, null, ex);
//            }
        } else {
            String currentString = current.toString();
            String newString = currentString + "/" + arg;
            Path newPath = Paths.get(newString);
            File newFile = newPath.toFile();
            if (!newFile.exists()) {
                try {
                    e.writeLine("There is no such directory");
                } catch (IOException ex) {
                    Logger.getLogger(CdCommand.class.getName()).log(Level.SEVERE, null, ex);
                }
                return CommandStatus.CONTINUE;
            }
            activeTerminal.setCurrentPath(newPath);
            try {
                e.writeLine("Current directory is now set to " + newPath.toString() + ".");
            } catch (IOException ex) {
                Logger.getLogger(CdCommand.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return CommandStatus.CONTINUE;
    }
}
