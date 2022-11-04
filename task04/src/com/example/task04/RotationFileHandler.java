package com.example.task04;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class RotationFileHandler implements MessageHandler {
    private String path;
    private ChronoUnit rotation;

    public RotationFileHandler(String path, ChronoUnit rotation) {
        this.rotation = rotation;
        this.path = path;
    }

    @Override
    public void logger(String message) {
        LocalDateTime dateNow = LocalDateTime.now().truncatedTo(rotation);
        File file = new File(path + dateNow + ".txt");
        try (FileOutputStream fileOutputStream = new FileOutputStream(file)) {
            fileOutputStream.write(message.getBytes());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }
}
