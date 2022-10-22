package com.example.task02;

public class DiscountBill extends Bill {
    public final float discount;

    public DiscountBill(int discount) {
        this.discount = discount;
    }

    public float getDiscount() {
        return discount * 100;
    }

    @Override
    public long getPrice() {
        return (long)(super.getPrice() * (1.0f - discount));
    }

    public long getDifference(){
        return (long)(super.getPrice() * discount);
    }
}
