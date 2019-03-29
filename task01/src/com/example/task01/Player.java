package com.example.task01;

import java.util.Scanner;

public class Player {
    String name;

    Player (String name){
        this.name = name;
    }

    String getName(){ return name; }

    Coords getCoords(){
        Scanner in = new Scanner(System.in);
        System.out.println("Введите координаты x и y");
        return new Coords(in.nextByte(), in.nextByte());
    }
}
