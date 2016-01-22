/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.fer.oop.lab3.topic1.shell.commands;

import hr.fer.oop.lab3.topic1.shell.CommandStatus;
import hr.fer.oop.lab3.topic1.shell.Environment;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dorchy
 */
public class TypeCommand extends AbstractCommand {
    public TypeCommand(){
        super("TYPE", "List content of file.");
    }
    
    @Override
    public CommandStatus execute(Environment environment, String line) {
        try {
                FileReader fileReader = new FileReader(line);
                BufferedReader in = new BufferedReader(fileReader);
                String oneLine;
                while((oneLine = in.readLine())!= null){
                    environment.writeLine(oneLine);
                }
            } catch (FileNotFoundException ex) {
            try {
                environment.writeLine(line+", file not found.");
            } catch (IOException ex1) {
                Logger.getLogger(TypeCommand.class.getName()).log(Level.SEVERE, null, ex1);
            }
            }
            catch (IOException ex) {
            try {
                environment.writeLine(line+", input/output error.");
            } catch (IOException ex1) {
                Logger.getLogger(TypeCommand.class.getName()).log(Level.SEVERE, null, ex1);
            }
            }
        return CommandStatus.CONTINUE;
    }
        }
        
    

