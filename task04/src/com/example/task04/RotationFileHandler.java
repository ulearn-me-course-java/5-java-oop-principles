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
        try (FileWriter fileWriter = new FileWriter((LocalDateTime.now().truncatedTo(timeInterval)).toString(),true)) {
            fileWriter.write(message);
        }catch (IOException ex){

        }
    }
}
