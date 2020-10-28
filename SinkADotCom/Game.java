package SinkADotCom;

/**
 * @author: Callum Jenkins
 * 06/10/2020
 * <p>
 * Class: Game
 */

public class Game {

    public static void main(String[] args) {
        int numberOfGuesses = 0;
        GameHelper helper = new GameHelper();
        
        SimpleDotCom theDotCom = new SimpleDotCom();
        
        int randomNum = (int) (Math.random() * 5);
        
        int[] locations = {randomNum, randomNum + 1, randomNum + 2};
        theDotCom.setLocationCells(locations);
        
        boolean isAlive = true;
        
        while(isAlive) 
        {
            String guess = helper.getUserInput("Enter a nmuber");
            String result = theDotCom.checkYourself(guess);
            numberOfGuesses++;
            if (result.equals("kill"))
            {
                isAlive = false;
                System.out.println("You took " + numberOfGuesses + " guesses");
            }
        }
    }
}
