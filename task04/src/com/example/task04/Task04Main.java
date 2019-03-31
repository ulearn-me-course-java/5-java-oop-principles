package com.example.task04;

import java.time.Duration;
import java.time.LocalDateTime;

public class Task04Main {
    public static void main(String[] args) {
        Logger log = new Logger("James");
        FileHandler file = new FileHandler("C:\\Users\\User\\Desktop\\File.txt");
        ConsoleHandler mess = new ConsoleHandler();
        MemoryHandler mem = new MemoryHandler(4, mess);
        RotationFileHandler rot = new RotationFileHandler("C:\\Users\\User\\Desktop\\FileStart.txt", LocalDateTime.now(), Duration.ofNanos(1));
        log.addHandler(file);
        log.addHandler(mess);
        log.addHandler(mem);
        log.addHandler(rot);
        log.log(LogLevel.ERROR, "LOL");
        log.log(LogLevel.ERROR, "LUL");
        log.log(LogLevel.ERROR, "LAL");
        log.log(LogLevel.ERROR, "LAMAL");
    }
}
