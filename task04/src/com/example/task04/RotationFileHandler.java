package com.example.task04;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class RotationFileHandler implements MessageHandler{
    private ChronoUnit interval;

    public RotationFileHandler(ChronoUnit interval) {
        this.interval = interval;
    }

    @Override
    public void log(String message) {
        LocalDateTime time = LocalDateTime.now().truncatedTo(interval);
        String file = String.format("log %c.txt", time.toString().replace(':', '_'));
        String path = String.format("task04\\src\\%c", file);
        try (FileWriter fw = new FileWriter(path, true)){
            fw.write(message + "\n\n");
            fw.flush();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("rotation file handler error");
        }
    }
}
