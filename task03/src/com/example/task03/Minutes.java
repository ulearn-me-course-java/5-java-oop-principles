package com.example.task03;

public class Minutes implements TimeUnit {
    private final long minutes;

    public Minutes(long minutes) {
        this.minutes = minutes;
    }

    @Override
    public long toMillis() {
        return minutes * 1000 * 60;
    }

    @Override
    public long toSeconds() {
        return minutes * 60;
    }

    @Override
    public long toMinutes() {
        return minutes;
    }

    public long toHours()    {
        return Math.round((double)minutes / 60);
    }
}
