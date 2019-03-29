package com.example.task04;

import java.time.temporal.ChronoUnit;
import java.io.FileWriter;
import java.io.IOException;

public class RotationFileHandler implements MessageHandler {
    private ChronoUnit period;
    private long lastTimePrintMessage;
    String filenameBase;
    FileWriter logWriter;

    RotationFileHandler(String filenameBase, ChronoUnit period) {
        this.period = period;
        this.filenameBase = filenameBase;
        this.lastTimePrintMessage = System.currentTimeMillis();
        try {
            logWriter = new FileWriter("[" + lastTimePrintMessage + "] " + filenameBase, false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void printMessage(String message) {
        try {
            if(System.currentTimeMillis() - lastTimePrintMessage >= period.getDuration().toMillis()){
                lastTimePrintMessage = System.currentTimeMillis();
                logWriter = new FileWriter("[" + lastTimePrintMessage + "] " + filenameBase, false);
            }
            logWriter.write(message + '\n');
            logWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}