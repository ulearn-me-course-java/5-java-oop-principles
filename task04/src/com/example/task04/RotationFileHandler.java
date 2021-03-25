package com.example.task04;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class RotationFileHandler implements MessageHandler {

    String filePath;
    ChronoUnit rotation;

    public RotationFileHandler(String filepath, ChronoUnit rotation) throws IOException {
        this.filePath = filepath;
        this.rotation = rotation;
    }

    @Override
    public void log(String message) {
        LocalDateTime now = LocalDateTime.now().truncatedTo(rotation);
        String fileName = String.format("%s_%s.txt",filePath,now.toString());
        try {
            FileWriter fileWriter = new FileWriter(fileName, true);
            fileWriter.append(message);
            fileWriter.flush();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}