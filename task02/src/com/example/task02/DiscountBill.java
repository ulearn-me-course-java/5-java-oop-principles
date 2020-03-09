package com.example.task02;

public class DiscountBill extends Bill {
    private double discount;

    public DiscountBill(double discount){
        this.setDiscount(discount);
    }

    public void setDiscount(double discount) {
        if(discount > 1 || discount < 0)
            throw new IllegalArgumentException("the discount should not be more than 1 or less than 0");
        else  this.discount = discount;
    }

    public double getDiscount() {
        return discount * 100;
    }

    @Override
    public long getPrice() {
        return (long)(super.getPrice() * (1 - discount));
    }

    public long absDiscount(){
        return super.getPrice() - this.getPrice();
    }
}
