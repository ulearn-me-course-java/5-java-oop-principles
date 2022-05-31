package com.example.task02;

public class DiscountBill extends Bill{

    private final float Discount;

    public DiscountBill(float discount) {
        Discount = discount;
    }

    @Override
    public long getPrice() {
        return (long)(super.getPrice() * (1.0f - Discount));
    }

    public float getDiscountPercentile()
    {
        return Discount;
    }

    public long getDiscountAmount()
    {
        return (long)(super.getPrice() * Discount);
    }
}
