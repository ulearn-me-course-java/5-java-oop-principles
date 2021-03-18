package com.example.task04;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileHandler implements MessageHandler {

    private final String path;

    public FileHandler(String path) {
        this.path = path;
    }

    public void log(String message, String path) {
        SimpleDateFormat dt = new SimpleDateFormat("yyyy.MM.dd hh:mm:ss");

        File f = new File(path, String.format("%s.txt", dt.format(new Date())));
        try (FileWriter writer = new FileWriter(f.getAbsolutePath(), true)) {
            writer.append(message);
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void log(String message) {
        log(message, path);
    }
}