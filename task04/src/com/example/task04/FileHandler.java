package com.example.task04;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class FileHandler implements MessageHandler{

    private final Path path;

    public FileHandler(String fileName) {
        path = Paths.get(fileName);
    }

    @Override
    public void log(String message) {
        try {
            Files.write(path, (message + "\n").getBytes(StandardCharsets.UTF_8), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
