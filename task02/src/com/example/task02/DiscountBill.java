package com.example.task02;

public class DiscountBill extends Bill {

    private double discount;

    public DiscountBill(double sale) {
        if (sale >= 0 && sale <= 100) {
            this.discount = sale;
        }
    }

    public double getDiscount(){
        return this.discount;
    }

    public double getAbsolute(){
        return super.getPrice() - this.getTotalPrice();
    }

    public double getTotalPrice(){
        return super.getPrice() *(1 - discount / 100);
    }

}
