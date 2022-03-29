package com.example.task04;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class RotationFileHandler implements MessageHandler{
    private final String path;
    private final ChronoUnit rotation;

    public RotationFileHandler(String path, ChronoUnit rotation) {
        this.rotation = rotation;
        this.path = path;
    }

    @Override
    public void log(String message){
        LocalDateTime time = LocalDateTime.now();
        try(FileWriter writer = new FileWriter(this.path +  "/" + time.truncatedTo(rotation), true))
        {
            writer.write(message);
            writer.flush();
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}
