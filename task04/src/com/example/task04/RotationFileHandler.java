package com.example.task04;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class RotationFileHandler implements MessageHandler {
    private final String fileName;
    private ChronoUnit chronoUnit = ChronoUnit.HOURS;

    public RotationFileHandler(String fileName, ChronoUnit chronoUnit){
        this.fileName = fileName;
        this.chronoUnit = chronoUnit;
    }

    public void log(String message){
    LocalDateTime timeNow = LocalDateTime.now().truncatedTo(chronoUnit);
        try {
            FileWriter writer = new FileWriter(String.format("{0}_{1}.txt", fileName, timeNow.format(DateTimeFormatter.ofPattern("yyyy-MM-dd_hh-mm-ss"))), true);
            writer.write("\n" + message);
            writer.close();

        } catch (IOException e) {
            System.out.println("Возникла ошибка во время записи, проверьте данные.");
        }
    }



}
