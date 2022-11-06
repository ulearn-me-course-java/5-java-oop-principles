package com.example.task04;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileHandler implements MessageHandler {
    private final PrintWriter _printWriter;

    public FileHandler(String fileName) {
        try {
            _printWriter = new PrintWriter(new FileWriter(fileName + ".txt"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void processMessage(String message) {
        _printWriter.print(message);
        _printWriter.flush();
    }
}
