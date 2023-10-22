package com.example.task01;
import java.text.MessageFormat;

public class Task01Main {
    public static void main(String[] args) {
        Logger log1 = new Logger("1");
        Logger log2 = new Logger("2", Level.DEBUG);
        System.out.println(MessageFormat.format("Test getName:" +
                " first case {0}, second case {1}", log1.getName(), log2.getName()));
        System.out.println(MessageFormat.format("Test getLevel: " +
                "first case {0}, second case {1}", log1.getLevel(), log2.getLevel()));
        log1.setLevel(Level.ERROR);
        System.out.println(MessageFormat.format("Test setLevel:" +
                " new first case status  {0}", log1.getLevel()));
        Logger log3 = Logger.getLogger("1");
        System.out.println(MessageFormat.format("Test getLogger: " +
                "first case  == third case ? {0}", log1 == log3));
        System.out.println("Test log through high LoggerLevel: ");
        log1.debug("Test debug 1");
        log1.debug("{0} {1}", log1.getName(), log1.getLevel());
        System.out.println("Test log through LoggerLevel: ");
        log2.debug("Test debug");
        log2.debug("{0} {1}", log2.getName(), log2.getLevel());
        log2.info("Test info");
        log2.info("{0} {1}", log2.getName(), log2.getLevel());
        log2.warning("Test warning");
        log2.warning("{0} {1}", log2.getName(), log2.getLevel());
        log2.error("Test error");
        log2.error("{0} {1}", log2.getName(), log2.getLevel());
    }
}
