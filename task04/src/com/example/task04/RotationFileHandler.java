package com.example.task04;

import java.io.FileWriter;
import java.text.MessageFormat;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class RotationFileHandler implements MessageHandler{
    private String fileName;
    private ChronoUnit chronoUnit;

    public RotationFileHandler(String fileName, ChronoUnit chronoUnit) {
        this.chronoUnit = chronoUnit;
        this.fileName = fileName;
    }

    @Override
    public void log(String message) {
        LocalDateTime localTime = LocalDateTime.now().truncatedTo(chronoUnit);
        try (FileWriter fileWriter = new FileWriter(MessageFormat.format("{0}_{1}.txt",fileName,localTime.toString()),true)) {
            fileWriter.append(message);
            fileWriter.flush();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
