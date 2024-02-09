package com.example.task04;

import java.text.MessageFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ConsoleHandler implements MessageHandler{
    @Override
    public void log(String message) {
        System.out.println(message);
    }
}