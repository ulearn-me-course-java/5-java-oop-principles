package com.example.task02;

public class DiscountBill extends Bill {
    private final int discount;

    public DiscountBill(int discount) {
        if (discount >= 100 || discount <= 0)
            throw new IllegalArgumentException("Discount not in (0, 100)");
        this.discount = discount;
    }

    public int getDiscount() {
        return discount;
    }

    @Override
    public long getPrice() {
        return super.getPrice() * (100 - discount) / 100;
    }

    public long difference(){
        return super.getPrice() - getPrice();
    }
}
