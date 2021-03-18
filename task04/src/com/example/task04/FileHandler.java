package com.example.task04;

import java.io.FileWriter;
import java.io.IOException;

public class FileHandler implements MessageHandler{
    @Override
    public void log(String message) {

        String path = "task04\\src\\log.txt";

        try (FileWriter writer = new FileWriter(path,true)) {
            writer.write(message + "\n\n");
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("file handler error");
        }

    }
}
