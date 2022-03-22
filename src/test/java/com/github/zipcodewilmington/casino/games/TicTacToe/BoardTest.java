package com.github.zipcodewilmington.casino.games.TicTacToe;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BoardTest {
    Board board = new Board();

    @Test
    void constructorAndGetTest(){
        //When
        String[][] actual = board.getBoard();
        //Then
        Assertions.assertEquals(3,actual.length);
        Assertions.assertEquals(3,actual[0].length);
    }

    @Test
    void markBoardTest() {
        //When
        Boolean actual = board.markBoard("X",1,2);
        Boolean actual2 = board.markBoard("X",1,2);
        //Then
        Assertions.assertTrue(actual2); //true for invalid choice
        Assertions.assertFalse(actual);
    }

    @Test
    void displayBoardTest() {
        //When
        String actual = board.displayBoard();
        String expected="";
        for (int i=0;i<3;i++){
            expected += String.format(" %1s | %1s | %1s \n",
                    "","","");
            if (i<2)
                expected+="-----------\n";
        }

        //Then
        Assertions.assertEquals(expected,actual);
    }
}