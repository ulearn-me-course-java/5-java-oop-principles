package com.example.task02;

public class DiscountBill extends Bill {

    private int discount; //% [0;100]

    public DiscountBill(int discount){
        super();
        this.discount = discount;
    }

    @Override
    public long getPrice() {
        return Math.round(super.getPrice() * (1 - discount/100f));
    }

    public int getDiscount(){
        return discount;
    }

    public long getAbsDiscount(){
        return super.getPrice() - getPrice();
    }
}
