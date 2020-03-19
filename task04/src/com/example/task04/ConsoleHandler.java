package com.example.task04;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ConsoleHandler implements MessageHandler{

    @Override
    public void log(String message) {
        System.out.println(message);
    }
}
