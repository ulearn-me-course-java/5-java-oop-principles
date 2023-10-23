package com.example.task02;

public class DiscountBill extends Bill {
    private int discount;

    public DiscountBill(int discount){
        this.discount = discount;
    }

    public int getDiscount() {
        return discount;
    }

    public String getDiscountPercentage(){
        return discount+"%";
    }

    public long getAbsoluteDiscount(){
        return super.getPrice() - getPrice();
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    @Override
    public long getPrice(){
        long price = super.getPrice();
        return price - price * discount / 100;
    }
}
