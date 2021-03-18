package com.example.task04;

public interface MessageHandler {

    void log(Level logLevel, String message);

    void log(Level logLevel, String template, Object ...args);

}
