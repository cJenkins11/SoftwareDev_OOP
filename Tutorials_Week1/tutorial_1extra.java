package Tutorials_Week1;

import java.util.Scanner;

public class tutorial_1extra {

    //returns int 1-10
    public static int GetRandomNumber() {
        int randomInt;
        randomInt = (int) (Math.random() * 10) + 1;
        return randomInt;
    }

    //returns sum of two ints
    public static int CalcTotal(int w, int x) {
        int total;
        total = w + x;
        return total;
    }

    //Returns a win based on pontoon rules. Player hand > House hand AND Player hand <= 21
    public static boolean GetResult(int y, int z) {
        boolean win = false;

        if (y <= 21 && z <= y) {
            win = true;
        }
        return win;
    }

    //Returns busted boolean if player hand > 21
    public static boolean Busted(int z) {
        boolean busted = false;

        if (z > 21) {
            busted = true;
        }
        return busted;
    }

    //returns int 16-20
    public static int GetHouseHand() {

        int houseHand;

        houseHand = (int)(Math.random()*4 + 16);

        return houseHand;
    }

    //returns boolean that indicates player wants another card
    public static boolean AnotherCard() {
        boolean hit = true;
        char decision;

        Scanner kboard = new Scanner(System.in);

        System.out.println("\nWould you like another card? (Y)es/(N)o");

        decision = kboard.nextLine().charAt(0);

        switch (decision) {

            case 'Y':
            case 'y': {
                hit = true;
                break;
            }

            case 'N':
            case 'n': {
                hit = false;
                break;
            }

            default: {
                System.out.println("Unknown response");
                break;
            }
        }

        return hit;
    }

    //returns a percentage of games won
    public static double PercentWins(int wins, int loses) {
        double winPercentage;
        double totalGames;

        totalGames = wins + loses;

        winPercentage = (wins / totalGames) * 100;

        return winPercentage;
    }

    public static void main(String[] args) {
        int card1;
        int card2;
        int cardTotal;
        int[][] playerHand = new int[5][21];
        int[] drawnCards = new int[21];
        boolean result;
        boolean bust = false;
        int houseTotal;
        boolean nextCard;
        double winPercent;
        int wins = 0;
        int loses = 0;

        //Loop for 5 games
        for (int gameCounter = 0; gameCounter < 5; gameCounter++) {

            //Setup starting hands
            card1 = GetRandomNumber();
            card2 = GetRandomNumber();
            houseTotal = GetHouseHand();
            cardTotal = CalcTotal(card1, card2);

            //Assign cards to player hand array for current game
            playerHand[gameCounter][0] = card1;
            playerHand[gameCounter][1] = card2;

            System.out.println("Welcome to Pontoon, keep your hand less than 21 and beat the house hand to win!");
            System.out.println("You have drawn " + card1 + " and " + card2);

            nextCard = AnotherCard();

            //Starting at index 2 (3rd card) ask player if they want another card
            for (int i = 2; i < 21; i++) {
                if (nextCard) {

                    //If player wants another card generate and insert into player hand array
                    playerHand[gameCounter][i] = GetRandomNumber();
                    System.out.println("The value of your new card is: " + playerHand[gameCounter][i]);
                    cardTotal = CalcTotal(cardTotal, playerHand[gameCounter][i]);
                    System.out.println("The total value of your cards is: " + cardTotal);

                    //If player hand > 21, break out of game loop, GAME OVER
                    bust = Busted(cardTotal);

                    if (bust) {
                        break;
                    }

                    nextCard = AnotherCard();
                } else
                {
                    break;
                }
            }

            //Loop for drawn cards. Checks for values > 0 in array and prints
            System.out.println("\nDrawn cards: ");
            for (int j = 0; j < 21; j++) {
                if (playerHand[gameCounter][j] > 0) {
                    drawnCards[playerHand[gameCounter][j]-1]++;
                    System.out.print(playerHand[gameCounter][j] + " ");
                }
            }

            //Checks results of game
            if (!bust) {
                result = GetResult(cardTotal, houseTotal);

                if (result) {
                    //if a win +1 to win counter
                    System.out.println("\nCongratulations, you win! You beat the house hand of: " + houseTotal + "\n");
                    wins++;
                } else {
                    //if a loss +1 to loss counter
                    System.out.println("\nUnlucky, you lose. The house beat you with a hand of: " + houseTotal + "\n");
                    loses++;
                }

            } else {
                System.out.println("\nUnlucky, you went bust. The house beat you with a hand of: " + houseTotal + "\n");
                loses++;
            }

        }

        //Win rate of the games
        winPercent = PercentWins(wins, loses);
        System.out.println("You won " + winPercent + "% of your games!");
        System.out.println("Histogram of drawn cards: ");

        //Histogram loop
        //For range 10 (max number of card)
        for (int l = 0; l < 10; l++)
        {
            //Print line with number
            System.out.print((l+1) + ": ");
            if (drawnCards[l] > 0)
            {
                //For each number above drawn in game print *
                for(int m = 0; m < drawnCards[l]; m++)
                {
                    System.out.print("*");
                }
            }
            System.out.print("\n");
        }

    }
}