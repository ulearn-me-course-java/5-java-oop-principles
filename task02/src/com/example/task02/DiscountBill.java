package com.example.task02;

public class DiscountBill extends Bill {
    public int discount = 0;

    public DiscountBill(int discount){
        this.discount = discount;
    }

    @Override
    public long getPrice() {
        return super.getPrice()*((100 - discount)/100);
    }
    public int getDiscount() {
        return discount;
    }
    public double getAbsoluteDiscount() {
        return super.getPrice() - getPrice();
    }
}
