package com.example.task02;

public class DiscountBill extends Bill {
    private double discount;

    public DiscountBill(double discount){
        this.discount = discount;
    }

    public double getDiscountPrice(){
        return (getPrice() * (0.01 * discount));
    }

    public double getDiscountedSum() {
        return (getPrice() - getDiscountPrice());
    }

    public double getDiscount(){
        return discount;
    }
}
