package com.example.task02;

public class DiscountBill extends Bill{
    private int discount;

    public DiscountBill(int discount){
        super();
        this.discount = discount;
    }

    @Override
    public long getPrice(){
        return Math.round(super.getPrice() * (1 - discount/ 100f));
    }

    public String getDiscount(){
        return discount + "%";
    }

    public long absoluteDiscount(){
        return super.getPrice() - getPrice();
    }
}
