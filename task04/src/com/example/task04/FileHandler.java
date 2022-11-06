package com.example.task04;

import java.io.FileWriter;
import java.io.IOException;
import java.text.MessageFormat;

public class FileHandler implements MessageHandler {
    private String fileName;

    public FileHandler(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void log(String message) {
        try (FileWriter fileWriter = new FileWriter(MessageFormat.format("{0}.txt", fileName), false)) {
            fileWriter.write(String.format("%s", message));
            fileWriter.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
