package com.example.task03;

public class Task03Main {
    public static void main(String[] args) {
        TimeUnit unit1 = new Milliseconds(4000);

        printTimeUnit(unit1);
        
        Tests tests = new Tests();
        tests.testMilliseconds();
        tests.testMilliseconds2();
        tests.testMilliseconds3();
        tests.testMilliseconds4();
        tests.testMinutes();
        tests.testMinutes2();
        tests.testSeconds();
        tests.testSeconds2();
        tests.testSeconds3();
        tests.testUtils();
        tests.testUtils2();
        tests.testUtils3();
        tests.testUtils4();
    }

    private static void printTimeUnit(TimeUnit unit) {
        System.out.println(String.format("Milliseconds: %d", unit.toMillis()));
        System.out.println(String.format("Seconds:      %d", unit.toSeconds()));
        System.out.println(String.format("Minutes:      %d", unit.toMinutes()));
        System.out.println(String.format("Hours:        %d", unit.getHours()));
    }
}
