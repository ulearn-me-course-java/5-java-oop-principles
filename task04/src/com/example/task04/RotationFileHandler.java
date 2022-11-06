package com.example.task04;

import java.io.FileWriter;
import java.io.IOException;
import java.text.MessageFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class RotationFileHandler implements MessageHandler{
    private String fileName;
    private ChronoUnit chronoUnit;

    public RotationFileHandler(String fileName, ChronoUnit chronoUnit){
        this.fileName = fileName;
        this.chronoUnit = chronoUnit;
    }

    public String getFileName() {
        return fileName;
    }

    public ChronoUnit getChronoUnit(){
        return chronoUnit;
    }

    @Override
    public void log(String message) {
        LocalDateTime dateTimeNow = LocalDateTime.now().truncatedTo(chronoUnit);
        try (FileWriter fileWriter = new FileWriter(MessageFormat.format("{0}_{1}.txt", fileName,dateTimeNow.format(DateTimeFormatter.ofPattern("yyyy.MM.dd hh:mm:ss"))), false)) {
            fileWriter.write(String.format("%s", message));
            fileWriter.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
