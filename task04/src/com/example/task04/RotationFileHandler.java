package com.example.task04;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class RotationFileHandler implements MessageHandler {

    private String filePath;
    private ChronoUnit rotation;

    public RotationFileHandler(String filepath, ChronoUnit rotation){
        this.filePath = filepath;
        this.rotation = rotation;
    }

    @Override
    public void log(String message) {
        LocalDateTime now = LocalDateTime.now().truncatedTo(rotation);
        String fileName = String.format("%s_%s.txt",filePath,now.toString());
        try {
            FileWriter fileWriter = new FileWriter(fileName, true);
            fileWriter.write(message + "\n\n");
            fileWriter.flush();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}