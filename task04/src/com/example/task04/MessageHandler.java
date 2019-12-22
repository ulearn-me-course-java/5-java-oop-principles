package com.example.task04;

import java.io.IOException;

/**
 * Интерфейс для обработчиков
 */
public interface MessageHandler {

    /**
     * Заставляет обработчик обработать сообщение.
     *
     * @param message Строка с сообщением. Перенос строки в конце не нужен.
     */
    void printMessage(String message) throws IOException;
}