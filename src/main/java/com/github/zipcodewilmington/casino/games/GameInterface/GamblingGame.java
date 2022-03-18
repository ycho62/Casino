package com.github.zipcodewilmington.casino.games.GameInterface;

import com.github.zipcodewilmington.casino.games.Person.Player;
import com.github.zipcodewilmington.casino.games.ceelo.CeeLoPlayer;

import java.util.Map;

public interface GamblingGame <PlayerType extends Player> extends Games<PlayerType>{
    void setBets();

    void distributeWinningsToWinners(PlayerType winner);

}
