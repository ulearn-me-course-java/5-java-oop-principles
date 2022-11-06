package com.example.task04;

@FunctionalInterface
public interface MessageHandler {
    void processMessage(String message);
}
