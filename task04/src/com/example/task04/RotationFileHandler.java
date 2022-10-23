package com.example.task04;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class RotationFileHandler implements MessageHandler{

    private ChronoUnit interval;
    public RotationFileHandler(ChronoUnit unit){
        interval = unit;
    }

    @Override
    public void log(String message) {
        LocalDateTime currentTime = LocalDateTime.now().truncatedTo(interval);
        String fileName = String.format("log_%s.txt", currentTime.toString().replace(':', '_'));

        String path = String.format("task04\\src\\rotations\\%s", fileName);

        try(FileWriter writer = new FileWriter(path, true)) {
            writer.write(message + "\n\n");
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("rotation file handler error");
        }
    }
}
