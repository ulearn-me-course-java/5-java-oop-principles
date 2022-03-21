package com.example.task03;

public class Task03Main {
    public static void main(String[] args) {
        TimeUnit unit1 = TimeUnitUtils.toSeconds( new Milliseconds(1500));
        printTimeUnit(unit1);
    }

    private static void printTimeUnit(TimeUnit unit) {
        System.out.println(String.format("Milliseconds: %d", unit.toMillis()));
        System.out.println(String.format("Seconds:      %d", unit.toSeconds()));
        System.out.println(String.format("Minutes:      %d", unit.toMinutes()));
    }
}
