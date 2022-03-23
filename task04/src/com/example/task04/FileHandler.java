package com.example.task04;

import java.io.FileOutputStream;
import java.io.IOException;

public class FileHandler implements MessageHandler{
    private String path;

    public FileHandler(String path) {
        this.path = path;
    }

    @Override
    public void log(String text) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("path");
            fileOutputStream.write(text.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
