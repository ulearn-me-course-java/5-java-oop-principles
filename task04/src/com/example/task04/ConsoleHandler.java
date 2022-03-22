package com.example.task04;

public class ConsoleHandler implements MessageHandler {

    @Override
    public void Handler(String message) {
        System.out.println(message);
    }
}