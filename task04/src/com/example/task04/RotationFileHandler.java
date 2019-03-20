package com.example.task04;

import java.time.temporal.ChronoUnit;

public class RotationFileHandler implements MessageHandler {
    private final ChronoUnit chronoUnit;
    private long firstTime;
    private static int count;
    private final String path;
    private static String currentPath;

    public RotationFileHandler(String path, ChronoUnit chronoUnit) {
        this.path = path;
        currentPath = path;
        this.chronoUnit = chronoUnit;
        firstTime = System.currentTimeMillis();
    }

    private String createNewFileName(int i){
        int dotIndex = path.lastIndexOf('.');
        return path.substring(0, dotIndex) + i + path.substring(dotIndex);
    }

    private long getElapsed(){
        return (System.currentTimeMillis() - firstTime) / 1000;
    }

    @Override
    public void showMessage(String message) {
        if (getElapsed() > chronoUnit.getDuration().getSeconds()){
            currentPath = createNewFileName(++count);
        }
        new FileHandler(currentPath).showMessage(message);
    }
}
