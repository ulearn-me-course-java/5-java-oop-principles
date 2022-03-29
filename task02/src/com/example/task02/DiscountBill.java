package com.example.task02;

public class DiscountBill extends Bill {

    private int discount;

    public double getDiscount() {
        return discount;
    }

    public void setDiscount (int value) {
        if(!(discount < 0 || discount >= 100)) {
            discount = value;
        }
    }

    public double finalPrice() {
        return super.getPrice() * (100 -discount) / 100;
    }

    public double difference() {
        return super.getPrice() - finalPrice();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Bill to pay\n");
        for(BillItem item : items) {
            sb.append(item.item.getName()).append('(').append(item.amount).append(')');
            sb.append('\n');
        }
        sb.append("Sum: ").append(finalPrice());
        sb.append(" | Difference: ").append(difference());
        return sb.toString();
    }
}
