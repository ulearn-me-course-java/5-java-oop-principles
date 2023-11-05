package com.example.task03;

public class Hours implements TimeUnit {
    private long hour;

    public Hours(long timeInterval) {
        this.hour = timeInterval;
    }

    @Override
    public long toMillis() {
        return hour * 1000 * 60 * 60;
    }

    @Override
    public long toSeconds() {
        return hour * 60 * 60;
    }

    @Override
    public long toMinutes() {
        return hour * 60;
    }

    @Override
    public long toHours() {
        return hour;
    }
}
