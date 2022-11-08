package com.example.task02;

public class DiscountBill extends Bill {

    private double Discount;

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
    public long getAbsolute(){
        return super.getPrice() - getPrice();
    }
}
