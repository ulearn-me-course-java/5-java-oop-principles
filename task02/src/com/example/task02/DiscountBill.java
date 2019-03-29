package com.example.task02;

public class DiscountBill extends Bill {
    private final int discount;

    public DiscountBill(int discount) {
        this.discount = discount;
    }

    public long getPrice() {
        return (long)(super.getPrice()*(1-(double)discount/100));
    }

    public double getDiscount() {
        return discount;
    }

    public long getAbsoluteDiscountValue() {
        return super.getPrice() - getPrice();
    }
}