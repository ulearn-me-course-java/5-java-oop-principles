package com.example.task04;

import java.io.FileWriter;

public class FileHandler implements MessageHandler {

   @Override
    public void log(String message) {
        try (FileWriter writer = new FileWriter(("log.txt"), true)) {
            writer.append(String.format("%s ", message));
            writer.flush();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
