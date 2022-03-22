package com.example.task04;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class RotationFileHandler implements MessageHandler{
    private final ChronoUnit period;

    public RotationFileHandler(ChronoUnit period) {
        this.period = period;
    }

    @Override
    public void log(String msg) {
        LocalDateTime now = LocalDateTime.now().truncatedTo(period);
        try {
            Files.write(Paths.get(now.toString()), (msg + "\n").getBytes(StandardCharsets.UTF_8), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
