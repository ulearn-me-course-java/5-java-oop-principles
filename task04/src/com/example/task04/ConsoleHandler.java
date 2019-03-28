package com.example.task04;

public class ConsoleHandler implements MessageHandler {
    @Override
    public void printMessage(String string) {
        System.out.println(string);
    }
}
