package com.example.task02;

public class DiscountBill extends Bill{

    private int discount = 0;

    public DiscountBill(int discount){
        if (discount < 100 || discount > 0)
            this.discount = discount;
    }
    public int getDiscountAsPercent(){
        return discount;
    }
    public long absoluteValueDiscount(){
        return super.getPrice() * (discount/100);
    }
    @Override
    public long getPrice() {
        long price=super.getPrice();
        return price-price*discount/100;
    }
}
