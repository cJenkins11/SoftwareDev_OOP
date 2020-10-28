package SinkADotCom;

import java.util.ArrayList;

/**
 * @author: Callum Jenkins
 * 06/10/2020
 * <p>
 * Class: DotComBust
 */

public class DotComBust {

    private GameHelper helper = new GameHelper();
    private ArrayList<DotCom> targetList = new ArrayList<DotCom>();
    private int numberOfGuesses = 0;

    private void setUpGame() {
        DotCom one = new DotCom();
        DotCom two = new DotCom();
        DotCom three = new DotCom();

        one.setName("pets.com");
        two.setName("domainos.com");
        three.setName("bookface.co.uk");

        targetList.add(one);
        targetList.add(two);
        targetList.add(three);

        System.out.println("Your goal is to sink all three dot coms.");
        System.out.println(one.getName() + " " + two.getName() + " " + three.getName());
        System.out.println("Try to sink them all in the fewest guesses.");

        for (DotCom dotComToSet : targetList)
        {
            ArrayList<String> newLocation = helper.placeDotCom(3);
            dotComToSet.setLocationCells(newLocation);
        }
    }

    private void startPlaying() {
        while (!targetList.isEmpty())
        {
            String userGuess = helper.getUserInput("Enter a guess");
            checkUserGuess(userGuess);
        }
        finishGame();
    }

    private void checkUserGuess(String userGuess) {
        numberOfGuesses++;
        String result = "miss";
        for (DotCom dotComToTest : targetList) {
            result = dotComToTest.checkYourself(userGuess);
            if (result.equals("hit")) {
                break;
            }
            if (result.equals("kill")) {
                targetList.remove(dotComToTest);
                break;
            }
        } // close for
        System.out.println(result);
    }

    private void finishGame() {
        System.out.println("All Dot Coms are dead! Your stock is now worthless.");
        if (numberOfGuesses <= 18) {
            System.out.println("It only took you " + numberOfGuesses + " guesses.");
            System.out.println(" You got out before your options sank.");
        } else {
            System.out.println("Took you long enough. " + numberOfGuesses + " guesses.");
            System.out.println("Fish are dancing with your options");
        }
    }

    public static void main(String[] args) {
        DotComBust game = new DotComBust();
        game.setUpGame();
        game.startPlaying();
    }

}
