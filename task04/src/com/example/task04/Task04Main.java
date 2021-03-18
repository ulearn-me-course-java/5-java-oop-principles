package com.example.task04;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

public class Task04Main {
    public static void main(String[] args) {
        RotationHandler r = new RotationHandler(Duration.ofSeconds(15), "C:\\");
        r.log("asdafasged ");

    }
}
