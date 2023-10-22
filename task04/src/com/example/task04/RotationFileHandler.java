package com.example.task04;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class RotationFileHandler implements MessageHandler{

    public ChronoUnit chronoUnit;
    public RotationFileHandler(ChronoUnit chronoUnit){
        this.chronoUnit = chronoUnit;
    }

    @Override
    public void handleMessage(String message){
        LocalDateTime currentDate = LocalDateTime.now().truncatedTo(chronoUnit);
        String formatOfDate = currentDate.format(DateTimeFormatter.ofPattern("yyyy.MM.dd hh.mm.ss.SSS a"));
        try(FileWriter fileWriter = new FileWriter(String.format("%s.txt", formatOfDate), true))
        {
            fileWriter.write(message + "\n");
            fileWriter.flush();
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }

    public void handleMessage(String format, Object ...objects){
        LocalDateTime currentDate = LocalDateTime.now().truncatedTo(chronoUnit);
        String formatOfDate = currentDate.format(DateTimeFormatter.ofPattern("yyyy.MM.dd hh.mm.ss.SSS a"));
        String message = String.format(format,objects);
        try(FileWriter fileWriter = new FileWriter(String.format("%s.txt", formatOfDate), true))
        {
            fileWriter.write(message + "\n");
            fileWriter.flush();
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}
