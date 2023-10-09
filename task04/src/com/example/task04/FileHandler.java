package com.example.task04;

import java.io.FileWriter;
import java.io.IOException;

public class FileHandler implements MessageHandler {
    @Override
    public void handleMessage(String message) {
        try (FileWriter fw = new FileWriter("Messages.txt", true)) {
            fw.write(message);
            fw.append("\n");
            fw.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
