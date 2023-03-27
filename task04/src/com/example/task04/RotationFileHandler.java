package com.example.task04;

import java.io.FileWriter;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class RotationFileHandler implements MessageHandler {


    private String fileName;

    private ChronoUnit rotation;

    public RotationFileHandler(String fileName, ChronoUnit rotation) {
        this.fileName = fileName;
        this.rotation = rotation;
    }

    RotationFileHandler() {
        this("message.txt", ChronoUnit.HOURS);
    }

    RotationFileHandler(String fileName) {
        this(fileName, ChronoUnit.HOURS);
    }

    RotationFileHandler(ChronoUnit rotation) {
        this("message.txt", rotation);
    }


    @Override
    public void log(String message) {
        LocalDateTime now = LocalDateTime.now().truncatedTo(rotation);
        String file = String.format("%s_%s.txt", fileName, now.toString());
        try (FileWriter fileWriter = new FileWriter(file, true)) {
            fileWriter.append(message);
            fileWriter.append("\n");
            fileWriter.flush();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}