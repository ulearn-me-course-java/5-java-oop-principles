package com.example.task03;

public class Hours implements TimeUnit
{
    private final long amount;

    public Hours(long amount)
    {
        if (amount < 0) amount = 0;
        this.amount = amount;
    }

    @Override
    public long toMillis()
    {
        return toSeconds() * 1000;
    }

    @Override
    public long toSeconds()
    {
        return toMinutes() * 60;
    }

    @Override
    public long toMinutes()
    {
        return amount * 60;
    }

    @Override
    public long toHours()
    {
        return amount;
    }
}
