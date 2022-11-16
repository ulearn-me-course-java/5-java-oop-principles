package com.example.task04;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class RotationFileHandler implements MessageHandler {

    private String path;

    private ChronoUnit interval;

    public RotationFileHandler(String path, ChronoUnit interval ){
        if(path == null) throw new IllegalArgumentException("enter directory path");
        this.path = path;
        this.interval = interval;
    }

    @Override
    public void toWrite(String message) {
        String now = LocalDateTime.now()
                .truncatedTo(interval)
                .format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh-mm-ss"));

        File file = new File(path, now + ".txt");

        try(FileWriter writer = new FileWriter(file, true)) {
            writer.write(message);
            writer.append('\n');
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
