package SinkADotCom;

import java.util.ArrayList;

/**
 * @author: Callum Jenkins
 * 06/10/2020
 * <p>
 * Class: DotCom
 */

public class DotCom {

    private ArrayList<String> locationCells;
    private String name;
    //private int[] locationCells;
    //int numberOfHits = 0;

    public void setLocationCells(ArrayList<String> locationCells) {
        this.locationCells = locationCells;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public String checkYourself(String userGuess) {
        int guess = Integer.parseInt(userGuess.substring(1, 2));
        String result = "miss";

        int index = locationCells.indexOf(userGuess);

        if (index >= 0)
        {
            locationCells.remove(index);

            if (locationCells.isEmpty())
            {
                result = "kill";
            }
            else
            {
                result = "hit";
            }

        }

        return result;
    }
}
