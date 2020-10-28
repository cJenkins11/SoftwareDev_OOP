package Tutorials_Week1;

import java.util.Scanner;

public class tutorial_1c {

    public static int getRandomNumber() {
        int randomInt;
        randomInt = (int) (Math.random() * 10) + 1;
        return randomInt;
    }

    public static int calcTotal(int w, int x) {
        int total;
        total = w + x;
        return total;
    }

    public static boolean getResult(int y, int z) {
        boolean win = false;

        if (y <= 21 && z < y) {
            win = true;
        }
        return win;
    }

    public static boolean busted(int z) {
        boolean busted = false;

        if (z > 21) {
            busted = true;
        }
        return busted;
    }

    public static int getHouseHand() {
        int card1;
        int card2;
        int houseStartingHand;
        int newHouseCard;
        int houseHand = 0;

        card1 = getRandomNumber();
        card2 = getRandomNumber();

        houseStartingHand = calcTotal(card1, card2);

        do {
            if (houseStartingHand < 16) {
                newHouseCard = getRandomNumber();
                houseHand = houseStartingHand + newHouseCard;
            }
        } while (houseHand < 16 && houseHand <= 21);

        return houseHand;
    }

    public static boolean anotherCard() {
        boolean hit = true;
        char decision;

        Scanner kboard = new Scanner(System.in);

        System.out.println("Would you like another card? (Y)es/(N)o");
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
        int card_1;
        int card_2;
        int card_total;
        int new_card;
        boolean result;
        boolean bust;
        int houseTotal;
        boolean nextCard;

        card_1 = getRandomNumber();
        card_2 = getRandomNumber();
        houseTotal = getHouseHand();
        card_total = calcTotal(card_1, card_2);

        System.out.println("Welcome to Pontoon, keep your hand less than 21 and beat the house hand to win!");
        System.out.println("You have drawn " + card_1 + " and " + card_2);

        bust = busted(card_total);

        if (bust) {
            System.out.println("Unlucky, you went bust. The house beat you with a hand of: " + houseTotal);
        } else {
            nextCard = anotherCard();

            do {
                if (nextCard) {
                    new_card = getRandomNumber();
                    System.out.println("The value of your new card is " + new_card);
                    card_total += new_card;
                    System.out.println("The total value of your cards is " + card_total);
                }

                bust = busted(card_total);

                if (bust) {
                    //System.out.println("Unlucky, you went bust. The house beat you with a hand of: " + houseTotal);
                    break;
                } else {
                    nextCard = anotherCard();
                }

            } while (nextCard);

            if (!bust)
            {
                result = getResult(card_total, houseTotal);

                if (result) {
                    System.out.println("Congratulations, you win! You beat the house hand of: " + houseTotal);
                } else {
                    System.out.println("Unlucky, you lose. The house beat you with a hand of: " + houseTotal);
                }

            } else
            {
                System.out.println("Unlucky, you went bust. The house beat you with a hand of: " + houseTotal);
            }
        }
    }
}
