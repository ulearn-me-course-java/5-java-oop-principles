package com.example.task04.handler;

public class ConsoleHandler implements MessageHandler {

    @Override
    public void handleMessage(String message) {
        System.out.println(message);
    }
}
