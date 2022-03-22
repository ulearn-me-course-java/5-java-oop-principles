package com.example.task02;

public class Task02Main {

    private static final Item ITEM1 = new Item("Goods 1", 10);
    private static final Item ITEM2 = new Item("Goods 2", 20);
    private static final Item ITEM3 = new Item("Goods 3", 30);
    private static final Item ITEM4 = new Item("Goods 4", 40);
    private static final Item ITEM5 = new Item("Goods 5", 50);
    private static final Item ITEM6 = new Item("Goods 6", 60);

    public static void main(String[] args) {
        Bill bill = new Bill();
        bill.add(ITEM1, 10);
        bill.add(ITEM3, 3);
        bill.add(ITEM6, 1);
        System.out.println(bill);

        System.out.println("\n");

        bill.add(ITEM3, 3);
        System.out.println(bill);


        System.out.println("\n");

        DiscountBill newBill = new DiscountBill();
        newBill.add(ITEM1, 10);
        newBill.add(ITEM3, 3);
        newBill.add(ITEM6, 1);
        System.out.println(newBill);
        newBill.add(ITEM3, 3);
        System.out.println("\n");
        System.out.println(newBill);
    }
}
