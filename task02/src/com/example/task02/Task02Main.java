package com.example.task02;

public class Task02Main {

    private static final Item ITEM1 = new Item("ITEM 1", 10);
    private static final Item ITEM2 = new Item("ITEM 2", 20);
    private static final Item ITEM3 = new Item("ITEM 3", 30);
    private static final Item ITEM4 = new Item("ITEM 4", 40);
    private static final Item ITEM5 = new Item("ITEM 5", 50);
    private static final Item ITEM6 = new Item("ITEM 6", 60);

    public static void main(String[] args) {
        Bill bill1 = new Bill();
        bill1.add(ITEM1, 10);
        bill1.add(ITEM3, 3);
        bill1.add(ITEM6, 1);
        System.out.println(bill1);

        DiscountBill bill2 = new DiscountBill(50);
        bill2.add(ITEM1, 10);
        bill2.add(ITEM3, 3);
        bill2.add(ITEM6, 1);
        System.out.println(bill2);
    }
}
