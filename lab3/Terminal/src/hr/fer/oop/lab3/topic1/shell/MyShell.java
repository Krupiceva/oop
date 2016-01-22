/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.fer.oop.lab3.topic1.shell;

import hr.fer.oop.lab3.topic1.SimpleHashtable;
import hr.fer.oop.lab3.topic1.shell.commands.CdCommand;
import hr.fer.oop.lab3.topic1.shell.commands.CopyCommand;
import hr.fer.oop.lab3.topic1.shell.commands.FilterCommand;
import hr.fer.oop.lab3.topic1.shell.commands.HelpCommand;
import hr.fer.oop.lab3.topic1.shell.commands.QuitCommand;
import hr.fer.oop.lab3.topic1.shell.commands.TerminalCommand;
import hr.fer.oop.lab3.topic1.shell.commands.TypeCommand;
import hr.fer.oop.lab3.topic1.shell.commands.XcopyCommand;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Iterator;

/**
 *
 * @author Dora Mlinaric 0036480184
 * @version 1.0
 */
public class MyShell {

    private static SimpleHashtable commands;

    public MyShell() {

    }

    static {
        commands = new SimpleHashtable();
        ShellCommand[] cc = {
            new CdCommand(),
            new QuitCommand(),
            new TerminalCommand(),
            new HelpCommand(),
            new TypeCommand(),
            new FilterCommand(),
            new CopyCommand(),
            new XcopyCommand()

        };

        for (ShellCommand c : cc) {

            commands.put(c.getCommandName(), (Object) c);
        }
    }

    public static class EnvironmentImpl implements Environment {

        SimpleHashtable terminals;
        Terminal activeTerminal;
        BufferedReader reader;
        BufferedWriter writer;

        public EnvironmentImpl() {
            terminals = new SimpleHashtable();
            activeTerminal = new Terminal(1);

            terminals.put(1, activeTerminal);

            try {
                reader = new BufferedReader(new InputStreamReader(System.in));
                writer = new BufferedWriter(new OutputStreamWriter(System.out));
            } catch (Exception e) {
                System.err.println("IO Exception");
            }

        }

        @Override
        public String readLine() throws IOException {
            String line = reader.readLine();
            return line;
        }

        @Override
        public void write(String string) throws IOException {
            writer.write(string);
            writer.flush();
        }

        @Override
        public void writeLine(String string) throws IOException {
            writer.write(string);
            writer.newLine();
            writer.flush();
        }

        @Override
        public Terminal getActiveTerminal() {
            return activeTerminal;
        }

        @Override
        public void setActiveTerminal(Terminal terminal) {
            activeTerminal = terminal;
        }

        @Override
        public Terminal getOrCreateTerminal(int ID) {
            if (terminals.get(ID) != null) {
                return (Terminal) terminals.get(ID);
            }

            Terminal newTerminal = new Terminal(ID);
            terminals.put(ID, newTerminal);
            return newTerminal;
        }

        @Override
        public Terminal[] listTerminals() {
            Terminal[] arrayOfTerminals = new Terminal[terminals.size()];
            int index = 0;
            for (Object o : terminals) {
                Terminal tempTerminal = (Terminal) ((SimpleHashtable.TableEntry) o).getValue();
                arrayOfTerminals[index++] = tempTerminal;
            }
            return arrayOfTerminals;
        }

        @Override
        public Iterable<Object> commands() {

            return new Iterable<Object>() {

                @Override
                public Iterator<Object> iterator() {
                    return commands.iterator();
                }

            };
        }
    }

    private static Environment environment = new EnvironmentImpl();

    public static void main(String[] args) throws IOException {
        environment.writeLine("Welcome to MyShell! You may enter commands.");

        while (true) {
            environment.write("$" + environment.getActiveTerminal().getId() + environment.getActiveTerminal().getCurrentPath() + "> ");
            String cmd = null;
            String arg = null;

            String line = environment.readLine();
            String[] separateWordsInLine = line.split(" ");
            for (int index = 0; index < separateWordsInLine.length; index++) {
                if (index == 0) {
                    cmd = separateWordsInLine[index].toUpperCase();
                    //System.out.println(cmd);
                } else if (index == 1) {
                    arg = separateWordsInLine[index];
                } else {
                    arg = arg + " " + separateWordsInLine[index];
                }
            }

            ShellCommand shellCommand = (ShellCommand) commands.get(cmd);

            if (shellCommand == null) {
                environment.writeLine("Unknown command!");
                continue;
            }
            if (shellCommand.execute(environment, arg) == CommandStatus.EXIT) {
                break;
            }

            System.out.println("\n");

        }

        environment.writeLine("Thank you for using this shell. Goodbye!");
    }
}
