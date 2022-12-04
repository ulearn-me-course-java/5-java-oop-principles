package com.example.task02;

public class DiscountBill  extends  Bill{
    public DiscountBill(int discount){
        this.discount = discount;
    }

    private int discount; // Discount in percents

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    @Override
    public long getPrice() {
        return super.getPrice()*(1-discount/100);
    }

    public long getAbsoluteDiscount() {
        return super.getPrice() - super.getPrice()*discount/100;
    }
}
