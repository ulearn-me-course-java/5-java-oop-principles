package com.example.task01;
import java.text.MessageFormat;
public class Task01Main {
    public static void main(String[] args) {
        Logger log1 = new Logger("1");
        Logger log2 = new Logger("2", LoggerLevel.DEBUG);
        System.out.println(MessageFormat.format("Проверка getName:" +
                " первый экземпляр {0}, второй экземпляр {1}", log1.getName(), log2.getName()));
        System.out.println(MessageFormat.format("Проверка getLevel: " +
                "первый экземпляр {0}, второй экземпляр {1}", log1.getLevel(), log2.getLevel()));
        log1.setLevel(LoggerLevel.ERROR);
        System.out.println(MessageFormat.format("Проверка setLevel:" +
                " новый статус у первого экземпляра  {0}", log1.getLevel()));
        Logger log3 = Logger.getLogger("1");
        System.out.println(MessageFormat.format("Проверка getLogger: " +
                "первый экземпляр  == третий экземпляр ? {0}", log1 == log3));
        System.out.println("Проверка log через высокий LoggerLevel: ");
        log1.debug("Проверка debug 1");
        log1.debug("{0} {1}", log1.getName(), log1.getLevel());
        System.out.println("Проверка log через LoggerLevel: ");
        log2.debug("Проверка debug");
        log2.debug("{0} {1}", log2.getName(), log2.getLevel());
        log2.info("Проверка info");
        log2.info("{0} {1}", log2.getName(), log2.getLevel());
        log2.warning("Проверка warning");
        log2.warning("{0} {1}", log2.getName(), log2.getLevel());
        log2.error("Проверка error");
        log2.error("{0} {1}", log2.getName(), log2.getLevel());
    }
}
