package com.example.task04;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.MessageFormat;

public class FileHandler implements MessageHandler {
    private final String fileName;

    public FileHandler(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void log(String message) {
        try (FileWriter fileWriter = new FileWriter(MessageFormat.format("{0}.txt", fileName), true)) {
            fileWriter.append(message);
            fileWriter.flush();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}