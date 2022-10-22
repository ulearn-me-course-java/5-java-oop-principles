package com.example.task04;

import java.time.temporal.ChronoUnit;

public class Task04Main {
    public static void main(String[] args) {

        ConsoleHandler consoleLogger = new ConsoleHandler();
        consoleLogger.logger("message1(Console)");

        FileHandler fileLogger = new FileHandler("message2(File).txt");
        fileLogger.logger("message2(File)");

        RotationFileHandler rotationFileLogger = new RotationFileHandler("message3(FileWithTimeRotation)", ChronoUnit.MINUTES);
        rotationFileLogger.logger("message3(FileWithTimeRotation)");

        MemoryHandler memoryLogger = new MemoryHandler(2, consoleLogger, fileLogger);
        memoryLogger.logger("message4(memoryLogger)");
        memoryLogger.logger("message5(memoryLogger)");
        memoryLogger.logger("message6(memoryLogger)");

    }
}
