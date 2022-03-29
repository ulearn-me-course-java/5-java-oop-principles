package com.example.task04;

import java.io.FileWriter;
import java.io.IOException;

public class FileHandler implements MessageHandler{
    private final String path = "task04\\src\\logMessage.txt";
    @Override
    public void logMessage(String message) {
        try (FileWriter writer = new FileWriter(path, true)){
            writer.write(message + "\n");
            writer.flush();
        } catch (IOException exception) {
            exception.printStackTrace();
            System.out.println("Error in FileHandler");
        }
    }
}
