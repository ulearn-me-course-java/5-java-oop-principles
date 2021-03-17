package com.example.task01;

import java.util.Date;

public class Task01Main {



    public static void main(String[] args) {
        Logger logger1 = new Logger("1");
        Logger logger2 = Logger.getLogger("1");
        logger1.setLevel(levels.INFO);
        logger1.log(levels.INFO, "Test");
    }
}
