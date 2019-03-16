package com.example.task04;

import java.time.temporal.ChronoUnit;

public class RotationFileHandler extends FileHandler {
    private final ChronoUnit period;
    private long lastTimeMillisPrintMessage;

    RotationFileHandler(String filePath, ChronoUnit period) {
        super(filePath);
        this.period = period;
        lastTimeMillisPrintMessage = System.currentTimeMillis();
        this.filePath += lastTimeMillisPrintMessage;
    }

    @Override
    public void printMessage(String message) {
        if(System.currentTimeMillis() - lastTimeMillisPrintMessage >= period.getDuration().toMillis()){
            filePath = filePath.substring(0, filePath.length() - String.valueOf(lastTimeMillisPrintMessage).length());
            lastTimeMillisPrintMessage = System.currentTimeMillis();
            filePath += lastTimeMillisPrintMessage;
        }
        super.printMessage(message);
    }
}
