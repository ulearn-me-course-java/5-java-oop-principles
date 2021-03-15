package com.example.task02;

public class DiscountBill extends Bill {
    private int discount;

    public DiscountBill(int discount){
        this.discount = discount;
    }

    public long getPriceWithDiscount(){
        return (getPrice()*(100-discount))/100;
    }

    public int getDiscount(){
        return discount;
    }

    public long getAbsValueOfDiscount(){
        return  getPrice() - getPriceWithDiscount();
    }

    @Override
    public String toString(){
        return super.toString() + "\n" +
                "Сумма со скидкой: " + getPriceWithDiscount()
                + "\nСкидка " + discount + "%\n"
                + "Вы сэкономили " + getAbsValueOfDiscount() + " рублей";
    }
}
