package com.example.task04;

import java.io.FileWriter;
import java.io.IOException;

public class FileHandler implements MessageHandler{
    @Override
    public void log(String message) {
        try (FileWriter fileWriter = new FileWriter("task04\\src\\message.txt", false)) {
            fileWriter.write(message + "\n\n");
            fileWriter.flush();
        }
        catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
