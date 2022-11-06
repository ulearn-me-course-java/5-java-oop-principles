package com.example.task04;

import java.time.temporal.ChronoUnit;

public class Task04Main {
    public static void main(String[] args) {
        ConsoleHandler consoleLogger = new ConsoleHandler();
        consoleLogger.logger("message1 - Console =^._.^=");

        FileHandler fileLogger = new FileHandler("message2 - File.txt");
        fileLogger.logger("message2 - File =^._.^=");

        RotationFileHandler rotationFileLogger = new RotationFileHandler("message3 - FileWithTimeRotation", ChronoUnit.HOURS);
        rotationFileLogger.logger("message3 - FileWithTimeRotation =^._.^=");

        MemoryHandler memLogger = new MemoryHandler(2, consoleLogger, fileLogger);
        memLogger.logger("message4 - memLogger =^._.^=");
        memLogger.logger("message5 - memLogger");
        memLogger.logger("message6 - memLogger");

    }
}
