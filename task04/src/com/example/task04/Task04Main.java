package com.example.task04;

import java.io.IOException;
import java.time.temporal.ChronoUnit;

public class Task04Main {
    public static void main(String[] args) throws IOException {
        ConsoleHandler consoleLogger = new ConsoleHandler();
        consoleLogger.Handler("message1 - Console");

        FileHandler fileLogger = new FileHandler();
        fileLogger.Handler("message2 - Files");

        RotationFileHandler rotationFileLogger = new RotationFileHandler(ChronoUnit.HOURS);
        rotationFileLogger.Handler("message3 - FileWithTimeRotation");

        MemoryHandler memLogger = new MemoryHandler(2, consoleLogger, fileLogger);
        memLogger.Handler("message4 - memLogger");
        memLogger.Handler("message5 - memLogger");
        memLogger.Handler("message6 - memLogger");

    }
}