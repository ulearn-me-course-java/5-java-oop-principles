package com.example.task02;

public class Task02Main {

    private static final Item ITEM1 = new Item("Item 1", 10);
    private static final Item ITEM2 = new Item("Item 2", 20);
    private static final Item ITEM3 = new Item("Item 3", 30);
    private static final Item ITEM4 = new Item("Item 4", 40);
    private static final Item ITEM5 = new Item("Item 5", 50);
    private static final Item ITEM6 = new Item("Item 6", 60);

    public static void main(String[] args) {
        Bill bill = new DiscountBill(10);

        bill.add(ITEM1, 10);
        bill.add(ITEM3, 3);
        bill.add(ITEM6, 1);
        System.out.println(bill);
        bill.add(ITEM3, 3);
        System.out.println(bill);
    }
}
