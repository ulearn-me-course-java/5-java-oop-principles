package com.example.task04;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class RotationFileHandler implements MessageHandler {

    private String path;
    private ChronoUnit rotation;

    public RotationFileHandler(String path, ChronoUnit rotation) {
        this.path = path;
        this.rotation = rotation;
    }
    @Override
    public void log(String message) {
        LocalDateTime now =  LocalDateTime.now();
        now.truncatedTo(rotation);
    }

}
