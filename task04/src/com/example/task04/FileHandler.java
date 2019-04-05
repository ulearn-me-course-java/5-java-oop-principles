package com.example.task04;

import java.io.FileWriter;
import java.io.IOException;

public class FileHandler implements MessageHandler {

    private final String path;

    public FileHandler(String path) {
        this.path = path;
    }

    @Override
    public void print(String message) {
        try {
            FileWriter file = new FileWriter(path, true);
            file.write(message + "\n");
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}