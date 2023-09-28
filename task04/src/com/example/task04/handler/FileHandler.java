package com.example.task04.handler;

import java.io.FileWriter;
import java.io.IOException;

public class FileHandler implements MessageHandler {
    @Override
    public void handleMessage(String message) {
        try (FileWriter writer = new FileWriter("LogMessages.txt", true)) {
            writer.write(message);
            writer.write("\n");
            writer.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
