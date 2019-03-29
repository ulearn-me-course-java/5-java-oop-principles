package com.example.task03;

public class Minutes implements TimeUnit {
    private long count;

    public Minutes(long count) {
        this.count = count;
    }

    @Override
    public long toMillis() {
        return count*60*1000;
    }

    @Override
    public long toSeconds() {
        return count*60;
    }

    @Override
    public long toMinutes() {
        return count;
    }

    @Override
    public long toHours() {
        return Math.round((float)count/60);
    }
}
