package com.example.task04;

import java.io.*;
import java.text.MessageFormat;
import java.time.*;
import java.time.temporal.ChronoUnit;

public class RotationHandler implements MessageHandler {
    private final String path;
    private final ChronoUnit rotation;

    public RotationHandler(ChronoUnit rotation, String path){
        this.rotation = rotation;
        this.path = path;
    }

    @Override
    public void log(String message) {
        LocalDateTime now = LocalDateTime.now().truncatedTo(rotation);

        try(FileWriter writer = new FileWriter(MessageFormat.format("{0}/{1}.txt", path, now.toString()), true)) {
            writer.append(message);
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}