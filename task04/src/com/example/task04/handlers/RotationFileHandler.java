package com.example.task04.handlers;

import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;

public class RotationFileHandler extends FileHandler {
    private Instant from;
    private Duration period;

    public RotationFileHandler() {
        this(null);
    }

    public RotationFileHandler(String filename) {
        this(filename, 1, ChronoUnit.HOURS);
    }

    public RotationFileHandler(long amount, ChronoUnit unit) {
        this(null, amount, unit);
    }

    public RotationFileHandler(String filename, long amount, ChronoUnit unit) {
        super(filename);
        period = Duration.of(amount, unit);
        from = Instant.now();
    }

    private void checkFileIsOutdated() {
        if (Instant.now().isAfter(from.plusSeconds(period.getSeconds()))) {
            setFile(null);
            from = Instant.now();
        }
    }

    @Override
    public void handle(String message) {
        checkFileIsOutdated();
        super.handle(message);
    }
}
