package com.example.task04;

import java.io.FileWriter;

import java.io.IOException;

public class FileHandler implements MessageHandler {
    @Override
    public void log(String message) {
        try (FileWriter writer = new FileWriter("task04\\src\\log.txt", true)) {
            writer.write(message + "\n\n");
            writer.flush();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
