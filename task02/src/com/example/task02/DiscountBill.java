package com.example.task02;

public class DiscountBill extends Bill{
    private double discount;

    public DiscountBill() {
        this.discount = 0.1;
    }

    public DiscountBill(double discount) {
        this.discount = discount;
    }

    @Override
    public long getPrice() {
        long price = super.getPrice(); //super - текущий экземпляр родительского класса.
        price -= price * discount;
        return price;
    }

    public double getDiscount(){
        return this.discount * 100;
    }

    public long getDifferenceWithDiscount() {
        return super.getPrice() - getPrice();
    }
}
