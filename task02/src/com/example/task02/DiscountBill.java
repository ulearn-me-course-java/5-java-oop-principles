package com.example.task02;

public class DiscountBill extends Bill {

    private double discount = 0;

    public DiscountBill(double discount) {

        if (discount <= 1 && discount >= 0) {
            this.discount = discount;
        } else {
            throw new IllegalArgumentException("Discount can not be less than 0 and more than 1");
        }
        ;
    }

    public String getDiscountInPercent() {
        return discount*100 + "%";
    }

    public double getDiscountAbsolute(){
        return getPrice() - Math.ceil(getPrice()*(1- discount));
    }
}
