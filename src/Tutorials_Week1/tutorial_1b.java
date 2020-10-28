package Tutorials_Week1;

import java.util.Scanner;

public class tutorial_1b {


    public static int getRandomNumber() {
        int randomInt;
        randomInt = (int) (Math.random() * 10) + 1;
        return randomInt;
    }

    public static int calcTotal(int x, int y) {
        int total;
        total = x + y;
        return total;
    }

    public static boolean getResult(int z) {
        boolean win = false;

        if ((z >= 19) && (z <= 21)) {
            win = true;
        }
        return win;
    }

    public static boolean busted(int z) {
        boolean busted = false;

        if (z >= 21) {
            busted = true;
        }
        return busted;
    }

    public static void main(String[] args) {
        int card_1;
        int card_2;
        int card_total;
        int new_card;
        char user_choice;
        boolean result;
        boolean bust;

        Scanner kboard = new Scanner(System.in);

        card_1 = getRandomNumber();
        card_2 = getRandomNumber();

        card_total = calcTotal(card_1, card_2);
        System.out.println("You have drawn " + card_1 + " and " + card_2);
        result = getResult(card_total);
        bust = busted(card_total);

        if (result) {
            System.out.println("Congratulations, you win!");
        } else if (bust) {
            System.out.println("Unlucky, you lose.");
        } else {
            System.out.println("Would you like another card? (Y)es/(N)o");
            user_choice = kboard.nextLine().charAt(0);

            switch (user_choice) {
                case 'y':
                case 'Y': {
                    do {
                        new_card = getRandomNumber();
                        System.out.println("The value of your new card is " + new_card);
                        card_total += new_card;

                        System.out.println("The total value of your cards is " + card_total);
                        result = getResult(card_total);
                        bust = busted(card_total);

                        if (result) {
                            System.out.println("Congratulations, you win!");
                            break;
                        } else if (bust) {
                            System.out.println("Unlucky, you lose.");
                            break;
                        } else {
                            System.out.println("Would you like another card? (Y)es/(N)o");
                            user_choice = kboard.nextLine().charAt(0);
                        }
                    }
                    while ((user_choice == 'y') || (user_choice == 'Y'));
                    break;
                }
                case 'n':
                case 'N': {
                    System.out.println("The total value of your cards is " + card_total);
                    result = getResult(card_total);
                    bust = busted(card_total);

                    if (result) {
                        System.out.println("Congratulations, you win!");
                        break;
                    } else if (!result || bust) {
                        System.out.println("Unlucky, you lose.");
                        break;
                    }
                    break;
                }

                default: {
                    System.out.println("Invalid response!");
                    break;
                }


            }
        }
    }
}