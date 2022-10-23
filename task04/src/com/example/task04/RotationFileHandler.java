package com.example.task04;

import java.io.FileWriter;
import java.text.MessageFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class RotationFileHandler implements MessageHandler {
    private String fileName = "log";
    private ChronoUnit chronoUnit = ChronoUnit.HOURS;


    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public RotationFileHandler() {
    }

    public RotationFileHandler(String fileName, ChronoUnit chronoUnit) {
        this.fileName = fileName;
        this.chronoUnit = chronoUnit;
    }

    public RotationFileHandler(ChronoUnit chronoUnit) {
        this.chronoUnit = chronoUnit;
    }

    public RotationFileHandler(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void log(String message) {
        LocalDateTime timeNow = LocalDateTime.now().truncatedTo(this.chronoUnit);
        try (FileWriter writer = new FileWriter(MessageFormat.format("{0}_{1}.txt", fileName, timeNow.format(DateTimeFormatter.ofPattern("yyyy-MM-dd_hh-mm-ss"))), true)) {
            writer.append(String.format("%s\n", message));
            writer.flush();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}