package com.github.zipcodewilmington.casino.games.ceelo;

import com.github.zipcodewilmington.casino.games.Person.Person;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CeeLoPlayerTest {

    @Test
    void setRollValue() {
        Person person = new Person("Fred", 100);
        CeeLoPlayer player = new CeeLoPlayer(person);
        player.setRollValue(6);

        int expected = 6;
        Assert.assertEquals(player.getRollValue(), expected);
    }

    @Test
    void getRollValue() {
    }

    @Test
    void getBalance() {
    }
}