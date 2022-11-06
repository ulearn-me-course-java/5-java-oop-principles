package com.example.task04;

import java.io.FileWriter;
import java.text.MessageFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class RotationFileHandler implements MessageHandler {

    private String fileName = "data";
    private ChronoUnit chronoUnit = ChronoUnit.HOURS;

    public RotationFileHandler(String fileName, ChronoUnit chronoUnit) {
        this.fileName = fileName;
        this.chronoUnit = chronoUnit;
    }

    public RotationFileHandler() {}

    @Override
    public void log(String message) {
        LocalDateTime dateTime = LocalDateTime.now().truncatedTo(this.chronoUnit);
        try {
            FileWriter fw = new FileWriter(MessageFormat.format("{0}[{1}].txt", fileName,
                    dateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd(HH:mm:ss)"))), true);
            fw.append(message);
            fw.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
