package com.example.task04;

import java.io.FileWriter;
import java.util.*;
import java.time.temporal.ChronoUnit;

public class RotationFileHandler extends FileHandler implements MessageHandler {
    private final ChronoUnit period;
    private Date correctTime;

    public RotationFileHandler(String file, ChronoUnit period) {
        super(file);
        this.period = period;
        correctTime = new Date();
    }

    @Override
    public void printMessage(String string) {
        if (Math.abs(period.getDuration().getSeconds() - correctTime.getTime()) > 0) {
            super.printMessage(string);
        }
    }
}
