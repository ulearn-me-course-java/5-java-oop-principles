package com.example.task04;

import java.io.File;
import java.time.temporal.ChronoUnit;
import java.io.FileWriter;
import java.io.IOException;

public class RotationFileHandler implements MessageHandler {
    private ChronoUnit duration;
    private long lastTimePrint;
    private String path;
    private File file;

    public RotationFileHandler(String path, ChronoUnit duration) {
        this.duration = duration;
        this.path = path;
        this.lastTimePrint = System.currentTimeMillis();
        file = new File(path + "[" + lastTimePrint + "] ");
    }

    public void printMessage(String message) {
        try {
            if(System.currentTimeMillis() - lastTimePrint >= duration.getDuration().toMillis()){
                lastTimePrint = System.currentTimeMillis();
                file = new File(path + "[" + lastTimePrint + "] ");
            }
            FileWriter writer = new FileWriter(file, true);
            writer.append(message);
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
