package Pontoon;

import java.util.Arrays;

public class GameTable {

    public static void main(String[] args) {

        Player schmuck;
        Dealer house;

        System.out.println("Welcome player!");

        do {
            /*
            Create dealer and player objects.
            Create starting hand
            */
            schmuck = new Player();
            house = new Dealer();

            //Display values
            System.out.println("\nYour hand: " + Arrays.toString(schmuck.GetHand()));
            System.out.println("Your total: " + schmuck.GetPlayerTotal());

            do {
                /*
                Ask player if they want another card
                If they want another card add it to player hand
                Display new hand
                */

                if (schmuck.Hit())
                {
                    schmuck.GetNewCard(schmuck.GetHand().length, schmuck.GetHand());
                    System.out.println("\nYour hand: " + Arrays.toString(schmuck.GetHand()));
                    System.out.println("Your total: " + schmuck.GetPlayerTotal());
                }
                else {
                    System.out.println("You chose to stick");
                    break;
                    }

                //Loop if player isn't bust
            } while (!schmuck.IsBust());

            /*
            Check if player is bust, display appropriate result
            else compare house hand to player hand, display appropriate result
            */
            if (schmuck.IsBust())
            {
                System.out.println("\nUnlucky, you went bust with a hand of: " + schmuck.GetPlayerTotal());
                System.out.println("The house beat you with a hand of: " + house.GetHouseHand());
            }
            else {

                if (house.GetResult(schmuck.GetPlayerTotal()))
                {
                    System.out.println("\nCongratulations, you win with a hand of: " + schmuck.GetPlayerTotal());
                    System.out.println("The house had a hand of: " + house.GetHouseHand());
                }
                else
                    {
                        System.out.println("\nUnlucky, you had a hand of: " + schmuck.GetPlayerTotal());
                        System.out.println("The house beat you with a hand of: " + house.GetHouseHand());
                    }
            }

            //Loop if user wants another game
        } while (schmuck.PlayAgain());

        System.out.println("Goodbye!");
    }
}
