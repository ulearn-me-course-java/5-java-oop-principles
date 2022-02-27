package com.example.task02;

public class DiscountBill extends Bill {

    double discount;
    public DiscountBill(double discount){
        super();
        this.discount = discount;
    }
    @Override
    public long getPrice() {
        return Math.round(super.getPrice() - (super.getPrice() * (discount/100)));
    }
    public String getDiscount() {
        return discount + "%";
    }
    public long absoluteDiscount() {
        return super.getPrice() - this.getPrice();
    }
}
