package com.example.task02;

public class DiscountBill extends Bill{

    private int discount;

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(int discount){
        if(!(discount < 0 || discount >= 100))
            this.discount = discount;
    }

    public double getDiscountPrice(){
        return super.getPrice() * (100 -discount) / 100;
    }

    public long getAbsoluteValueOfDiscount(){
        return super.getPrice() - getPrice();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Счет к оплате\n");
        for(BillItem item : items) {
            sb.append(item.item.getName()).append('(').append(item.amount).append(')');
            sb.append('\n');
        }
        sb.append("Sum: ").append(getDiscountPrice());
        return sb.toString();
    }
}
