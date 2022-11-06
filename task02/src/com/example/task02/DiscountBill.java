package com.example.task02;

public class DiscountBill extends Bill{
    private float discount;

    public DiscountBill (float discount) {
        this.discount = discount / 100;
    }

    public void setDiscount(float discount) {
        this.discount = discount / 100;
    }

    public float getDiscount() {
        return discount * 100;
    }

    @Override
    public long getPrice() {
        return (long) (super.getPrice() * (1.0f - discount));
    }

    public long getValueOfDiscount() {
        return super.getPrice() - getPrice();
    }

}
