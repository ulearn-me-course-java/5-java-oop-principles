package com.example.task04;

import java.io.FileWriter;
import java.io.IOException;
import java.text.MessageFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class RotationFileHandler implements MessageHandler{
    private ChronoUnit chronoUnit;

    public RotationFileHandler(ChronoUnit chronoUnit){
        this.chronoUnit = chronoUnit;
    }
    @Override
    public void log(String message) {
        LocalDateTime dateTime = LocalDateTime.now().truncatedTo(chronoUnit);
        try {
            FileWriter fileWriter = new FileWriter(MessageFormat.format("log_{0}.txt",
                    dateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd(hh-mm-ss)"))));
            fileWriter.append(message + "\n");
            fileWriter.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}