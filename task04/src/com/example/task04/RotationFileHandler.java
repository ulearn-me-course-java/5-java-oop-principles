package com.example.task04;

import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class RotationFileHandler implements MessageHandler {

    private String path;
    private ChronoUnit rotation;

    public RotationFileHandler(String path, ChronoUnit rotation) {
        this.path = path;
        this.rotation = rotation;
    }
    @Override
    public void log(String message) {
        LocalDateTime now = LocalDateTime.now().truncatedTo(rotation);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("path"+ now.toString() + ".txt");
            fileOutputStream.write(message.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
