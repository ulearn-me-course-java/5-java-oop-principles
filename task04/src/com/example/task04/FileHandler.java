package com.example.task04;


import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.List;

public class FileHandler implements MessageHandler {

    private final String path;

    @Override
    public void addMessage(String message) {
        try {
            List<String> msg = Arrays.asList(message);
            Files.write(Paths.get(path), msg, StandardCharsets.UTF_8, StandardOpenOption.APPEND);
        }
        catch (Exception ex) {
            return;
        }
    }

    public FileHandler(String path) {
        this.path = path;
    }
}
