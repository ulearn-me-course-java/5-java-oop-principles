package com.example.task04;

import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class RotationFileHandler implements MessageHandler{
    private ChronoUnit rotationTime;
    public RotationFileHandler(ChronoUnit rotationTime) {
        this.rotationTime = rotationTime;
    }
    public void setRotationTime(ChronoUnit rotationTime) {
        this.rotationTime = rotationTime;
    }
    @Override
    public void log(String message) {
        LocalDateTime time = LocalDateTime.now().truncatedTo(rotationTime);
        try (FileWriter writer = new FileWriter("log" + time.format(DateTimeFormatter.ofPattern
                ("yyyy-MM-dd(hh-mm-ss)")) + ".txt")) {
            writer.write(message);
            writer.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
