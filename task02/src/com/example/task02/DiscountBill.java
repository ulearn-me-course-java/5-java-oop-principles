package com.example.task02;

public class DiscountBill extends Bill {
    final float discount;

    public DiscountBill(float discount) {
        this.discount = discount;
    }

    public float getDiscount() {
        return discount * 100;
    }

    @Override
    public long getPrice() {
        return (long)(super.getPrice() * (1.0 - discount));
    }

    public long getDifference() {
        return (long)(super.getPrice() * discount);
    }
}
