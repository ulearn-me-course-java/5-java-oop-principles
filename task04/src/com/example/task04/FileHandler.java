package com.example.task04;

import java.io.FileWriter;
import java.text.MessageFormat;

public class FileHandler implements MessageHandler {

    private String fileName = "data";

    public FileHandler(String fileName) {
        this.fileName = fileName;
    }

    public FileHandler() {}

    @Override
    public void log(String message) {
        try {
            FileWriter fw = new FileWriter(MessageFormat.format("{0}.txt", fileName), true);
            fw.append(message);
            fw.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
