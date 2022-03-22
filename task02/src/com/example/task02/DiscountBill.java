package com.example.task02;

public class DiscountBill extends Bill {

    private int discount;

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public String getDiscount(){
        return discount + "%";
    }
    public long getDiscountAsLong(){
        return super.getPrice()-this.getPrice();
    }

    @Override
    public long getPrice(){
        return Math.round(super.getPrice()-super.getPrice()*(discount/100.0));
    }


}
