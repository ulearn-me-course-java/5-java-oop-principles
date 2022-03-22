package com.example.task02;

public class DiscountBill extends Bill {
    public final int discount;

    public DiscountBill(int discount)
    {
        this.discount = discount;
    }
    int getDiscount()
    {
        return this.discount;
    }

    @Override
    public long getPrice()
    {
        long price = super.getPrice() - ((super.getPrice() * getDiscount()) / 100);
        return price;
    }
}
