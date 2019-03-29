package com.example.task01;

public class Game {
    Player xPlayer;
    Player oPlayer;
    Desk desk;
    Printer printer;
    Arbitr arbitr;

    Game(Player xPlayer, Player oPlayer, Desk desk, Printer printer){
        this.xPlayer = xPlayer;
        this.oPlayer = oPlayer;
        this.desk = desk;
        this.printer = printer;
    }
}
