package com.example.task04;

import java.io.FileWriter;
import java.text.MessageFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class RotationFileHandler implements MessageHandler {
    private String fileName;
    private ChronoUnit chronoUnit;

    public RotationFileHandler(String fileName, ChronoUnit chronoUnit) {
        this.fileName = fileName;
        this.chronoUnit = chronoUnit;
    }

    public RotationFileHandler(String fileName) {
        this(fileName, ChronoUnit.HOURS);
    }

    public RotationFileHandler(ChronoUnit chronoUnit) {
        this("log", chronoUnit);
    }

    public RotationFileHandler() {
        this("log", ChronoUnit.HOURS);
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void log(String message) {
        LocalDateTime dateTimeNow = LocalDateTime.now().truncatedTo(this.chronoUnit);
        try (FileWriter fileWriter = new FileWriter(MessageFormat.format("{0}-{1}.txt", fileName, dateTimeNow.format(DateTimeFormatter.ofPattern("yyyy-MM-dd_HH:mm:ss"))), true)) {
            fileWriter.append(String.format("%s\n", message));
            fileWriter.flush();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
