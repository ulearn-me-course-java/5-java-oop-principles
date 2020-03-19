package com.example.task04;

import java.io.IOException;
import java.time.temporal.ChronoUnit;

import static java.lang.Thread.*;

public class Task04Main {
    public static void main(String[] args) throws IOException {
        ConsoleHandler ch = new ConsoleHandler();
        FileHandler fh = new FileHandler("log.txt");
        RotationFileHandler rfh = new RotationFileHandler("", ChronoUnit.SECONDS);
        MemoryHandler mh = new MemoryHandler(3, fh);
        Logger l = Logger.getLogger("log1");
        l.addHandler(ch);
        l.addHandler(rfh);
        l.addHandler(mh);
        l.log("message1", Level.ERROR);
        l.log("message2", Level.ERROR);
        pause(1000);
        l.log("message3", Level.ERROR);
        l.log("message4", Level.ERROR);
    }

    private static void pause(long millis) {
        try {
            sleep(millis);
        } catch (InterruptedException ex) {
            currentThread().interrupt();
        }
    }
}
