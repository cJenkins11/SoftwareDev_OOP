package GuessingGame;

import java.util.Scanner;

public class Player {
    int number = 0;

    public void Guess() {
        Scanner kboard = new Scanner(System.in);

        do {
            System.out.println("What would you like to guess?");
            number = kboard.nextInt();

            if (number < 1 || number > 10) {
                System.out.println("\nYour guess must be a number from 1 - 10");

            }

        } while (number < 1 || number > 10);

        System.out.println("I'm guessing: " + number);
    }

}
