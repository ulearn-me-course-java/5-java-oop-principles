package com.example.task04;

import java.io.FileWriter;
import java.io.IOException;
import java.text.MessageFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class RotationFileHandler implements MessageHandler {

    private final ChronoUnit chronoUnit;

    public RotationFileHandler(ChronoUnit chronoUnit) {
        this.chronoUnit = chronoUnit;
    }

    @Override
    public void log(String message) {
        LocalDateTime date = LocalDateTime.now().truncatedTo(chronoUnit);

        try {
            FileWriter writer = new FileWriter(MessageFormat.format("log-{0}.txt",
                    date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd_hh-mm-ss")), true));
            writer.append(message + "\n");
            writer.flush();
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
    }
}