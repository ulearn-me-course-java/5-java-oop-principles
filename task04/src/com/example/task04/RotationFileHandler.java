package com.example.task04;

import java.io.FileWriter;
import java.io.IOException;
import java.text.MessageFormat;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class RotationFileHandler implements MessageHandler{

    private final ChronoUnit period;

    public RotationFileHandler(ChronoUnit period) {
        this.period = period;
    }

    @Override
    public void Handler(String message) {
        LocalDateTime now = LocalDateTime.now().truncatedTo(period);
        try {
            FileWriter fileWriter = new FileWriter(MessageFormat.format("[1]", now.toString()), true);
            fileWriter.append(message);
            fileWriter.flush();
        } catch (IOException e) {
        }
    }
}
