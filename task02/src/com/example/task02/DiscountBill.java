package com.example.task02;

public class DiscountBill extends Bill {

    private int discount;

    public int getDiscount() {
        return discount;
    }

    public DiscountBill(int discount) {
        if (discount >= 0 && discount <= 100)
            this.discount = discount;
    }

    @Override
    public long getPrice() {
        return (long) (super.getPrice() * (1 - (double) discount / 100));
    }

    public long getAbsoluteDiscount() {
        return super.getPrice() - getPrice();
    }
}