package com.example.task04.handlers;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileHandler implements MessageHandler {
    private PrintWriter writer;

    public FileHandler() {
        setFile(null);
    }

    public FileHandler(String filename) {
        setFile(filename);
    }

    protected String getFilenameByTime() {
        return String.format("%s.log", new SimpleDateFormat("yyyy-MM-dd--HH-mm").format(new Date()));
    }

    protected void setFile(String filename) {
        if (filename == null) {
            filename = getFilenameByTime();
        }

        try {
            File file = new File(filename);
            System.out.println("Using: " + file.getAbsoluteFile());

            if (!file.exists()) {
                //noinspection ResultOfMethodCallIgnored
                file.createNewFile();
            }

            writer = new PrintWriter(new FileWriter(file, true), true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void handle(String message) {
        writer.println(message);
    }
}
