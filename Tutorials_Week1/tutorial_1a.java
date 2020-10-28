package Tutorials_Week1;

import java.util.Scanner;

public class tutorial_1a{

        public static void main(String[] args)
        {
            char user_choice;
            char user_choice2;
            int card_1;
            int card_2;
            int new_card;
            int card_total;
            boolean add_card = false;

            Scanner kboard = new Scanner (System.in);

            card_1 = (int)(Math.random()*10) + 1;
            card_2 = (int)(Math.random()*10) + 1;

            card_total = card_1 + card_2;
            System.out.println("You have drawn " + card_1 + " and " + card_2);

            System.out.println("Would you like another card? (Y)es/(N)o");
            user_choice = kboard.nextLine().charAt(0);

            switch(user_choice)
            {
                case 'y':
                case 'Y': {do
                {
                    new_card = (int)(Math.random()*10) + 1;
                    System.out.println("The value of your new card is " + new_card);
                    card_total += new_card;
                    System.out.println("The total value of your cards is " + card_total);

                    if (card_total > 21)
                    {
                        break;
                    }
                    System.out.println("Would you like another card? (Y)es/(N)o");
                    user_choice2 = kboard.nextLine().charAt(0);

                    switch (user_choice2)
                    {
                        case 'y':
                        case 'Y': {add_card = true; break;}

                        case 'n':
                        case 'N': {add_card = false; break;}

                        default : {System.out.println("Sorry I don't understand"); break;}
                    }
                } while (add_card == true);
                    break;}

                case 'n':
                case 'N': {break;}

                default : {System.out.println("Sorry I don't understand"); break;}
            }

            if ((card_total >= 19) && (card_total <= 21))
            {
                System.out.println("Congratulations, you win!");
            } else
            {
                System.out.println("Unlucky, you lose.");
            }
            kboard.close();
        }
}


