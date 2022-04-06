package com.example.task02;

public class Task02Main {

    private static final Item ITEM1 = new Item("product1", 10);
    private static final Item ITEM2 = new Item("product2", 20);
    private static final Item ITEM3 = new Item("product3", 30);
    private static final Item ITEM4 = new Item("product4", 40);
    private static final Item ITEM5 = new Item("product5", 50);
    private static final Item ITEM6 = new Item("product6", 60);

    public static void main(String[] args) {
        Bill bill = new Bill();
        bill.add(ITEM1, 10);
        bill.add(ITEM3, 3);
        bill.add(ITEM6, 1);
        System.out.println(bill);
        bill.add(ITEM3, 3);
        System.out.println(bill);

        System.out.println("\n");

        DiscountBill discountBill = new DiscountBill(30);
        discountBill.add(ITEM1, 12);
        discountBill.add(ITEM3, 33);
        discountBill.add(ITEM6, 2);
        discountBill.add(ITEM3, 2);
        System.out.println(discountBill);
    }
}
