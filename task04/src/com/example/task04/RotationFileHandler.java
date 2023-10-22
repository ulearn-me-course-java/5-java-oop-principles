package com.example.task04;

import java.text.MessageFormat;
import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.io.*;

public class RotationFileHandler implements MessageHandler{

    private ChronoUnit chronoUnit;

    public RotationFileHandler(ChronoUnit chronoUnit) {
        this.chronoUnit = chronoUnit;
    }

    @Override
    public void log(String message) {
        LocalDateTime date = LocalDateTime.now().truncatedTo(chronoUnit);
        try(FileWriter writer = new FileWriter(MessageFormat.format("{0}.txt", date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss"))), true)) {
            writer.write(message);
            writer.append("\n");
            writer.flush();
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}

