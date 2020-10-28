package GuessingGame;

public class GuessingGame {

    Player p1;
    Player p2;
    Player p3;

    public void StartGame() {

                                                                             //Crete players
        p1 = new Player();
        p2 = new Player();
        p3 = new Player();

        int guessP1;
        int guessP2;
        int guessP3;

        boolean p1Correct = false;
        boolean p2Correct = false;
        boolean p3Correct = false;

                                                                            //Generate a target to guess
                                                                            //Inform player of range
        int target = (int) (Math.random()*10) + 1;
        System.out.println("I'm thinking of a number between 1 and 10");


        //Repeat until there's a winner
        //while (true)
        //{
                                                                            //Get player guesses
            System.out.println("Player 1 is guessing...");
            p1.Guess();
            System.out.println("\nPlayer 2 is guessing...");
            p2.Guess();
            System.out.println("\nPlayer 3 is guessing...");
            p3.Guess();

            guessP1 = p1.number;
            System.out.println("\nPlayer 1 guessed: " + guessP1);

            guessP2 = p2.number;
            System.out.println("Player 2 guessed: " + guessP2);

            guessP3 = p3.number;
            System.out.println("Player 3 guessed: " + guessP3);

            if (guessP1 == target) {
                p1Correct = true;
            }
            if (guessP2 == target) {
                p2Correct = true;
            }
            if (guessP3 == target) {
                p3Correct = true;
            }

                                                                            //Checks is any player guesses are correct
                                                                            //Outputs results based on which player wins
            if (p1Correct || p2Correct || p3Correct)
            {
                System.out.println("\nWe have a winner!");

                if (p1Correct)
                {
                    System.out.println("Player one got it right!");
                }
                if (p2Correct)
                {
                    System.out.println("Player two got it right!");
                }
                if (p3Correct)
                {
                    System.out.println("Player three got it right!");
                }

                System.out.println("Game over.");
                //break;
            }
            else
            {
                System.out.println("\nNo winners this time. The number to guess was: " + target + ". Try again!");
            }
        //}
    }
}
