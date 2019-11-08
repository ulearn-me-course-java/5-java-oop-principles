package com.example.task04;

import lombok.NonNull;

/**
 * Обработчик, выводящий сообщения в консоль.
 */
public class ConsoleHandler implements MessageHandler {
    @Override
    public void printMessage(@NonNull String message) {
        System.out.println(message);
    }
}
