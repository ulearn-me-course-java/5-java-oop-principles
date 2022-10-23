package com.example.task02;

public class DiscountBill extends Bill{
    private long discount;

    public long getDiscount(){
        return discount;
    }
    public void setDiscount(long discount){
        if(discount<= 100)
            this.discount = discount;
    }
    @Override
    public long getPrice() {
        return super.getPrice() * (1- discount /100);
    }
    private long getAbsoluteValueDiscount(){
        return super.getPrice() - getPrice();
    }

}
