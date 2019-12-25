package com.example.task04;

/**
 * Обработчик для вывода сообщений в консоль
 */
public class ConsoleHandler implements MessageHandler {

    @Override
    public void printMessage(String message) {
        System.out.print(message);
    }

}