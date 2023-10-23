package com.example.task04;

import java.io.FileWriter;
import java.text.MessageFormat;

public class FileHandler implements MessageHandler {
    private String fileName = "log";

    public FileHandler() {
    }

    public FileHandler(String fileName) {
        this.fileName = fileName;
    }

    public void setFileName(String name) {
        this.fileName = name;
    }

    public void log(String message) {
        try(FileWriter writeFile = new FileWriter(MessageFormat.format("{0}.txt",fileName), true)) {
            writeFile.append(String.format("%s\n", message));
            writeFile.flush();
        }catch (Exception ex){
            System.err.println(ex.getMessage());
        }
    }
}
