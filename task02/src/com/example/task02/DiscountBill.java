package com.example.task02;

public class DiscountBill extends Bill {
    private double discount;

    public DiscountBill(double discount) {
        if (discount >= 0 && discount <= 100) {
            this.discount = discount;
        }
    }

    public double getDiscount() {
        return discount;
    }

    @Override
    public long getPrice(){
        return (long) (super.getPrice() *(100 - discount) / 100);
    }

    public long getAbsolute() {
        return super.getPrice() - this.getPrice();
    }
}
