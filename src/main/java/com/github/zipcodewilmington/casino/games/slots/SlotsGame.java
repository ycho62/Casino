package com.github.zipcodewilmington.casino.games.slots;

import java.util.Random;
import java.util.Scanner;

/**
 * Created by leon on 7/21/2020.
 */
public class SlotsGame {

    public static void main(String []  args) {
        Random random = new Random();
        Scanner scanner = new Scanner (System.in);
        int column1;
        int column2;
        int column3;

        column1 = random.nextInt();
        column2 = random.nextInt();
        column3 = random.nextInt();

        System.out.println("|"+column1+"|"+column2+"|"+column3+"|");

    }
}
