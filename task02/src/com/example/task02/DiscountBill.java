package com.example.task02;

public class DiscountBill extends Bill {
    private byte discountPercent;
    public DiscountBill(){
        discountPercent = 0;
    }
    public DiscountBill(byte discountPercent){
        if (discountPercent >=0 && discountPercent <= 100)
            this.discountPercent = discountPercent;
        else throw new IllegalArgumentException("Скидка не может быть отрицательной или быть больше 100%");
    }
    public double getFinalPrice() {
        return getPrice()-(double)getPrice()*discountPercent/100;
    }
    public byte getDiscountPercent() {
        return discountPercent;
    }
    public double getAbsoluteValue() {
        return getPrice() - getFinalPrice();
    }
}
