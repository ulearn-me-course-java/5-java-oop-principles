package com.example.task04;

public class ConsoleHandler implements MessageHandler {

    @Override
    public void Handler(String msg) {
        System.out.println(msg);
    }
}
