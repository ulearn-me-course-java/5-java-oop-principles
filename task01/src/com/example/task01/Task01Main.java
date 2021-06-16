package com.example.task01;

public class Task01Main {
    public static void main(String[] args) {
        Logger logger = new Logger("TestError");
        logger.setLevel(Logger.Level.ERROR);
        logger.debug("MessageDebugTest");
        logger.info("MessageInfoTest");
        logger.warning("MessageWarningTest");
        logger.error("MessageErrorTest");
    }
}
