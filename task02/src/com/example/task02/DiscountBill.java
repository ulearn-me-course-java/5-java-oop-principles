package com.example.task02;

import java.util.ArrayList;
import java.util.List;

public class DiscountBill extends Bill{

    private List<BillItem> items = new ArrayList<>();
    private double discount;          //в процентах

    public DiscountBill(double discount){
        this.discount = discount;
    }

    public void add(Item item, int amount) {
        boolean found = false;
        for (BillItem billItem: items) {
            if (billItem.item.equals(item)) {
                found = true;
                billItem.amount += amount;
                break;
            }
        }
        if (!found) {
            items.add(new BillItem(item, amount));
        }
    }

    public long getPrice() {
        long price = 0;
        for (BillItem item: items) {
            price += item.item.getPrice() * item.amount;
        }
        return price;
    }

    public double getFinalPrice() {
        return (100 - discount) / 100 * (double)getPrice();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Счет к оплате\n");
        for(BillItem item : items) {
            sb.append(item.item.getName()).append('(').append(item.amount).append(')');
            sb.append('\n');
        }
        sb.append("Сумма без скидки: ").append(getPrice()).append('\n');
        sb.append("Сумма к оплате: ").append(getFinalPrice());
        return sb.toString();
    }

    public double getPercentageDiscount(){
        return discount;
    }

    public double getAbsoluteDiscount(){
        return getPrice() - getFinalPrice();
    }

    private static class BillItem {
        final Item item;
        int amount;

        BillItem(Item item, int amount) {
            this.item = item;
            this.amount = amount;
        }
    }
}
