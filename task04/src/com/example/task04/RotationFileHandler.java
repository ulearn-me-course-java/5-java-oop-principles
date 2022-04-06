package com.example.task04;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class RotationFileHandler extends FileHandler {
     private ChronoUnit period;

     public RotationFileHandler(ChronoUnit period) {
        setPeriod(period);
     }

    public ChronoUnit getPeriod() {
        return period;
    }

    public void setPeriod(ChronoUnit period) {
        this.period = period;
    }

    @Override
    public void handle(String message) {
        writeToFile("log" +
                DateTimeFormatter.ofPattern("yyyy.MM.dd HH.mm.ss").format(LocalDateTime.now().truncatedTo(period)) +
                ".txt", message);
    }


}
