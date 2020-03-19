package com.example.task04;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class RotationFileHandler implements MessageHandler {
    private final String path;
    private final ChronoUnit rotation;

    public RotationFileHandler(String path, ChronoUnit rotation){
        if(path == null) throw new IllegalArgumentException("Path is null");
        this.path=path;
        this.rotation=rotation;
    }

        @Override
        public void log(String message) {
            LocalDateTime now = LocalDateTime.now().truncatedTo(rotation);
            String filePath=String.format("%s\\%s.txt", path, now.toString());
            try(FileWriter writer = new FileWriter(filePath, true)) {
                writer.append(message);
                writer.append('\n');
                writer.flush();
            } catch (IOException e) {
                System.out.println (e.toString());
                System.out.println("Could not find file " + filePath);
            }
        }
    }
