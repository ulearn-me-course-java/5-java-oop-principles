package com.example.task02;

public class DiscountBill extends Bill {
    private final double discountPercent;

    public DiscountBill(double discountPercent) {
        this.discountPercent = discountPercent;
    }

    @Override
    public long getPrice() {
        return (long) (super.getPrice() * (1d - discountPercent / 100d));
    }

    public String getDiscount() {
        return discountPercent + "%";
    }

    public long getAbsoluteDiscount() {
        return super.getPrice() - getPrice();
    }
}
