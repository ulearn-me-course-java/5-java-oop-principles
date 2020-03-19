package com.example.task04;

public class ConsoleHandler implements MessageHandler {
    @Override
    public void toWrite(String message) {
        System.out.println(message);
    }
}
