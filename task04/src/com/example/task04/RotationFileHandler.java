package com.example.task04;

import java.io.*;
import java.time.temporal.ChronoUnit;


/**
 * RotationFileHandler - обработчик, выводящий сообщения в файл с определенной ротацией.
 * Например, для каждого часа создается свой файл (с уникальным названием - logName).
 * duration - временной интервал, задающий ротацию;
 * printTime - время последней осуществленной печати в файл.
 */
public class RotationFileHandler implements MessageHandler {

    private ChronoUnit duration;
    private long printTime;
    private FileWriter outputFile;
    private String outputFileName;

    public RotationFileHandler(String path, ChronoUnit duration) throws IOException {
        this.duration = duration;
        printTime = System.currentTimeMillis();
        outputFileName = path + "log" + printTime + ".txt";
        outputFile = new FileWriter(outputFileName, true);
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            try {
                outputFile.flush();
                outputFile.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }));
    }

    @Override
    public void printMessage(String message) {
        if (System.currentTimeMillis() - printTime >= duration.getDuration().toMillis()) {
            printTime = System.currentTimeMillis();
            outputFileName = "log" + printTime + ".txt";
            try {
                outputFile.flush();
                outputFile.close();
                outputFile = new FileWriter(outputFileName, true);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            outputFile.append(message + '\n');
            outputFile.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
