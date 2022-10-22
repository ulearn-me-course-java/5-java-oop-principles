package com.example.task02;

public class DiscountBill extends Bill{
    private long discount;
    public long getDiscount() {
        return discount;
    }
    public long getAbsoluteDiscount() {
        return getPrice() * discount;
    }

    public void setDiscount(long discount) {
        this.discount = discount / 100;
    }
    public long getFinalPrice() {
        return getPrice() * getAbsoluteDiscount();

    }


}
