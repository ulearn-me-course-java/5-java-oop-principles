package com.example.task03;

public class Hours implements TimeUnit {
    private long count;

    public Hours(long count) {
        this.count = count;
    }

    @Override
    public long toMillis() {
        return count*60*60*1000;
    }

    @Override
    public long toSeconds() {
        return count*60*60;
    }

    @Override
    public long toMinutes() {
        return count*60;
    }

    @Override
    public long toHours() {
        return count;
    }
}
