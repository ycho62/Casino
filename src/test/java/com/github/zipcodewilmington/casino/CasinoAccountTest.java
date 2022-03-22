package com.github.zipcodewilmington.casino;

import com.github.zipcodewilmington.casino.games.Person.Person;
import com.github.zipcodewilmington.casino.games.Person.Player;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CasinoAccountTest {
    CasinoAccount casinoAccount = new CasinoAccount("TestName", "TestPassword");

    @Test
    void getAccountName() {
        //When
        String name = casinoAccount.getAccountName();
        //Then
        Assertions.assertEquals("TestName", name);
    }

    @Test
    void getAndSetAccountPasswordTest() {
        //When
        String newPassword = "Test";
        casinoAccount.setAccountPassword(newPassword);
        String actualNewPassword = casinoAccount.getAccountPassword();
        //Then
        Assertions.assertEquals(newPassword, actualNewPassword);
    }

    @Test
    void createAndGetProfileTest() {
        //When
        Person expectedProfile = new Person("name", 10);
        casinoAccount.createProfile("name",10);
        Person actualProfile = casinoAccount.getProfile();
        //Then
        Assertions.assertEquals(expectedProfile.getName(), actualProfile.getName());
        Assertions.assertEquals(expectedProfile.getWallet(),actualProfile.getWallet());
    }

    @Test
    void addFundsTest() {
        //When
        casinoAccount.createProfile("name",10);
        casinoAccount.addFunds(10);
        Integer actualFunds = casinoAccount.getProfile().getWallet();
        //Then
        Assertions.assertEquals(20,actualFunds);
    }
}