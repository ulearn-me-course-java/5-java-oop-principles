package com.example.task04;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ConsoleHandler implements MessageHandler {
    @Override
    public void processMessage(String currentName, LogSeverityLvl lvl, String message) {
        System.out.printf("[%s] %s %s - %s%n",
                lvl,
                new SimpleDateFormat("yyyy.MM.dd hh:mm:ss").format(new Date()),
                currentName,
                message
        );
    }

    @Override
    public void processMessage(String format, Object... params) {
        System.out.printf((format) + "%n", params);
    }
}
