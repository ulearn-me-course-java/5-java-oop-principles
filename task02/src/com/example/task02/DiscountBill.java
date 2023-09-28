package com.example.task02;

public class DiscountBill extends Bill {

    private final double sale;

    public double getPercentSale() {
        return sale;
    }

    public long getAbsoluteSale() {
        long resPrice = super.getPrice();
        return (long) (resPrice * sale);
    }

    public DiscountBill(double sale) {
        super();
        this.sale = sale;
    }

    @Override
    public long getPrice() {
        long resPrice = super.getPrice();
        long salePrice = (long) (resPrice * sale);
        return resPrice - salePrice;
    }
}
