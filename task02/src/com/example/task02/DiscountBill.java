package com.example.task02;

public class DiscountBill extends Bill{
    double Discount;

    public DiscountBill(double discount)
    {
        Discount = discount;
    }
    @Override
    public long getPrice() {
        long price = super.getPrice();
        return (long) (price - price*0.01*Discount);
    }
    public double getDiscount() {
        return Discount;
    }
    public long getAbsulet(){
        return super.getPrice() - getPrice();
    }
}