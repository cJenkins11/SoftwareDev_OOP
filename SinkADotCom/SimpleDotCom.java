package SinkADotCom;

/**
 * @author: Callum Jenkins
 * 05/10/2020
 * <p>
 * Class: SimpleDotCom
 */

public class SimpleDotCom {

    private int[] locationCells;
    int numberOfHits = 0;

    public void setLocationCells(int[] locationCells) {
        this.locationCells = locationCells;
    }

    public String checkYourself(String userGuess) {
        int guess = Integer.parseInt(userGuess);
        String result = "miss";
        for (int cell : locationCells)
        {
            if (guess == cell)
            {
                result = "hit";
                numberOfHits++;
                break;
            }
        }

        if (numberOfHits == locationCells.length)
        {
            result = "kill";
        }

        System.out.println(result);
        return result;
    }
}
