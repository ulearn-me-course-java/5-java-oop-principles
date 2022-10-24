package com.example.task04;

import java.io.FileWriter;
import java.text.MessageFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class RotationFileHandler implements MessageHandler{
    private String fileName;
    private ChronoUnit chronoUnit;
    public RotationFileHandler(String fileName, ChronoUnit chronoUnit){
        this.fileName = fileName;
        this.chronoUnit = chronoUnit;
    }

    public void setFileName(){
        this.fileName = fileName;
    }
    public String getFileName(){
        return fileName;
    }
    public void setChronoUnit()
    {
        this.chronoUnit = chronoUnit;
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
