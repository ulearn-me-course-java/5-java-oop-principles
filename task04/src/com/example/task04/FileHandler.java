package com.example.task04;

import java.io.FileWriter;
import java.io.IOException;

public class FileHandler {
    public void log(String message) throws IOException {
        try (FileWriter writer = new FileWriter("task04\\src\\log.txt", true)) {
            writer.write(message + "\n\n");
            writer.flush();
        }
        catch (IOException e) {
            e.printStackTrace();
            System.out.println("GG");
        }
    }
}
