package com.example.task01;

public class Task01Main {
    public static void main(String[] args) {
        Logger log1 = Logger.getLogger("log1");
        Logger log2 = Logger.getLogger("log2");
        Logger log3 = Logger.getLogger("log2");
        //сравниваем ссылки
        if (log2 == log3) {
            System.out.println("log 2 = log 3");
        }
        log1.setLevel(Level.ERROR);
        log2.setLevel(Level.INFO);
        log1.error("error number: %d, error name: %s", 1, "E1");
        log2.debug("debug message");
        log3.info("info message");
    }
}
