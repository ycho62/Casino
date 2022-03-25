package com.github.zipcodewilmington.casino.games.ceelo;


import java.util.Arrays;
import java.util.Random;

public class Dice {
    int[] diceRoll = new int[3];
    Random diceNumber = new Random();

    public Dice(){

    }

    public int getRollDice(int index){return diceRoll[index];}

    public void rollDice(){

        for (int i = 0; i< diceRoll.length; i++) {
            diceRoll[i] = diceNumber.nextInt(1,7);
            
        }
        Arrays.sort(diceRoll);
        for (int i = 0; i< diceRoll.length; i++) {
//            System.out.println(diceRoll[i]);// to see dice value
        }

    }

}
