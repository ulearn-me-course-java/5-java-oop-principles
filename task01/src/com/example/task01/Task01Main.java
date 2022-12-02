package com.example.task01;

public class Task01Main {
    public static void main(String[] args) {
        String word = "wdwd";
        String word1 = "wfofl";
        Logger logger1 = new Logger("error of life");
        Logger logger2 = new Logger("error of life");
        Logger logger3 = new Logger("Cringe");
        Logger logger4 = new Logger("No, please");
        logger4.warning("This is fake %s, %s", word, word1);
        logger4.setLevel(Level.ERROR);
        logger4.warning("This is fake %s, %s", word, word1);

        Logger logger10 = Logger.getLogger("test");
        Logger logger20 = Logger.getLogger("test");
        System.out.println(logger10 == logger20);

    }
}
