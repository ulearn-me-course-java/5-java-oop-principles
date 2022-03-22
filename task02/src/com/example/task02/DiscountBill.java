package com.example.task02;

public class DiscountBill extends Bill{
    private final int discount;

    public DiscountBill(int discount) {
        this.discount = discount;
    }

    public String getDiscount() {
        return discount + "%";
    }

    public long getPrice() {
        return (long)(super.getPrice() - super.getPrice() * (discount / 100F));
    }

    public long getAbsoluteDiscount() {
        return super.getPrice() - getPrice();
    }
}
