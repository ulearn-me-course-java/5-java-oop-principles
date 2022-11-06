package com.example.task01;

public class Task01Main {
    public static void main(String[] args) {


        Logger logger1 = new Logger("who...");
        Logger logger2 = new Logger("why");
        logger2.setLevel(MessageLevel.ERROR);
        System.out.println(logger2.getLevel());
        logger2.logMessageOutput(MessageLevel.ERROR, "oh no, my brain... It's broken..");


    }
}
