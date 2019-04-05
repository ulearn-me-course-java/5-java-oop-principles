package com.example.task04;

import java.io.FileWriter;
import java.util.*;
import java.time.temporal.ChronoUnit;

public class RotationFileHandler extends FileHandler implements MessageHandler {

    private Date correctTime= new Date();
    private final ChronoUnit period;

    public RotationFileHandler(String path, ChronoUnit period) {
        super(path);
        this.period = period;
    }

    @Override
    public void print(String string) {
        if (Math.abs(period.getDuration().getSeconds() - correctTime.getTime()) > 0) {
            super.print(string);
        }
    }
}