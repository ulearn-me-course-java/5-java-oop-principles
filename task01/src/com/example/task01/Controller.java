package com.example.task01;

import java.util.Scanner;

public class Controller {
    Game game;

    void CreateGame(){
        Scanner in = new Scanner(System.in);

        System.out.println("Введите имя игрока X");
        Player xPlayer = new Player(in.next());
        System.out.println("Введите имя игрока O");
        Player oPlayer = new Player(in.next());
        Desk desk = new Desk();
        Printer printer = new Printer(desk);

        game = new Game(xPlayer, oPlayer, desk, printer);
    }

    void StartGame(){
        if (game == null){
            CreateGame();
        }

        game.arbitr = new Arbitr(game);
        game.arbitr.StartGame();
    }
}
