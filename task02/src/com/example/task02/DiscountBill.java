package com.example.task02;

public class DiscountBill extends Bill
{
    private int discount;

    public DiscountBill(int discount)
    {
        setDiscount(discount);
    }

    public double getDiscountPrice()
    {
        var price = getPrice();
        return price * (100 - price) / 100d;
    }

    public void setDiscount(int discount)
    {
        if (discount > 100) discount = 100;
        if (discount < 0) discount = 0;
        this.discount = discount;
    }

    public int getDiscount()
    {
        return discount;
    }

    public double getAbsoluteDiscount()
    {
        var defaultPrice = getPrice();
        var discountPrice = defaultPrice * (100 - discount) / 100d;
        return defaultPrice - discountPrice;
    }
}
