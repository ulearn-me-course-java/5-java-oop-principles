package com.example.task01;

import java.text.DateFormat;
import java.text.MessageFormat;
import java.time.LocalDateTime;
import java.util.Date;

public class Task01Main {
    public static void main(String[] args) {
        Logger logger1 = Logger.getLogger("test");
        Logger logger2 = Logger.getLogger("test");
        System.out.println(logger1 == logger2);

        logger1.log(ImportanceLevel.DEBUG, "testing logger");
        //logger1.setLevel(ImportanceLevel);
        Object[] arguments = {1, "asd"};
        logger1.log(ImportanceLevel.WARNING, "message pattern {0} {1}", arguments);
        logger1.error("test message");  //[ERROR] YYYY.MM.DD hh:mm:ss test - test message
    }
}
