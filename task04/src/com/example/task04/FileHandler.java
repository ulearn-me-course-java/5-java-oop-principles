package com.example.task04;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;

public class FileHandler implements MessageHandler {
    private final Path path;

    public FileHandler(Path path) {
        this.path = path;
    }

    @Override
    public void log(String text) {
        try {
            FileWriter fw = new FileWriter(path.toString(), true);
            fw.write(text + "\n");
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
