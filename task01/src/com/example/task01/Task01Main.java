package com.example.task01;

public class Task01Main {
    public static void main(String[] args) {
        Logger logger = new Logger("test");
        Logger logger1 = Logger.getLogger("test");
        Logger logger2 = Logger.getLogger("test");
        System.out.println(logger1 == logger2);
        logger.setLevel(SeverityLevels.WARNING);
        //ур важности нижеустановленного - выводится
        logger.log(SeverityLevels.ERROR, "sld %d", 2);
        //ур важности выше установленного - не выводится
        logger.log(SeverityLevels.INFO, "qwqew");

    }
}
