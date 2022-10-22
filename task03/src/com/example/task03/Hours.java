package com.example.task03;

public class Hours implements TimeUnit{

    private final long amount;

    public Hours(long amount){
        this.amount = amount;
    }

    public long getHours() {
        return amount;
    }

    @Override
    public long toMillis() {
        return getHours() * 3600000;
    }

    @Override
    public long toSeconds() {
        return getHours() * 3600;
    }

    @Override
    public long toMinutes() {
        return getHours() * 60;
    }
}
