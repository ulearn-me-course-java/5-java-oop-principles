package com.example.task03;

public class Hours implements TimeUnit {

    private final long amount;

    public Hours(long amount) {
        this.amount = amount;
    }

    @Override
    public long toMillis() {
        return Math.round(amount / (1000D * 60 * 60));
    }

    @Override
    public long toSeconds() {
        return Math.round(amount / (60D * 60));
    }

    @Override
    public long toMinutes() {
        return Math.round(amount / 60D);
    }

    @Override
    public long toHours() {
        return amount;
    }
}
