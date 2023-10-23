package com.example.task02;

public class DiscountBill extends Bill {
    private final double discount;

    public DiscountBill(Integer discount) {
        this.discount = discount;
    }

    public double getDiscount(){
        return discount;
    }

    public Long getAbsoluteDiscount(){
        return super.getPrice() - getPrice();
    }

    @Override
    public long getPrice() {
        long price = super.getPrice();
        return (long) (price - price * (discount/100));
    }

}
