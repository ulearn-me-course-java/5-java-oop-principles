package com.example.task04;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class RotationFileHandler implements MessageHandler {
    private ChronoUnit rotation;
    public RotationFileHandler(ChronoUnit rotation) {
        this.rotation = rotation;
    }
    @Override
    public void log(String message) {
        LocalDateTime currentTime = LocalDateTime.now().truncatedTo(rotation);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd HH.mm.ss");
        String fileName = formatter.format(currentTime) + ".txt";

        try(FileWriter writer = new FileWriter(fileName, true)) {
            writer.write(message);
            writer.write("\n");
            writer.flush();
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}
