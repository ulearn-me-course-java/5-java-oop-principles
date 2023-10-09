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
        return discount * 100 + "%";
    }

    public long  getAbsoluteDiscount() {
        return  super.getPrice() - getPrice();
    }

    @Override
    public long getPrice() {
        return (long) (super.getPrice() - Math.ceil(super.getPrice() * (1 - discount)));
    }
}
