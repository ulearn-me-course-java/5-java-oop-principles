package com.example.task02;

public class DiscountBill extends Bill {
    private double discount = 0;

    public DiscountBill(double discount) {
        if (discount < 0 || discount > 1) {
            throw new IllegalArgumentException("Discount must be between 0 and 1");
        }
        this.discount = discount;
    }

    public double getDiscount() {
        return discount;
    }

    @Override
    public long getPrice() {
        long price = super.getPrice();
        return (long) (price - price * (this.discount));
    }

    public double getAbsoluteDiscount() {
        return super.getPrice() - this.getPrice();
    }
}
