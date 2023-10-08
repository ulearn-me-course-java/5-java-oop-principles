package com.example.task03;

public class Minutes implements TimeUnit {
    private final long minutes;
    public Minutes(long amount) {
        minutes = amount;
    }

    @Override
    public long toMillis() {
        return minutes * 60 * 1000;
    }

    @Override
    public long toSeconds() {
        return minutes * 60;
    }

    @Override
    public long toMinutes() {
        return minutes;
    }

    @Override
    public long toHours() {
        return Math.round(minutes / 60f);
    }
}
