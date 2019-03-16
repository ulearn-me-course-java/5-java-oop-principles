package com.example.task02;

public class DiscountBill extends Bill {
    /**
     * Скидка (в процентах)
     */
    private final double discount;

    /**
     * @param discount Скидка (в процентах)
     */
    public DiscountBill(double discount) {
        this.discount = discount;
    }

    @Override
    public long getPrice() {
        return (long) (super.getPrice() * (1 - discount / 100));
    }

    public double getDiscount() {
        return discount;
    }

    public long getAbsoluteDiscountValue() {
        return super.getPrice() - getPrice();
    }
}
