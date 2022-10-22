package com.example.task04;

import java.time.temporal.ChronoUnit;

public class Task04Main {
    public static void main(String[] args) {
        ConsoleHandler cLogger = new ConsoleHandler();
        cLogger.logger("message1(Console)");

        FileHandler fLogger = new FileHandler("message2(File).txt");
        fLogger.logger("message2(File)");

        RotationFileHandler rotationFileLogger = new RotationFileHandler("message3(FileWithTimeRotation)", ChronoUnit.HOURS);
        rotationFileLogger.logger("message3(FileWithTimeRotation)");

        MemoryHandler mLogger = new MemoryHandler(2, cLogger, fLogger);
        mLogger.logger("message4(mLogger)");
        mLogger.logger("message5(mLogger)");
        mLogger.logger("message6(mLogger)");
    }
}
