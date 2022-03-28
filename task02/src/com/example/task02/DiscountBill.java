package com.example.task02;

public class DiscountBill extends Bill {
    private int discount;

    public void setDiscount(int percent){
        discount = percent;
    }
    public void setDiscount(double part){
        discount = (int)Math.round(part * 100);
    }
    public long getPrice(){
        long price = super.getPrice();
        double discountPart = discount / 100d;
        long res = (long) (price - price * discountPart);
        return res;
    }
    public int getDiscountValue(){
        return discount;
    }
    public long getDiscountSum(){
        return super.getPrice() - getPrice();
    }
}
