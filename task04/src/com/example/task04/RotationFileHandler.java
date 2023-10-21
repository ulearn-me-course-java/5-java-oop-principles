package com.example.task04;

import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class RotationFileHandler implements Handler{
    private DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
    private ChronoUnit chronoUnit;

    public RotationFileHandler(ChronoUnit chronoUnit){
        this.chronoUnit = chronoUnit;
    }

    public void setRotation(ChronoUnit chronoUnit) { this.chronoUnit = chronoUnit; }

    public void setDateFormat(DateFormat dateFormat) { this.dateFormat = dateFormat; }

    @Override
    public void log(String message) {
        try (FileWriter writer = new FileWriter(dateFormat.format(new Date()) + ".txt", true)) {
            writer.write(message + '\n');
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
