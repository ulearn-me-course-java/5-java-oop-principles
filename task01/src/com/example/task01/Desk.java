package com.example.task01;

public class Desk {
    Cell[][] cells = new Cell[3][3];

    void Clean(){
        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= 3; j++) {
                cells[i][j].state = Symbol.Empty;
            }
        }
    }

    Cell getCell(Coords coord){
        return cells[coord.x][coord.y];
    }
}
