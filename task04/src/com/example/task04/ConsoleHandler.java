package com.example.task04;

public class ConsoleHandler implements MessageHandler {
    @Override
    public void log(String msg) {
        System.out.println(msg);
    }
}
