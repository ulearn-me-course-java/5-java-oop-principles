package com.example.task04;

import java.io.*;
import java.time.*;
import java.time.format.*;
import java.time.temporal.*;

/**
 * Обработчик для вывода сообщений в файл с определенным интервалом
 */
public class RotationFileHandler implements MessageHandler {

    private final String path;
    private final ChronoUnit interval;
    private FileWriter writer;
    private LocalDateTime lastTimeFileCreation;
    private static final DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy_MM_dd_hh_mm");
    /**
     * Конструктор RotationFileHandler
     * Файлы создаются с именем path_datePattern.txt
     *
     * @param path        путь до файла и/или начало его имени
     * @param interval    временной интервал в формате {@link java.time.temporal.ChronoUnit}
     */
    public RotationFileHandler(String path, ChronoUnit interval) {
        if (path == null) {
            throw new IllegalArgumentException("Ожидается String path, получен null");
        }
        if (interval == null) {
            throw new IllegalArgumentException("Ожидается ChronoUnit interval, получен null");
        }

        this.path = path;
        this.interval = interval;
        this.lastTimeFileCreation = LocalDateTime.now().truncatedTo(interval);
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            try {
                writer.flush();
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }));
    }

    @Override
    public void printMessage(String message) throws IOException {
        LocalDateTime currentTime = LocalDateTime.now();
        currentTime = currentTime.truncatedTo(interval);

        if (writer == null || currentTime.isAfter(lastTimeFileCreation)) {
            String fileName = String.format("%s_%s.txt", path, currentTime.format(dateFormat));
            if (writer != null) {
                writer.flush();
                writer.close();
            }
            writer = new FileWriter(fileName);
            lastTimeFileCreation = currentTime;
        }
        writer.write(message);
        writer.flush();
    }
}