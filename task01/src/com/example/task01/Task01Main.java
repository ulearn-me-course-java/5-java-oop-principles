package com.example.task01;

public class Task01Main {
    public static void main(String[] args) {
        Logger logger1 = Logger.getLogger("test");
        Logger logger2 = Logger.getLogger("test");
        System.out.println(logger1 == logger2);
        Logger log1 = new Logger("log1", LEVEL.ERROR);
        for (int i = 0; i < 2; i++){
            System.out.printf("Name logger: %s. Level: %s. \n", log1.getName(), log1.getLevel().name());
            log1.debug("Test Debug " + i);
            log1.info("Test Info " + i);
            log1.error("Test Error " + i);
            log1.setLevel(LEVEL.INFO);
        }
    }
}
