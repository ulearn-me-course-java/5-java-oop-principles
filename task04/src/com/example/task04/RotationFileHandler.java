package com.example.task04;

import java.time.Duration;
import java.util.Date;

public class RotationFileHandler implements MessageHandler {

    private String path;
    private Duration duration;
    private long lastTime;

    public RotationFileHandler(String path, Duration duration){
        this.path = path;
        this.duration = duration;
    }
    @Override
    public void showMessage(String message) {
        if(duration.getSeconds() - lastTime < 0){
            path = createPath(path, new Date().toString());
            lastTime = new Date().getTime();
        }
        new FileHandler(path).showMessage(message);
    }

    private String createPath(String oldPath, String time){
        int temp = oldPath.lastIndexOf('/');
        String newPath = oldPath.substring(0, temp).concat(time);
        return newPath;
    }
}
