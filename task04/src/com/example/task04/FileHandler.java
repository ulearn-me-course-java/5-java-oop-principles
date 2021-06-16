package com.example.task04;

import java.io.FileWriter;
import java.io.IOException;

public class FileHandler implements MessageHandler{
    private String filePath;

    public FileHandler(String path) {
        this.filePath = path;
    }

    @Override
    public void log(String message) {
        try {
            FileWriter fileWriter = new FileWriter(filePath, true);
            fileWriter.append(message);
            fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
