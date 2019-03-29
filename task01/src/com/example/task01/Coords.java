package com.example.task01;

public class Coords {
    byte x, y;

    Coords (byte x, byte y){
        this.x = x;
        this.y = y;
    }

    boolean InInterval(byte left, byte right){
        return x >= left && x <= right && y >= left && y <= right;
    }
}
