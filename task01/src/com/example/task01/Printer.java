package com.example.task01;

public class Printer {
    Desk desk;

    Printer(Desk desk){
        this.desk = desk;
    }

    void Print(){
        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= 3; j++) {
                System.out.print(desk.cells[i][j].state);
            }
            System.out.println();
        }
    }
}
