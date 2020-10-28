package Pontoon;

import java.util.Scanner;

public class Player {
    
    private int[] playerHand;


    /*
    On construction generate two cards
    */
    public Player() {
        this.playerHand = new int[2];

        for (int i = 0; i < this.playerHand.length; i ++)
        {
            //Card playerCard = new Card();
            //this.playerHand[i] = playerCard.GetValue();
        }
    }

    /*
    Return player hand
    */
    public int[] GetHand() {
        return this.playerHand;
    }

    /*
    Asks if player wants another card
    Returns true if they do
    */
    public boolean Hit() {
        Scanner kboard = new Scanner(System.in);
        char reply;
        boolean hit = false;
        boolean valid = true;

        do {
            System.out.println("\nWould you like another card? (Y)es/(N)o");
            reply = kboard.nextLine().toLowerCase().charAt(0);
            if (reply == 'y') {
                valid = true;
                hit = true;
            } else if (reply == 'n') {
                valid = true;
                hit = false;
                break;
            } else {
                System.out.println("Unknown response");
                valid = false;
            }
        } while (!valid);

        return hit;
    }

    /*
    Creates a new array with +1 length of parameter array
    */
    public void GetNewCard(int originalLength, int[] hand) {

        int[] newHand = new int[originalLength + 1];
        //Card newCard = new Card();

        for (int j = 0; j < originalLength; j ++)
        {
            newHand[j] = hand[j];
        }

        //newHand[originalLength] = newCard.GetValue();

        this.playerHand = newHand;
    }

    /*
    Calculates and returns player total
    */
    public int GetPlayerTotal() {
        int total = 0;

        for (int k = 0; k < this.playerHand.length; k ++)
        {
            total += this.playerHand[k];
        }

        return total;
    }

    /*
    Checks if player is bust, returns true if bust
    */
    public boolean IsBust() {
        boolean busted;

        busted = GetPlayerTotal() > 21;

        return busted;
    }

    /*
    Asks if player wants to play again
    Returns true if they do
    */
    public boolean PlayAgain() {
        boolean goAgain = false;
        char decision;
        boolean valid = true;
        Scanner kboard = new Scanner(System.in);

        do {
            System.out.println("\nWould you like to play again? (Y)es/(N)o");
            decision = kboard.nextLine().toLowerCase().charAt(0);
            if (decision == 'y') {
                valid = true;
                goAgain = true;
            } else if (decision == 'n') {
                valid = true;
                goAgain = false;
                break;
            } else {
                System.out.println("Unknown response");
                valid = false;
            }
        } while (!valid);

        return goAgain;
    }
}
