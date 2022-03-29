package com.example.task04;

import java.time.temporal.ChronoUnit;

public class Task04Main {
    public static void main(String[] args) {
        ConsoleHandler cLogger = new ConsoleHandler();
        cLogger.handle("message1(Console)");

        FileHandler fLogger = new FileHandler("messages.txt");
        fLogger.handle("message2(File)");

        RotationFileHandler rotationFileLogger = new RotationFileHandler(ChronoUnit.HOURS);
        rotationFileLogger.handle("message3(FileWithTimeRotation)");

        MemoryHandler mLogger = new MemoryHandler(2, cLogger, fLogger);
        mLogger.handle("message4(mLogger)");
        mLogger.handle("message5(mLogger)");
        mLogger.handle("message6(mLogger)");
        //mLogger.handle("message7(mLogger)");

        Logger logger = new Logger("logger", LEVEL.INFO);
        logger.setHandler(fLogger);
        logger.setHandler(cLogger);
        logger.info("message from logger");
    }
}
