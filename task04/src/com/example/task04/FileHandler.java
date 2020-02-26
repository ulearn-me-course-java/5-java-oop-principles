package com.example.task04;

import java.io.*;

public class FileHandler implements MessageHandler {
    private final String path;

    public FileHandler(String path) {
        this.path = path;
    }

    @Override
    public void log(String message) {
        try(FileWriter writer = new FileWriter(path, true)) {
            writer.append(message);
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
