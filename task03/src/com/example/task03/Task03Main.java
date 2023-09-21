package com.example.task03;

public class Task03Main {
    public static void main(String[] args) {
        Tests tests = new Tests();
        tests.testMilliseconds();
        tests.testMilliseconds2();
        tests.testMilliseconds3();
        tests.testMilliseconds4();
        tests.testSeconds();
        tests.testSeconds2();
        tests.testSeconds3();
        tests.testMinutes();
        tests.testMinutes2();
        tests.testUtils();
        tests.testUtils2();
        tests.testUtils3();
        tests.testUtils4();

        TimeUnit unit1 = new Seconds(1000);
        printTimeUnit(unit1);
    }

    private static void printTimeUnit(TimeUnit unit) {
        System.out.printf("Milliseconds: %d%n", unit.toMillis());
        System.out.printf("Seconds:      %d%n", unit.toSeconds());
        System.out.printf("Minutes:      %d%n", unit.toMinutes());
    }
}
