package com.example.task03;

public class Task03Main {
    public static void main(String[] args) {
        TimeUnit unit1 = new Seconds(5399);
        TimeUnit unit2 = new Hours(1);
        TimeUnit unit3 = new Minutes(0);
        TimeUnit unit4 = new Milliseconds(1000000);
        printTimeUnit(unit4);
    }

    private static void printTimeUnit(TimeUnit unit) {
        System.out.println(String.format("Milliseconds: %d", unit.toMillis()));
        System.out.println(String.format("Seconds:      %d", unit.toSeconds()));
        System.out.println(String.format("Minutes:      %d", unit.toMinutes()));
        System.out.println(String.format("Hours: %d", unit.getHours()));
    }
}
