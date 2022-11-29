package com.example.task04;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class RotationFileHandler implements MessageHandler {
    private final String path;
    private final ChronoUnit rotation;

    public RotationFileHandler(String path, ChronoUnit rotation) {
        if (path == null || rotation == null)
            throw new IllegalArgumentException("Параметры не должны иметь значение null");
        this.path = path;
        this.rotation = rotation;
    }
    @Override
    public void log(String message) {
        LocalDateTime now = LocalDateTime.now().truncatedTo(rotation);
        String filePath = String.format("%s - %s", path, now);
        try(FileWriter writer = new FileWriter(filePath, true)) {
            writer.append(message);
            writer.append('\n');
            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
