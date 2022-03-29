package com.example.task02;

import java.util.ArrayList;
import java.util.List;

/**
 * Счет к оплате
 */
public class Bill {
    private List<BillItem> items = new ArrayList<>();

    /**
     * Добавляет товар в корзину
     *
     * @param item товар
     * @param amount количество
     */
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

    /**
     * Подсчитывает общую сумму покупки
     *
     * @return общую стоимость покупки
     */
    public long getPrice() {
        long price = 0;
        for (BillItem item: items) {
            price += item.item.getPrice() * item.amount;
        }
        return price;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Счет к оплате\n");
        for(BillItem item : items) {
            sb.append(item.item.getName()).append('(').append(item.amount).append(')');
            sb.append('\n');
        }
        sb.append("Сумма к оплате: ").append(getPrice());
        return sb.toString();
    }

    private static class BillItem extends Bill{
        final Item item;
        int amount;
        private int discount;

        BillItem(Item item, int amount) {
            this.item = item;
            this.amount = amount;
        }

        @Override
        public long getPrice(){
            return super.getPrice() * 100 / discount;
        }

        public int getDiscount(){
            return discount;
        }

        public void setDiscount(int discount){
            this.discount = discount;
        }

        public long getAbsoluteDiscount(){
            return super.getPrice() - getPrice();
        }
    }
}
