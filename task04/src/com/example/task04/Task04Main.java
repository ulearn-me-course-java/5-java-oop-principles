package com.example.task04;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class Task04Main {
    public static void main(String[] args) {
        Logger logger0 = new Logger("logger0", Level.INFO, new MemoryHandler(2, new ConsoleHandler()));
        logger0.info("message 1");
        logger0.info("message 2");
        logger0.error("message 3");
    }
}
