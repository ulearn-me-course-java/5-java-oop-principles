package com.example.task04;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class RotationFileHandler implements MessageHandler{
    private final ChronoUnit dateRot;

    public RotationFileHandler(ChronoUnit dateRot){
        this.dateRot = dateRot;
    }

    @Override
    public void log(String message){
        LocalDateTime time =LocalDateTime.now().truncatedTo(dateRot);

        try (FileWriter fileWriter = new FileWriter(
                time.format(DateTimeFormatter.ofPattern("yyyy-MM-dd(hh-mm-ss)")) + ".txt",
                true)){
            fileWriter.write(message);
            fileWriter.append("\n");
            fileWriter.flush();

        }catch (IOException exception){
            System.out.println(exception.getMessage());
        }
    }
}
