package com.example.task04;

import java.io.FileWriter;
import java.io.IOException;
import java.text.MessageFormat;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class RotationFileHandler implements MessageHandler {
    private final String path;
    private final ChronoUnit rotation;

    public RotationFileHandler(String path, ChronoUnit rotation) {
        this.path = path;
        this.rotation = rotation;
    }

    @Override
    public void log(String message) {
        LocalDateTime timeNow = LocalDateTime.now().truncatedTo(rotation);

        try(FileWriter writer = new FileWriter(MessageFormat.format("{0}/{1}.txt", path, timeNow.toString()), true)) {
            writer.append(message);
            writer.flush();
        } catch (IOException err) {
            err.printStackTrace();
        }

    }
}
