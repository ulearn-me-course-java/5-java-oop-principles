package com.example.task03;

public class Task03Main {
    public static void main(String[] args) {
        TimeUnit unit1 = new Seconds(1000);
        printTimeUnit(unit1);
    }

    private static void printTimeUnit(TimeUnit unit) {
        Seconds seconds = TimeUnitUtils.toSeconds(new Milliseconds(1500));
        System.out.println(String.format("Milliseconds: %d", seconds.toMillis()));
        System.out.println(String.format("Seconds:      %d", seconds.toSeconds()));
        System.out.println(String.format("Minutes:      %d", seconds.toMinutes()));
    }
}
