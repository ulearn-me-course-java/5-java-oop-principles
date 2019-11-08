package com.example.task04;

import java.io.*;

import lombok.NonNull;

/**
 * Обработчик, выводящий сообщения в файл путем дописывания сообщений к существующему файлу.
 * Ошибка записи в файл генерирует исключение IOException, при обработке которого
 * в консоль выводится сообщение о возникновении исключения.
 */
public class FileHandler implements MessageHandler {
    @Override
    public void printMessage(@NonNull String message) {
        try (FileWriter fw = new FileWriter("log.txt", true)) {
            fw.append(message + "\n");
            fw.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
