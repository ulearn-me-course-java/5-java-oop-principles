package com.example.task04;

public class ConsoleHandler implements MessageHandler {
    @Override
    public void print(String message) {
        System.out.println(message);
    }
}
