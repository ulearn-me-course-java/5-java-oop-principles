package com.example.task04;

public class ConsoleHandler implements MessageHandler {
    @Override
    public void log(String logMessage) {
        System.out.println(logMessage);
    }
}