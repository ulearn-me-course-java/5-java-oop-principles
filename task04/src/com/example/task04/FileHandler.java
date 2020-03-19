package com.example.task04;

import java.io.*;

public class FileHandler implements MessageHandler {

    private FileWriter outputFile;

    public FileHandler( String path) throws IOException {
        this.outputFile = new FileWriter(path, true);
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            try {
                outputFile.flush();
                outputFile.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }));
    }

    @Override
    public void printMessage( String message) {
        try {
            outputFile.append(message + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

