package com.example.task02;

public class DiscountBill extends Bill{

    public DiscountBill(int discount){
        if(discount<=100&&discount>=0){this.discount=discount;}
        else {this.discount=0;};
    }

    private int discount=0;

    public int getDiscountInPercent(){
        return  discount;
    }

    public long totalDiscount(){
        return getPrice()*discount/100;
    }



    @Override
    public long getPrice() {
        long a=super.getPrice();
        return a-a*discount/100;
    }
}
