package com.example.task04;

import java.io.*;

import lombok.NonNull;

/**
 * Обработчик, выводящий сообщения в файл путем дописывания сообщений к существующему файлу.
 */
public class FileHandler implements MessageHandler {

    private FileWriter outputFile;

    public FileHandler(@NonNull String path) throws IOException {
        this.outputFile = new FileWriter(path, true);
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
    public void printMessage(@NonNull String message) {
        try {
            outputFile.append(message + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

