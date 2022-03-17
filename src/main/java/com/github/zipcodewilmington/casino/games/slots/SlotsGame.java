package com.github.zipcodewilmington.casino.games.slots;

import com.github.zipcodewilmington.casino.games.GameInterface.GamblingGame;
import com.github.zipcodewilmington.casino.games.Person.Player;

import java.util.Random;
import java.util.Scanner;

/**
 * Created by leon on 7/21/2020.
 */
public class SlotsGame implements GamblingGame<SlotsPlayer> {
    //Variables
    SlotsPlayer player;


    public static void main(String []  args) {
        Random random = new Random();
        Scanner scanner = new Scanner (System.in);
        int min = 0;
        int max = 10;
        int column1;
        int column2;
        int column3;

        column1 = random.nextInt(10);
        column2 = random.nextInt(10);
        column3 = random.nextInt(10);

        System.out.println("|"+column1+"|"+column2+"|"+column3+"|");

        if (column1 == 7 && column2 == 7 && column3 ==7 ) {
            System.out.println("You just won the jackpot!");
        }
        else {
            System.out.println("Try again :)");
        }

    }

    @Override
    public void setBets() {

    }

    @Override
    public void distributeWinningsToWinners(SlotsPlayer winner) {

    }

    public void distributeWinningsToWinners() {

    }

    @Override
    public void play() {

    }

    @Override
    public void setPlayerMax() {

    }

    @Override
    public void addPlayer(SlotsPlayer player) {
        this.player = player;


    }

    @Override
    public void removePlayer(SlotsPlayer player) {


    }

    @Override
    public void winConditionCheck(SlotsPlayer player) {

    }

    public void setWinCondition() {

    }

    @Override
    public SlotsPlayer[] getWinner() {
        return new SlotsPlayer[0];
    }

    @Override
    public void exit() {

    }

    public SlotsPlayer getPlayer(){
        return this.player;
    }
}
