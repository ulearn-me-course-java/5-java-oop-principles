package com.example.task04;

import java.time.temporal.ChronoUnit;

public class Task04Main {
    public static void main(String[] args) {
        RotationFileHandler rot = new RotationFileHandler(ChronoUnit.HOURS);
        rot.log("wtf");
        for (int i = 0; i < 9999; i++){

        }
        rot.log("ffff");
    }
}
