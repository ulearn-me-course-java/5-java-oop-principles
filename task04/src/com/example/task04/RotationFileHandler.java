package com.example.task04;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class RotationFileHandler implements MessageHandler {
    private final ChronoUnit timeInterval;

    public RotationFileHandler(ChronoUnit timeInterval) {
        this.timeInterval = timeInterval;
    }

    @Override
    public void log(String message){
        LocalDateTime time = LocalDateTime.now().truncatedTo(timeInterval);
        try (FileWriter fileWriter = new FileWriter(time.format(DateTimeFormatter.ofPattern("yyyy-MM-dd(hh-mm-ss)")) + ".txt", true)) {
            fileWriter.write(message + "\n");
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
    }
}