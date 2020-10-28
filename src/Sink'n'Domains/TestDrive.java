package Sink

import java.util.Arrays;

/**
 * @author: Callum Jenkins
 * 03/10/2020
 * <p>
 * Class: TestDrive
 */

public class TestDrive {
    public static void main(String[] args) {
        TargetDomain domain = new TargetDomain();
        Player player1 = new Player();

        GameGrid gameboard = new GameGrid();
        
        System.out.println(Arrays.toString(GameGrid.Cells.values()));
        
        
        //GameGrid.Cells[] location = {1, 2, 3};

        //domain.setLocationCoords(location); //Locations must be vertically/horizontally adjacent



        String userGuess = "2";
        //boolean hit = domain.checkForHit(userGuess); //Return true if hit
        boolean testResult = false;
        
       /* if (hit)
        {
            testResult = true;
        }*/
        
        System.out.println(testResult);
    }
}
