package com.example.task04;

import java.io.FileWriter;
import java.io.IOException;

public class FileHandler implements Handler {
    @Override
    public void log(String message) {
        try (FileWriter writer = new FileWriter("Logger.txt", true)) {
            writer.write(message + '\n');
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
