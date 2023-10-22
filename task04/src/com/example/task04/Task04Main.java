package com.example.task04;

import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class Task04Main {
    public static void main(String[] args) {
        Logger logger = Logger.getLogger("MyLogger", new FileHandler());
        logger.error("ПОшибка");
        logger.info("Кируто");


    }
}
