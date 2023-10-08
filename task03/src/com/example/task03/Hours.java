package com.example.task03;

public class Hours implements TimeUnit{

    private final long hours;

    public Hours(long hours) {
        this.hours = hours;
    }

    @Override
    public long toMillis() {
        return 3600 * 1000 * hours;
    }

    @Override
    public long toSeconds() {
        return 3600 * hours;
    }

    @Override
    public long toMinutes() {
        return 60 * hours;
    }

    @Override
    public long toHours() {
        return hours;
    }
}
