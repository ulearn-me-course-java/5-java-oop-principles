package com.example.task02;

public class Task02Main {

    private static final Item ITEM1 = new Item("item 1", 10);
    private static final Item ITEM2 = new Item("item 2", 20);
    private static final Item ITEM3 = new Item("item 3", 30);
    private static final Item ITEM4 = new Item("item 4", 40);
    private static final Item ITEM5 = new Item("item 5", 50);
    private static final Item ITEM6 = new Item("item 6", 60);

    public static void main(String[] args) {
        Bill bill = new Bill();
        bill.add(ITEM1, 10);
        bill.add(ITEM3, 3);
        bill.add(ITEM6, 1);
        System.out.println(bill);
        bill.add(ITEM3, 3);
        System.out.println(bill);

        DiscountBill dBill = new DiscountBill(50);
        dBill.add(ITEM1, 10);
        dBill.add(ITEM3, 3);
        dBill.add(ITEM6, 1);
        System.out.println(dBill);
        dBill.add(ITEM3, 3);
        System.out.println(dBill);
    }
}
