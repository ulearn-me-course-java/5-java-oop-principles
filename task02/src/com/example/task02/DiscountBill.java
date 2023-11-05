package com.example.task02;

public class DiscountBill extends Bill{

    private double discount;

    public DiscountBill(double discount) {
        this.discount = discount;
    }

    public double getDiscount() {
        return discount;
    }

    public long getAbsolute(){
        return super.getPrice() - getPrice();
    }
    @Override
    public long getPrice() {
        long price = super.getPrice();
        long discountPrice = (long) (price * discount);

        return price - discountPrice;
    }
}