package com.github.zipcodewilmington.casino.games.TicTacToe;

import com.github.zipcodewilmington.casino.games.GameInterface.Games;
import com.github.zipcodewilmington.utils.AnsiColor;
import com.github.zipcodewilmington.utils.IOConsole;

import java.util.*;

public class TicTacToeGame implements Games<TicTacToePlayer> {
    private final IOConsole console = new IOConsole(AnsiColor.BLUE);
    private boolean exitFlag = false;
    private Map<TicTacToePlayer, String> playerSymbol = new HashMap<>();
    private Map<String, TicTacToePlayer> playerSymbolReverse = new HashMap<>();
    private Board board = new Board();
    private String win="";
    private List<TicTacToePlayer> order = new ArrayList<>();

    public TicTacToeGame(){};

    @Override
    public void play() {
        Boolean invalidMoveFlag = true;
        Integer[] move;
        while (!exitFlag){
            Collections.shuffle(order);
            for (TicTacToePlayer s : order){
                selectSymbol(s);
            }
            TicTacToePlayer player1 = order.get(0);
            TicTacToePlayer player2 = order.get(1);
            while (win.equals("")){
                System.out.println(board.displayBoard());
                while (invalidMoveFlag) {
                    move = getMove(player1);
                    invalidMoveFlag = board.markBoard(playerSymbol.get(player1),
                            move[0]-1,move[1]-1);
                }
                win = getWinner();
                if (!win.equals(""))
                    break;
                invalidMoveFlag = true;
                while (invalidMoveFlag) {
                    move = getMove(player2);
                    invalidMoveFlag = board.markBoard(playerSymbol.get(player2),
                            move[0]-1,move[1]-1);
                }
                win = getWinner();
            }
            System.out.println("Winner is: " + playerSymbolReverse.get(win));
            exit();
        }
    }

    private Integer[] getMove(TicTacToePlayer player1) {
        Integer [] move = new Integer[2];
        move[0]= console.getIntegerInput(player1.getPerson().getName()+
                ", which row would you like to place your mark?");
        while (move[0]<=0 || move[0]>=4){
            move[0] = console.getIntegerInput(player1.getPerson().getName()+
                    "not valid row! Which row would you like to place your mark?");
        }
        move[1] = console.getIntegerInput(player1.getPerson().getName()+
                ", which column would you like to place your mark?");
        while (move[1]<=0 || move[1]>=4){
            move[1] = console.getIntegerInput(player1.getPerson().getName()+
                    "not valid column! Which row would you like to place your mark?");
        }
        return move;
    }

    public void selectSymbol(TicTacToePlayer player){
        String symbol = console.getStringInput(player.getPerson().getName()+", " +
                "do you want to be X or O?");
        while (!(symbol.equalsIgnoreCase("X") || symbol.equalsIgnoreCase("O"))){
            symbol = console.getStringInput(player.getPerson().getName()+", not a valid input." +
                    "Do you want to be X or O?");
        }
    }

    @Override
    public void addPlayer(TicTacToePlayer player) {
        order.add(player);
    }

    public String getWinner(){
        String winner="";
        if ((board.getBoard()[0][0] == board.getBoard()[1][1]) &&
                (board.getBoard()[0][0] == board.getBoard()[2][2])) {
            winner = board.getBoard()[0][0];
        }
        else if ((board.getBoard()[2][0] == board.getBoard()[0][2]) &&
                (board.getBoard()[2][0] == board.getBoard()[1][1])) {
            winner = board.getBoard()[1][1];
        }
        else{
            for (int i=0;i<3;i++) {
                if ((board.getBoard()[i][0] == board.getBoard()[i][1]) &&
                        (board.getBoard()[i][0] == board.getBoard()[i][2])){
                    winner = board.getBoard()[i][0];
                    break;
                }
                else if ((board.getBoard()[0][i] == board.getBoard()[1][i]) &&
                        (board.getBoard()[0][i] == board.getBoard()[2][i])){
                    winner = board.getBoard()[0][i];
                    break;
                }
            }
        }
        return winner;
    }

    @Override
    public void exit() {
        String input = console.getStringInput("Do you want to exit the game?");
        if (input.equalsIgnoreCase("Yes"))
            this.exitFlag=true;
        else {
            board = new Board();
        }
    }

    @Override
    public void winConditionCheck(TicTacToePlayer player) {
    }
    @Override
    public void setPlayerMax() {}
    @Override
    public void removePlayer(TicTacToePlayer player) {}
}
