package com.example.task04;

import java.time.temporal.ChronoUnit;

public class Task04Main {
    public static void main(String[] args) {
        ConsoleHandler consoleLog = new ConsoleHandler();
        consoleLog.log("message1 - Console");

        FileHandler fileLogger = new FileHandler("message2 - File.txt");
        fileLogger.log("message2 - File");

        RotationFileHandler rotationFileLogger = new RotationFileHandler("message3 - FileWithTimeRotation", ChronoUnit.HOURS);
        rotationFileLogger.log("message3 - FileWithTimeRotation");

        MemoryHandler memLogger = new MemoryHandler(2, consoleLog, fileLogger);
        memLogger.log("message4 - Logger");
        memLogger.log("message5 - Logger");
        memLogger.log("message6 - Logger");

    }
}
