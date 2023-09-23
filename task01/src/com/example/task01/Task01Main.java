package com.example.task01;

public class Task01Main {
    public static void main(String[] args) {

        Tests tests = new Tests();
        tests.testDebugMethod();
        tests.testErrorMethod();
        tests.testGetLevelMethod();
        tests.testInfoMethod();
        tests.testGetNameMethod();
        tests.testLogMessage();

        tests.testGetLoggerMethod();
        tests.testSetLevelMethod();

        tests.testWarningMethod();
    }
}

