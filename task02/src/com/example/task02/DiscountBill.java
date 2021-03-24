package com.example.task02;

public class DiscountBill extends Bill {
    private float discount = 0;

    public void setDiscount(float discount)
    {
        if (discount <= 1 && discount >= 0)
            this.discount = discount;
    }

    public float getDiscount()
    {
        return Math.round(discount * 100);
    }

    public long getFinalPrice()
    {
        return (long) (getPrice() * (1 - discount));
    }

    public long getAbsDiscountSum()
    {
        return (long) (getPrice() * discount);
    }
}
