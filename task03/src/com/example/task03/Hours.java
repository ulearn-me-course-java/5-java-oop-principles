package com.example.task03;

public class Hours implements TimeUnit{
    private final long amount;
    public Hours(long amount)
    {
        this.amount = amount;
    }
    private long getAmount()
    {
        return this.amount;
    }

    @Override
    public long toMillis() {
        return getAmount() * 3_600_000;
    }

    @Override
    public long toSeconds() {
        return getAmount() * 3_600;
    }

    @Override
    public long toMinutes() {
        return getAmount() * 60;
    }

    @Override
    public long toHours(){
        return this.amount;
    }
}
