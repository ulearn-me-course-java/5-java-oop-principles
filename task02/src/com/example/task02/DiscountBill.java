package com.example.task02;

public class DiscountBill extends Bill {
    private double discount;

    public DiscountBill(double discount) {
        if (discount >= 100 || discount < 0) {
            throw new IllegalArgumentException("Error discount");
        }
        this.discount = discount;
    }

    @Override
    public long getPrice() {
        long price = super.getPrice();
        return (long) (price - price * (discount / 100));
    }

    public double getDiscount() {
        return discount;
    }

    public double getAbsDiscount() {
        return super.getPrice() - getPrice();
    }
}
