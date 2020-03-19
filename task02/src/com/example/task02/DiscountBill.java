package com.example.task02;

public class DiscountBill extends Bill {
    private int discount;
    public DiscountBill(int discount)
    {
        if(discount>=0 && discount<=100)
        {this.discount=discount;}
    }
    public int getDiscount()
    {
        return discount;
    }

    public long absoluteDiscount(){
        return super.getPrice() - this.getPrice();
    }
    @Override
    public long getPrice(){
        return (long)super.getPrice()*(1-discount/100);

    }



}
