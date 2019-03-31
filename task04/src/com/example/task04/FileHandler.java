package com.example.task04;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileHandler implements MessageHandler {

    private String path;

    public FileHandler(String path){
        this.path = path;
    }

    @Override
    public void printMessage(String message) {
        try {
            File file = new File(path);
            FileWriter writer = new FileWriter(file, true);
            writer.append(message);
            writer.flush();
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
