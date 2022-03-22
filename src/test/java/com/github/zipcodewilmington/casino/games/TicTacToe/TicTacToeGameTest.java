package com.github.zipcodewilmington.casino.games.TicTacToe;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TicTacToeGameTest {
    TicTacToeGame ticTacToeGame = new TicTacToeGame();
    Board board = new Board();

    @Test
    void getWinner() {
        //When
        board.markBoard("X",0,0);
        board.markBoard("X",0,1);
        board.markBoard("X",0,2);
        String win = ticTacToeGame.getWinner(board.getBoard());
        //Then
        Assertions.assertEquals("X",win);
    }
}