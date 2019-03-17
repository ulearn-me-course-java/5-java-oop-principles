package com.example.task02;

public class DiscountBill extends Bill {

    private final double discount;

    DiscountBill(int discount){
        if (discount < 0 || discount > 100){
            throw new IllegalArgumentException();
        }
        this.discount = discount;
    }

    public double getDiscountPrise(){
        return getPrice() * (1 - discount/100);
    }

    public double getDiscount(){
        return discount;
    }

    public double getAbsoluteDiscountPrise(){
        return getPrice() - getDiscountPrise();
    }
}
