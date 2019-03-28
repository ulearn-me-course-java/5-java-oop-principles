package com.example.task02;


public class DiscountBill extends Bill {
    double Sale;
    public DiscountBill(double sale){
        super();
        Sale = sale;
    }
    @Override
    public double getPrice(){
        double price =super.getPrice();
        return price - price* (Sale /100);
    }

    public double getProcentSale() {
        return Sale /100;
    }
    public double getAbsolutlyValue(){
        return super.getPrice()- getPrice();
    }

}
