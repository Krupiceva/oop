/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.fer.oop.lab3.topic1.shell.commands;

import hr.fer.oop.lab3.topic1.shell.CommandStatus;
import hr.fer.oop.lab3.topic1.shell.Environment;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dorchy
 */
public class CopyCommand extends AbstractCommand {

    public CopyCommand() {
        super("COPY", "Copy files (not directories)");
    }

    @Override
    public CommandStatus execute(Environment environment, String line) {
        String tmp[] = line.split(" ");
        File currentDir = environment.getActiveTerminal().getCurrentPath().toFile();
        if (tmp.length != 2) {
            try {
                environment.writeLine("Invalid number of argumants");
            } catch (IOException ex) {
                Logger.getLogger(CopyCommand.class.getName()).log(Level.SEVERE, null, ex);
            }
            return CommandStatus.CONTINUE;
        }
        File source = getFile(tmp[0], currentDir);
        File dest = getFile(tmp[1], currentDir);

        if (!source.exists() || dest == null) {
            try {
                environment.writeLine("Wrong input");
            } catch (IOException ex) {
                Logger.getLogger(CopyCommand.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            if (source.isFile()) {
                if (dest.exists() && dest.isDirectory()) {
                    dest = new File(dest.getAbsolutePath() + "/" + checkGetName(source.getName(), dest));
                }
                copyFile(source, dest);
            } else {
                if (!dest.exists() || dest.isFile()) {
                    try {
                        environment.writeLine(" Can't copy to: " + dest.getAbsolutePath());
                    } catch (IOException ex) {
                        Logger.getLogger(CopyCommand.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    File newDir = new File(dest.getAbsolutePath() + "/" + checkGetName(source.getName(), dest));
                    newDir.mkdir();
                }
            }
        }
        return CommandStatus.CONTINUE;
    }

    private static File getFile(String string, File dir) {
        File file = null;
        if (checkDir(dir, string)) {
            String absolutePath = dir.getAbsoluteFile().toString() + "/" + string;
            if (Files.isReadable(Paths.get(absolutePath))) {
                file = new File(absolutePath);
            }
        } else {
            file = new File(string);
        }
        return file;
    }

    private static boolean checkDir(File currentDir, String string) {
        String list[] = currentDir.list();
        for (String entry : list) {
            if (entry.equals(string)) {
                return true;
            }
        }
        return false;
    }

    private static void copyFile(File source, File dest) {
        try {
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(
                            new BufferedInputStream(
                                    new FileInputStream(source)), StandardCharsets.UTF_8));

            BufferedWriter writer = new BufferedWriter(
                    new OutputStreamWriter(
                            new BufferedOutputStream(
                                    new FileOutputStream(dest)), StandardCharsets.UTF_8));
            char[] buff = new char[1024];
            int len;
            while ((len = reader.read(buff)) > 0) {
                writer.write(buff, 0, len);;
            }

            reader.close();
            writer.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private static String checkGetName(String name, File dir) {
        String fileName = name;
        String extansion = "";
        try {
            fileName = name.substring(0, name.lastIndexOf("."));
            extansion = name.substring(name.lastIndexOf("."));
        } catch (IndexOutOfBoundsException e) {
        };
        File list[] = dir.listFiles();
        if (list == null) {
            return fileName + extansion;
        }
        for (File entry : list) {
            try {
                String entryFileName = entry.getName();
                try {
                    entryFileName = entryFileName.substring(0, entryFileName.lastIndexOf("."));
                } catch (IndexOutOfBoundsException e) {
                }
                if (fileName.equals(entryFileName)) {
                    int num = 1;
                    String tmpFileName = fileName;
                    try {
                        tmpFileName = fileName.substring(0, fileName.lastIndexOf("("));
                        String copyNum = fileName.subSequence(fileName.lastIndexOf("(") + 1, fileName.lastIndexOf("(") + 2).toString();
                        num = Integer.parseInt(copyNum);
                        num++;
                    } catch (IndexOutOfBoundsException | NumberFormatException e) {
                    }
                    fileName = tmpFileName + "(" + num + ")";
                }
            } catch (IndexOutOfBoundsException e) {
                continue;
            }
        }

        return fileName + extansion;
    }

}


