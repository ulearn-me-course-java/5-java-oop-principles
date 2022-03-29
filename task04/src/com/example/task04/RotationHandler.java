package com.example.task04;

import java.io.FileWriter;
import java.text.MessageFormat;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class RotationHandler implements  MessageHandler {
    private final ChronoUnit period;

    public RotationHandler(ChronoUnit period) {
        this.period = period;
    }

    @Override
    public void addMessage(String message) {
        LocalDateTime now = LocalDateTime.now().truncatedTo(period);
        try {
            FileWriter fileWriter = new FileWriter(MessageFormat.format("[1]", now.toString()), true);
            fileWriter.append(message);
            fileWriter.flush();
        }
        catch (Exception ex) {
            return;
        }
    }
}
