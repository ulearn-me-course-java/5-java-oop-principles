package com.example.task01;

import java.text.SimpleDateFormat;
import java.util.Date;

import static java.lang.System.out;

public class Task01Main {
    public static void main(String[] args) {
        Logger logger = Logger.getLogger("test");
        logger.log(Level.ERROR, "something");
        logger.setLevel(Level.WARNING);
        logger.debug("lol");
        logger.error("wtf");

    }
}
