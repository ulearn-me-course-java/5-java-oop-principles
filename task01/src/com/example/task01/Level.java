package com.example.task01;

public enum Level {
    DEBUG(1),
    INFO(2),
    WARNING(3),
    ERROR(4);

    public int getValue() {
        return value;
    }

    private int value;

    Level(int value) {
        this.value = value;
    }
}
