package SinkADomain;

import java.util.Map;
import java.util.Scanner;

/**
 * @author: Callum Jenkins
 * 03/10/2020
 * <p>
 * Class: PlayerGuess
 */

public class Player {

    private GameGrid.Cells playerGuess;
    private TargetDomain domain;
    private Map playerFleet;


    public void guess() {
        setPlayerGuess();
    }

    public void setPlayerGuess(GameGrid.Cells playerGuess) {
        this.playerGuess = playerGuess;
    }

    public void setPlayerGuess() {
        GameGrid.Cells cellGuess;
        String playerGuess;
        Scanner kboard = new Scanner(System.in);

        System.out.println("Commander! What cell do we attack next!?");
        System.out.println("INPUT TARGET: ");
        playerGuess = kboard.next();

        //if (playerGuess == cellGuess)

        //this.playerGuess = cellGuess;
    }


    public GameGrid.Cells getPlayerGuess() {
        return this.playerGuess;
    }
}
