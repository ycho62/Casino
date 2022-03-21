package com.github.zipcodewilmington.casino.games.TicTacToe;

public class Board {
    String[][] board = new String[3][3];
    public Board(){}

    public boolean markBoard(String marker, int row, int column){
        if (board[row][column] == null) {
            board[row][column] = marker;
            return true;
        }
        else
            return false;
    }

    public String[][] getBoard() {
        return board;
    }

    public String displayBoard() {
        return null;
    }
}
