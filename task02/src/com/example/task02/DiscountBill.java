package com.example.task02;

public class DiscountBill extends Bill {
    public short getDiscount() {
        return discount;
    }

    public long getAbsoluteDiscount() {
        return super.getPrice() - this.getPrice();
    }

    private short discount;

    public DiscountBill(short discount) {
        super();
        if (discount >= 0 && discount <= 100) {
            this.discount = discount;
        }
    }

    @Override
    public long getPrice() {
        return (long) (super.getPrice() * (1 - discount / 100));
    }
}
