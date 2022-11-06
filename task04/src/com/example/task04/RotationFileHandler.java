package com.example.task04;
import java.io.FileWriter;
import java.text.MessageFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class RotationFileHandler implements MessageHandler{
    private String fileName;
    private ChronoUnit interval;

    public RotationFileHandler(String fileName, ChronoUnit interval){
        this.fileName = fileName;
        this.interval = interval;
    }
    public RotationFileHandler(String fileName){
        this.fileName = fileName;
    }
    public RotationFileHandler(ChronoUnit interval){
        this.interval = interval;
    }
    public RotationFileHandler(){

    }

    public String getFileName(){
        return fileName;
    }
    public ChronoUnit getInterval(){
        return interval;
    }

    public void setFileName(String fileName){
        this.fileName = fileName;
    }
    public void setInterval(ChronoUnit interval){
        this.interval = interval;
    }

    @Override
    public void log(String message) {
        LocalTime timeNow = LocalTime.now().truncatedTo(interval);
        try (FileWriter writer = new FileWriter(MessageFormat.format("{0}_{1}.txt", fileName, timeNow.format(DateTimeFormatter.ofPattern("yyyy-MM-dd_hh-mm-ss"))), true)) {
            writer.append(String.format("%s\n", message));
            writer.flush();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
