package com.example.task04;

public class ConsoleHandler implements Handler {
    @Override
    public void log(String message) {
        System.out.println(message);
    }
}