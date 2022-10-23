package com.example.task04;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class RotationFileHandler implements MessageHandler{

    private String path;
    private String filename;
    private ChronoUnit chronoUnit;

    public RotationFileHandler(String path, String filename, ChronoUnit chronoUnit){

        this.path = path;
        this.filename = filename;
        this.chronoUnit = chronoUnit;
    }

    @Override
    public void log(String message) throws IOException {
        LocalDateTime time = LocalDateTime.now().truncatedTo(chronoUnit);
        FileWriter writer = new FileWriter(path+time+filename);
        writer.append(message);
        writer.flush();
    }
}
