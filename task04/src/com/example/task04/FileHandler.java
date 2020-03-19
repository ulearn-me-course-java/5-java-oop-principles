package com.example.task04;

import java.io.*;

public class FileHandler implements MessageHandler {
    private final String path;

    public FileHandler(String path) {
        this.path = path;
    }

    @Override
    public void log(String message) {
        try(FileWriter writer = new FileWriter(path, true)) {
            writer.write(message);
            writer.flush(); //финализирует выходное состояние, очищая все буферы вывода
        } catch (IOException err) {
            err.printStackTrace(); //что произошло и где в коде это произошло
        }
    }
}
