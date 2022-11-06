package com.example.task01;

import java.time.format.DateTimeFormatterBuilder;
import java.util.Calendar;
import java.util.Date;

public class Task01Main {
    public static void main(String[] args) {
        Logger logger1 = Logger.getLogger("test");
        Logger logger2 = Logger.getLogger("test");
        System.out.println(logger1 == logger2);
        Logger logger3 = new Logger("geshd");
        Logger logger4 = Logger.getLogger("geshd");
        logger4.error("cannot be divided by zero");

        logger4.error("{0} {1} {2}", "it`s ok", 18, 5 );
    }
}
