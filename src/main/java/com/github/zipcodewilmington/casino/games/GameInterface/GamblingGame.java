package com.github.zipcodewilmington.casino.games.GameInterface;

import com.github.zipcodewilmington.casino.games.Person.Player;
import com.github.zipcodewilmington.casino.games.ceelo.CeeLoPlayer;

public interface GamblingGame <PlayerType extends Player> extends Games<PlayerType>{
    void setBets();
    void distributeWinningsToWinners(PlayerType winner);

    void winConditionCheck(CeeLoPlayer player1, CeeLoPlayer player2);
}
