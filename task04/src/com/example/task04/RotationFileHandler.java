package com.example.task04;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class RotationFileHandler implements MessageHandler{
    private final ChronoUnit timeInterval;
    public RotationFileHandler(ChronoUnit timeInterval){
        this.timeInterval = timeInterval;
    }

    @Override
    public void writeMessage(String message){
        LocalDateTime time = LocalDateTime.now().truncatedTo(timeInterval);
        try (FileWriter fileWriter = new FileWriter(time.format(DateTimeFormatter.ofPattern("yyyy-MM-dd(hh-mm-ss)"))+".txt",true)) {
            fileWriter.write(message+"\n");
        }catch (IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}
