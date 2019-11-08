package com.example.task04;

import java.io.*;
import java.time.temporal.ChronoUnit;

import lombok.NonNull;

/**
 * RotationFileHandler - обработчик, выводящий сообщения в файл с определенной ротацией.
 * Например, для каждого часа создается свой файл (с уникальным названием - logName).
 * duration - временной интервал, задающий ротацию;
 * printTime - время последней осуществленной печати в файл.
 */
public class RotationFileHandler implements MessageHandler {
    private ChronoUnit duration;
    private long printTime;
    private String logName;

    public RotationFileHandler(@NonNull ChronoUnit duration) {
        this.duration = duration;
        this.printTime = System.currentTimeMillis();
        this.logName = "log" + printTime + ".txt";
    }

    @Override
    public void printMessage(@NonNull String message) {
        if (System.currentTimeMillis() - printTime >= duration.getDuration().toMillis()) {
            printTime = System.currentTimeMillis();
            this.logName = "log" + printTime + ".txt";
        }
        try (FileWriter fw = new FileWriter(this.logName, true)) {
            fw.append(message + '\n');
            fw.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
