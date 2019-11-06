package com.example.task03;

public class Hours implements TimeUnit {

    private long amount = 0;

    public Hours(long amount){
        this.amount = amount;
    }

    @Override
    public long toMillis() {
        return this.amount*3600000;
    }

    @Override
    public long toSeconds() {
        return this.amount*3600;
    }

    @Override
    public long toMinutes() {
        return this.amount*60;
    }

    @Override
    public long toHours() {
        return this.amount;
    }
}
