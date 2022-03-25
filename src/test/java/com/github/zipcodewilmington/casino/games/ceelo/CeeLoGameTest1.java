package com.github.zipcodewilmington.casino.games.ceelo;

import com.github.zipcodewilmington.casino.games.Person.Person;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CeeLoGameTest1 {
    @Test
    public void getRollTest(){
        Person person = new Person("Fred", 100);
        CeeLoPlayer player = new CeeLoPlayer(person);
        CeeLoGame game = new CeeLoGame();
        String roll = "roll";
        game.getRoll(player, roll);
        player.setRollValue(6);

    }

    @Test
    public void checkValueOfPlayerTest() {
        Person person = new Person("Fred", 100);
        CeeLoPlayer player = new CeeLoPlayer(person);
        CeeLoGame game = new CeeLoGame();
        String roll = "roll";
        game.getRoll(player, roll);

        Assert.assertEquals(player.getRollValue(), game.getRoll(player, roll));

    }



}