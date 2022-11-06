package com.example.task04;

public class ConsoleHandler implements MessageHandler {
    @Override
    public void processMessage(String message) {
        System.out.printf(message);
    }
}
