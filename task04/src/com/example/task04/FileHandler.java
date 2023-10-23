package com.example.task04;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.text.MessageFormat;

public class FileHandler implements MessageHandler{
    private final String path;

    public FileHandler(String path){
        this.path = path;
    }

    @Override
    public void log(String message){
        File file = new File(path);
        try (FileOutputStream fileOutputStream = new FileOutputStream(file)) {
            fileOutputStream.write(message.getBytes());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
