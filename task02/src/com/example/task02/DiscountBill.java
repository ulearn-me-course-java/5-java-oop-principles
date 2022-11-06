package com.example.task02;

public class DiscountBill extends Bill{
    private int discount;

    public DiscountBill(int discount){
        this.discount = discount;
    }

    @Override
    public long getPrice() {
        long price = 0;
        for (BillItem item: items) {
            price += item.item.getPrice() * item.amount * (1 - discount * 0.01);
        }
        return price;
    }

    public double getDiscount(){
        return discount;
    }

    public double absolutDiscount(){
        return super.getPrice() - getPrice();
    }

}
