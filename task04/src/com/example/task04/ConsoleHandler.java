package com.example.task04;

import java.text.MessageFormat;
import java.util.Date;

public class ConsoleHandler implements Handler {
    @Override
    public void log(String message) {
        System.out.println(message);
    }
}
