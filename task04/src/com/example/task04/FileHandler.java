package com.example.task04;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileHandler implements MessageHandler{
    private String path;

    public FileHandler(String path) {
        this.path = path;
    }
    @Override
    public void log(String message) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("path");
            fileOutputStream.write(message.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}