package com.example.task03;

public class Hours implements TimeUnit {
    private final long amount;

    Hours(long amount) { this.amount = amount; }

    public long toMillis() { return toSeconds() * 1000; }

    public long toSeconds() { return toMinutes() * 60; }

    public long toMinutes() { return amount * 60; }

    public long toHours() { return amount; }

    public long getHours() {
        return toHours();
    }
}
