package com.example.task01;

public class Cell {
    Symbol state;

    Cell(){
        state = Symbol.Empty;
    }

    Symbol getSymbol(){
        return state;
    }
}
