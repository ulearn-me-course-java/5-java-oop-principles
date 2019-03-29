package com.example.task01;

public class Arbitr {
    Game game;
    Player currentPlayer;

    Arbitr(Game game){
        this.game = game;
        currentPlayer = game.xPlayer;
    }

    void StartGame(){
        for (int turn = 0; turn < 9; turn++) {
            Coords tempCoords = currentPlayer.getCoords();

            if (game.desk.getCell(tempCoords).state != Symbol.Empty && tempCoords.InInterval((byte)3, (byte)3)){
                System.out.println("Недопустимый ход");
            }
        }
    }
}
