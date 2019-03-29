package com.example.task04;

import java.io.FileWriter;
import java.io.IOException;

public class FileHandler implements MessageHandler {
    FileWriter logWriter;

    FileHandler(String filePath) {
        try {
            logWriter = new FileWriter(filePath, false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void printMessage(String message) {
        try {
            logWriter.write(message + '\n');
            logWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
