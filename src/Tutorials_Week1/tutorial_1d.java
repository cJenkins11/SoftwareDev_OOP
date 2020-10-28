package Tutorials_Week1;

import java.util.Scanner;

public class tutorial_1d {

    public static int GetRandomNumber() {
        int randomInt;
        randomInt = (int) (Math.random() * 10) + 1;
        return randomInt;
    }

    public static int CalcTotal(int w, int x) {
        int total;
        total = w + x;
        return total;
    }

    public static boolean GetResult(int y, int z) {
        boolean win = false;

        if (y <= 21 && z <= y) {
            win = true;
        }
        return win;
    }

    public static boolean Busted(int z) {
        boolean busted = false;

        if (z > 21) {
            busted = true;
        }
        return busted;
    }

    public static int GetHouseHand() {

        int houseHand;

        houseHand = (int)(Math.random()*4 + 16);

        return houseHand;
    }

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

    public static void main(String[] args) {
        int card1;
        int card2;
        int cardTotal;
        int[][] playerHand = new int[5][21];
        boolean result;
        boolean bust = false;
        int houseTotal;
        boolean nextCard;

        for (int gameCounter = 0; gameCounter < 5; gameCounter++) {
            card1 = GetRandomNumber();
            card2 = GetRandomNumber();
            houseTotal = GetHouseHand();
            cardTotal = CalcTotal(card1, card2);

            playerHand[gameCounter][0] = card1;
            playerHand[gameCounter][1] = card2;

            System.out.println("Welcome to Pontoon, keep your hand less than 21 and beat the house hand to win!");
            System.out.println("You have drawn " + card1 + " and " + card2);

            nextCard = AnotherCard();

            for (int i = 2; i < 21; i++) {
                if (nextCard) {
                    playerHand[gameCounter][i] = GetRandomNumber();
                    System.out.println("The value of your new card is: " + playerHand[gameCounter][i]);
                    cardTotal = CalcTotal(cardTotal, playerHand[gameCounter][i]);
                    System.out.println("The total value of your cards is: " + cardTotal);

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

            System.out.println("\nDrawn cards: ");
            for (int j = 0; j < 21; j++) {
                if (playerHand[gameCounter][j] > 0) {
                    System.out.print(playerHand[gameCounter][j] + " ");
                }
            }

            if (!bust) {
                result = GetResult(cardTotal, houseTotal);

                if (result) {
                    System.out.println("\nCongratulations, you win! You beat the house hand of: " + houseTotal + "\n");
                } else {
                    System.out.println("\nUnlucky, you lose. The house beat you with a hand of: " + houseTotal + "\n");
                }

            } else {
                System.out.println("\nUnlucky, you went bust. The house beat you with a hand of: " + houseTotal + "\n");
            }

        }
    }
}