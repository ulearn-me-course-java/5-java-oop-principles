package com.example.task03;

public class Hours implements TimeUnit {

    private final long amount;

    public Hours(long amount) {
        this.amount = amount;
    }

    public long toMillis() {
        return amount * 3600000;
    }

    public long toSeconds() {
        return amount * 3600;
    }

    public long toMinutes() {
        return amount * 60;
    }

    @Override
    public long toHours()
    {
        return amount;
    }
}
