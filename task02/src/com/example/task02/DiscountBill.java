package com.example.task02;

public class DiscountBill extends Bill {

    private double discPercents;

    public DiscountBill(){
        discPercents =0;
    }

    public DiscountBill(double discount){
        if(discount>=0 && discount<100)
            discPercents =discount;
        else throw new IllegalArgumentException("Скидка не может быть отрицательной или быть больше 100%");
    }
    public double getDiscPercents(){
        return discPercents;
    }

    public double getFinalPrice(){
        return getPrice()*(discPercents /100);
    }

    public double getAbsoluteValue(){
        return getPrice()-getFinalPrice();
    }

}
