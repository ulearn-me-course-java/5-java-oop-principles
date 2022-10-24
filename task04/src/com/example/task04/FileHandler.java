package com.example.task04;

import java.io.FileWriter;
import java.text.MessageFormat;

public class FileHandler implements MessageHandler{

    private String fileName = "log";

    public FileHandler(String fileName) {
        this.fileName = fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
    @Override
    public void log(String message) {
        try(FileWriter fileWriter = new FileWriter(MessageFormat.format("{0}.txt",fileName), true)) {
            fileWriter.append(String.format("%s\n", message));
            fileWriter.flush();
        } catch (Exception exception){
            System.err.println(exception.getMessage());
        }
    }
}