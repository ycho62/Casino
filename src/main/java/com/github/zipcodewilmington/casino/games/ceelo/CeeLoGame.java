package com.github.zipcodewilmington.casino.games.ceelo;




import com.github.zipcodewilmington.casino.games.GameInterface.GamblingGame;


import java.util.*;


public class CeeLoGame implements GamblingGame<CeeLoPlayer> {
    Dice dice = new Dice();
    Scanner scanner = new Scanner(System.in);
    private Map<CeeLoPlayer, Integer> bets = new HashMap<>();
    private int maxPartySize;
    private Map<CeeLoPlayer, Boolean> winLose = new HashMap<>();
    private Map<CeeLoPlayer, int[]> assignRoll = new HashMap<>();
    private Map<CeeLoPlayer, Integer> playerRollValue = new HashMap<>();

    private Map<CeeLoPlayer, Integer> assignRollValue;
    private Map<CeeLoPlayer, Boolean> tieFlag;
    private Map<CeeLoPlayer, Boolean> autoWinFlag;
    private Map<CeeLoPlayer, Boolean> autoLoseFlag;
    private Map<CeeLoPlayer, Boolean> nonValidFlag;
    private boolean exitFlag = false;

    @Override
    public void play() {
        while (!exitFlag) {

                String input;
                System.out.println("Welcome to Cee-Lo");
                setBets();

                for (CeeLoPlayer s : bets.keySet()) {
//                    getRoll(s);

                }

                winCondition(playerRollValue.keySet().toArray(new CeeLoPlayer[2])[0], playerRollValue.keySet().toArray(new CeeLoPlayer[2])[1]);

                    // checking rollvalue in playerhand also figure out how to get 2 players
//compare int value of roll to other player.
//check against winnningCondition


            }
        }


    public CeeLoGame() {
            }



    @Override
    public void setBets() {
        Integer bet = 0, walletBalance;
        for (CeeLoPlayer s: bets.keySet()){
            walletBalance = s.getBalance();
            try{
                System.out.println("Hello " + s.getPerson().getName() + ", how much would you like to bet?");
                System.out.println();
                bet = scanner.nextInt();
                if (bet>walletBalance){
                    System.out.println("Bet exceeds wallet balance, try again.");
                    continue;
                }
            } catch (InputMismatchException e){
                System.out.println("Not a number, try again.");
                continue;
            }
            bets.put(s, bet);
            s.applyBet(bet);
        }
    }

    public int getRoll(CeeLoPlayer player, String playerChoice) {
        int rollNumberValue = 0;
        Scanner scanner = new Scanner(System.in);
        while (this.getValueToRoll()!=0) {
            System.out.println("Please 'roll' to get your dice roll ");
//            String input = scanner.nextLine();

            if (playerChoice.equals("roll")) {
                rollNumberValue = getValueToRoll();

//                if(checkIfValidRoll(dice.rollDice())) {
//                    System.out.println("Your roll was " + dice.rollDice());
////                    assignRoll.put(player, Dice.rollDice());
//                    player.setRollValue(getValueToRoll(dice.rollDice()));// assigns roll value to a valid roll.
//                }
//                break;
//            } else System.out.println("Not a valid input.");
//                break;
            }

        }
        return rollNumberValue;
    }

    //    have all dice combinations resolve to a single number
//    Invalid rolls will result in 0 or re-roll
//    Rolls with dice1 and dice2 have same values and dice 3 has a different value, result = dice 3
//    Rolls with all three dice that are the same = 6 + the dice value.

    public int getValueToRoll() {
        int rollValue = 0;// if roll value is 0 reroll
            dice.rollDice();
            if (dice.getRollDice(0) == 4 && dice.getRollDice(1) == 5 && dice.getRollDice(2) == 6) {///automatic win break out of game pay winnings
                return rollValue = 13;

            }else if(dice.getRollDice(0) == 1 && dice.getRollDice(1) == 2 && dice.getRollDice(2) == 3) {///automatic lose break out of game lose bet.
                return rollValue = -1;

            }else if (dice.getRollDice(0)==(dice.getRollDice(1)) && dice.getRollDice(0)==(dice.getRollDice(2))){
                return rollValue = dice.getRollDice(0) + 6;

            }else if (dice.getRollDice(0)==(dice.getRollDice(1))){
                return rollValue = dice.getRollDice(2);

            }else if (dice.getRollDice(0)==(dice.getRollDice(2))){
                return rollValue = dice.getRollDice(1);

            }else if (dice.getRollDice(1)==(dice.getRollDice(2))){
                return rollValue = dice.getRollDice(0);
            }

        return rollValue;
    }

    @Override
    public void distributeWinningsToWinners(CeeLoPlayer winner) {winner.addWinning(bets.get(winner));}



//    public boolean checkIfValidRoll(int[] diceArray) {// if non valid
//         Arrays.sort(diceArray);
//            if (diceArray[0] == 4 && diceArray[1] == 5 && diceArray[2] == 6) {///automatic win break out of game pay winnings
//                return true;
//            } else if (diceArray[0] == 1 && diceArray[1] == 2 && diceArray[2] == 3) {///automatic lose break out of game lose bet.
//                return true;
//            } else if (diceArray[0] == (diceArray[1]) && diceArray[0] == (diceArray[2])) {// triple
//                return true;
//            } else if (diceArray[0] == diceArray[1] && diceArray[0] != diceArray[2]) {//
//                return true;
//            } else if (diceArray[1] == diceArray[2] && diceArray[1] != diceArray[0]) {
//                return true;
//            } else {
//                return false;
//            }

//    }
    public void winCondition(CeeLoPlayer player1, CeeLoPlayer player2) {
        int ceeLoPlayer1 = playerRollValue.get(player1);
        int ceeLoPlayer2 = playerRollValue.get(player2);

        if (ceeLoPlayer1 == 13) {
            System.out.println("Player 1 rolled a 4, 5, 6! It's an automatic win!");
            //

        } else if (ceeLoPlayer2 == 13) {
            System.out.println("Player 2 rolled a 4, 5 6! It's an automatic win!");

        } else if (ceeLoPlayer1 == -1) {
            System.out.println("Player 1 rolled a 1, 2, 3! It's an automatic lose!");

        } else if (ceeLoPlayer2 == -1) {
            System.out.println("Player 2 rolled a 1, 2, 3! It's an automatic lose");

        } else if (ceeLoPlayer1 > ceeLoPlayer2) {
            System.out.println("Player 1 has won! with a " + Arrays.toString(new int[]{ceeLoPlayer1}));

        } else if (ceeLoPlayer2 > ceeLoPlayer1) {
            System.out.println("Player 2 has won! with a " + Arrays.toString(new int[]{ceeLoPlayer2}));

        } else if (ceeLoPlayer1 == ceeLoPlayer2) {
            System.out.println("It is a tie! Double bets and re-roll!");

            //re-roll and put through roll results again

        }
    }

    public void afterRolls (){
        for (CeeLoPlayer s: bets.keySet()) {
            winConditionCheck(s);
            if (winLose.get(s))
                distributeWinningsToWinners(s);
        }
    }

    @Override
    public void setPlayerMax() {
        this.maxPartySize = 2;
    }

    @Override
    public void addPlayer(CeeLoPlayer player) {
        this.bets.put(player, 0);
    }

    @Override
    public void removePlayer(CeeLoPlayer player) {
        this.bets.remove(player);
    }

    @Override
    public void winConditionCheck(CeeLoPlayer player) {

    }

    @Override
    public void exit() {
    }

}
