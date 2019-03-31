package com.example.task04;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Date;

public class RotationFileHandler implements MessageHandler {

    private String path;
    private LocalDateTime currentTime;
    private Duration duration;

    public RotationFileHandler(String path, LocalDateTime currentTime, Duration duration){
        this.path = path;
        this.duration = duration;
        this.currentTime = currentTime;
    }
    @Override
    public void printMessage(String message) {
        if(duration.getSeconds() - Duration.between(currentTime, LocalDateTime.now()).getSeconds() < 0){
            currentTime = LocalDateTime.now();
            path = createPath(path, new Date().toString());
        }
        new FileHandler(path).printMessage(message);
    }

    private String createPath(String oldPath, String time){
        int temp = oldPath.lastIndexOf('\\');
        String newPath = oldPath.substring(0, temp).concat("\\" + time);
        return newPath;
    }
}