package com.example.task03;

public class Task03Main {
    public static void main(String[] args) {
        TimeUnit unit1 = new Seconds(1000);
        TimeUnit unit2 = new Minutes(59);
        TimeUnit unit3 = new Hours(140);
        printTimeUnit(unit1);
        printTimeUnit(unit2);
        printTimeUnit(unit3);
    }

    private static void printTimeUnit(TimeUnit unit) {
        System.out.println(String.format("Milliseconds: %d", unit.toMillis()));
        System.out.println(String.format("Seconds:      %d", unit.toSeconds()));
        System.out.println(String.format("Minutes:      %d", unit.toMinutes()));
        System.out.println(String.format("Hours:        %d", unit.getHours()));
    }
}
