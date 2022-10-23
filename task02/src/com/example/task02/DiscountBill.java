package com.example.task02;

public class DiscountBill extends Bill
{
    private final float discount;

    public DiscountBill(float discount) {
        this.discount = discount;
    }

    @Override
    public long getPrice() {
        long price = super.getPrice();
        return (long) (price - price * discount * 0.01f);
    }

    public double getDiscount() {
        return discount;
    }

    public long getAbsoluteDiscount() {
        return super.getPrice() - getPrice();
    }
}
