package com.example.task04;

import java.io.FileWriter;
import java.io.IOException;
import java.text.MessageFormat;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class RotationFileHandler implements MessageHandler{
    private ChronoUnit interval;

    public RotationFileHandler(ChronoUnit interval) {
        this.interval = interval;
    }

    @Override
    public void handle(String message) {
        writeToFile("logs.txt", message);
    }
    public void setRotationInterval(ChronoUnit interval){
        this.interval = interval;
    }
    private void writeToFile(String path, String message){
        LocalDateTime now = LocalDateTime.now().truncatedTo(interval);
        try(FileWriter writer = new FileWriter(now.toString(), true))
        {
            writer.append(message);
            writer.append("\n");

            writer.flush();
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}
