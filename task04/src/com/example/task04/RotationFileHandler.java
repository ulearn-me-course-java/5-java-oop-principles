package com.example.task04;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class RotationFileHandler implements MessageHandler{
    private final ChronoUnit rotation;

    public RotationFileHandler(ChronoUnit rotation) {
        this.rotation = rotation;
    }

    @Override
    public void log(String message) {
        LocalDateTime time = LocalDateTime.now().truncatedTo(rotation);
        String path = String.format("task04\\src\\message %d.txt",
                time.toString().replace(':', '-'));
        try (FileWriter fileWriter = new FileWriter(path, true)) {
            fileWriter.write(message + "\n\n");
            fileWriter.flush();
        }
        catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
