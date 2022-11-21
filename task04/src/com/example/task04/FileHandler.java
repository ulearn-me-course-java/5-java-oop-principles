package com.example.task04;

import java.io.*;
import java.nio.Buffer;

public class FileHandler implements MessageHandler {
    FileWriter writer;

    public FileHandler(String path) throws IOException {
        File file = new File(path);
        if(!file.exists())
            file.createNewFile();
        writer = new FileWriter(file, true);
    }

    @Override
    public void log(String message) {
        try {
            writer.write(message);
            writer.flush();
        }
        catch (IOException e) {
            System.out.println("Ошибка: " + e);
        }
    }
}