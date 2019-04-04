package com.example.task02;

public class DiscountBill extends Bill {
    private final int discount;

    public DiscountBill(int discount) {
        this.discount = discount;
    }

    public long getDiscount() {
        return discount;
    }

    public long getAbsoluteDiscountValue() {
        return super.getPrice() - getPrice();
    }

    @Override
    public long getPrice() {
        return super.getPrice() * discount / 100;
    }
}
