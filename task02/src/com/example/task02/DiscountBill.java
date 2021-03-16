package com.example.task02;

public class DiscountBill extends Bill{
    public double discount;

    public DiscountBill(long d){
        discount = d;
    }

    public long getPrice() {
       double price = super.getPrice();
       return (long)(price * (1- (discount/100)));
    }

    public double getDiscount(){
        return discount;
    }

    public long getDiference(){
        return super.getPrice() - getPrice();
    }


}
