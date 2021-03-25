package com.example.task04;

public class ConsoleHeandler implements MessageHandler {
    public void log(String message) {
        System.out.println(message);
    }
}
