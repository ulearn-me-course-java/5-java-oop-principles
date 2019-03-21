package com.example.task04;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileHandler implements MessageHandler {

    private final String path;

    public FileHandler(String path){
        this.path = path;
    }

    @Override
    public void printMessage(String message) {
            try {
                File file = new File(path);
                FileWriter fileWriter = new FileWriter(file, true);

                fileWriter.append(message);
                fileWriter.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
    }
}
