package com.example.task04;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class RotationFileHandler implements MessageHandler{
    private final ChronoUnit interval;
    public RotationFileHandler(ChronoUnit timeInterval){
        this.interval = timeInterval;
    }

    @Override
    public void write(String message){
        LocalDateTime time = LocalDateTime.now().truncatedTo(interval);
        try (FileWriter fileWriter = new FileWriter(time.format(DateTimeFormatter.ofPattern("yyyy-MM-dd(hh-mm-ss)"))+".txt",true)) {
            fileWriter.write(message+"\n");
        }catch (IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}