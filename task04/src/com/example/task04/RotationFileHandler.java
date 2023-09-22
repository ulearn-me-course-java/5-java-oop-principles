package com.example.task04;

import java.io.FileWriter;
import java.io.IOException;
import java.text.MessageFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class RotationFileHandler implements MessageHandler {
    private final String path;
    private final ChronoUnit rotation;

    public RotationFileHandler(String path, ChronoUnit rotation) {
        if (path == null) {
            throw new IllegalArgumentException("The path cannot be null");
        }

        this.path = path;
        this.rotation = rotation;
    }

    @Override
    public void log(String message) {
        LocalDateTime currentDate = LocalDateTime.now().truncatedTo(rotation);
        String formatDate = currentDate.format(DateTimeFormatter.ofPattern("yyyy.MM.dd hh.mm.ss"));
        try (FileWriter writer = new FileWriter(String.format("%s%s.txt", path, formatDate), true)) {
            writer.append(message);
            writer.append('\n');
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
