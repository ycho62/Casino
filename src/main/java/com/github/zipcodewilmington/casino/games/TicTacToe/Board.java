package com.github.zipcodewilmington.casino.games.TicTacToe;

public class Board {
    String[][] board = new String[3][3];
    public Board(){
        for (int i=0;i<3;i++){
            for (int j=0;j<3;j++){
                board[i][j]="";
            }
        }
    }

    public boolean markBoard(String marker, int row, int column){
        if (board[row][column].equals("")) {
            board[row][column] = marker;
            return false;
        }
        else
            return true;
    }

    public String[][] getBoard() {
        return board;
    }

    public String displayBoard() {
        String boardState = "";
        for (int i=0;i<3;i++){
            boardState += String.format(" %1s | %1s | %1s \n",
                    board[i][0],board[i][1],board[i][2]);
            if (i<2)
                boardState+="-----------\n";
        }
        return boardState;
    }
}
