package com.example.task04;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileHandler implements MessageHandler {
    String filePath;

    FileHandler(String filePath) {
        this.filePath = filePath;
        new File(filePath).delete();
    }

    @Override
    public void printMessage(String message) {
        try {
            FileWriter writer = new FileWriter(filePath, true);
            writer.write(message + '\n');
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
