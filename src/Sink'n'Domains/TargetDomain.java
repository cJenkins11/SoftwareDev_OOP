package Sink

/**
 * @author: Callum Jenkins
 * 03/10/2020
 * <p>
 * Class: TargetDomain
 */

public class TargetDomain extends GameGrid{

    private Cells[] location;

    /*public boolean checkForHit(String userGuess) {
        boolean hit;
        for (int i = 0; i < location.length; i++)
        {
            *//*if (location[i] == )
            {

            }*//*
        }

    }*/
    public TargetDomain() {
        setLocationCoords();
    }

    /**
     * Sets location of a target domain
     * @param location - Array of coordinates
     *                 - Must be vertically/horizontally adjacent
     */
    public void setLocationCoords(Cells[] location) {

        this.location = location;
    }
}
