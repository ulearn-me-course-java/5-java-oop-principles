package com.example.task01;


import java.util.Calendar;

public class Task01Main {
    public static void main(String[] args) {

        Logger logger1 = Logger.getLogger("test");
        Logger logger2 = Logger.getLogger("test");
        System.out.println(logger1 == logger2);


        Logger l = new Logger("geshd");
        l.error("es");
        int a=2, b=3, c=4;

        l.error("math (({0}-{1})*{2})", a,b,c);
    }
}
