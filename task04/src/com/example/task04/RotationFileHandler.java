package com.example.task04;

import java.io.*;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.ArrayList;

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
    private FileWriter outputFile;
    private String outputFileName;
    private static final List<FileWriter> writers = new ArrayList<FileWriter>();

    /**
     * Примечание: название файла генерируется внутри конструктора,
     * в качестве пути следует передавать только путь ло директории.
     *
     * @param path     - путь до директории (без имени файла)
     * @param duration - временной интервал, по истечении которого создается новый файл лога.
     * @throws IOException
     */
    public RotationFileHandler(@NonNull String path, @NonNull ChronoUnit duration) throws IOException {
        this.duration = duration;
        this.printTime = System.currentTimeMillis();
        this.outputFileName = path + "log" + printTime + ".txt";
        this.outputFile = new FileWriter(outputFileName, true);
        writers.add(outputFile);
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            writers.forEach(file -> {
                try {
                    file.flush();
                    file.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

        }));
    }

    @Override
    public void printMessage(@NonNull String message) {
        if (System.currentTimeMillis() - printTime >= duration.getDuration().toMillis()) {
            printTime = System.currentTimeMillis();
            this.outputFileName = "log" + printTime + ".txt";
            try {
                this.outputFile = new FileWriter(outputFileName, true);
                writers.add(outputFile);
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

