package com.example.task03;

public class Task03Main {
    public static void main(String[] args) {
        TimeUnit unit1 = new Seconds(1000);
        printTimeUnit(unit1);
    }

    private static void printTimeUnit(TimeUnit unit) {
        System.out.printf("Milliseconds: %d%n", unit.toMillis());
        System.out.printf("Seconds:      %d%n", unit.toSeconds());
        System.out.printf("Minutes:      %d%n", unit.toMinutes());
    }
}
