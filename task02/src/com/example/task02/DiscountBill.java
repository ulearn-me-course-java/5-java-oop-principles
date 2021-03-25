package com.example.task02;

public class DiscountBill extends Bill {
    private long discount;

    @Override
    public long getPrice() {
        long result = super.getPrice() - getAbsDiscount();
        return result;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public long getDiscount() {
        return discount;
    }
    public long getAbsDiscount() { return super.getPrice()/100 * discount; }
}
