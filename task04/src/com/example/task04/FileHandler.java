package com.example.task04;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileHandler implements MessageHandler {

    private String path;

    public FileHandler(String path) {
        this.path = path;
    }

    @Override
    public void logger(String message) {
        File file = new File(path);
        try (FileOutputStream fileOutputStream = new FileOutputStream(file)) {
            fileOutputStream.write(message.getBytes());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
