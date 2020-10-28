package DijkstraDutchFlag;/*
Callum Jenkins
Title
28/09/2020 of 09, 2020
*/

import java.util.EnumMap;
import java.util.Random;

public class Balls {

    private DutchColours[] balls;
    private DutchColours[] colour;
    private EnumMap colourMap;


    /**
     * Dutch flag colours enum
     * Order is important
     */
    public enum DutchColours {
        RED, WHITE, BLUE
    }


    /**
     * Constructor:
     * Creates two arrays using enum DutchColours
     * For each ball, assign a random colour to it using a random number
     * to select the index of the enum: 1 -> RED, 2 -> WHITE, 3 -> BLUE
     * Creates a map to represent this ^
     */
    public Balls() {
        balls = new DutchColours[25];
        colour = DutchColours.values();
        Random rand = new Random();

        colourMap = new EnumMap<>(DutchColours.class);
        colourMap.put(DutchColours.RED, 0);
        colourMap.put(DutchColours.WHITE, 1);
        colourMap.put(DutchColours.BLUE, 2);

        for (int i = 0; i < balls.length; i++) {
            balls[i] = colour[rand.nextInt(colour.length)];
        }
    }


    /**
     * Overloaded constructor:
     * @param length - Sets the number of balls to sort
     */
    public Balls(int length) {
        balls = new DutchColours[length];
        colour = DutchColours.values();
        Random rand = new Random();

        colourMap = new EnumMap<>(DutchColours.class);
        colourMap.put(DutchColours.RED, 0);
        colourMap.put(DutchColours.WHITE, 1);
        colourMap.put(DutchColours.BLUE, 2);

        for (int i = 0; i < balls.length; i++) {
            balls[i] = colour[rand.nextInt(colour.length)];
        }
    }


    /**
     *
     * @return - Returns number of balls
     */
    public int GetNumberOfBalls() {
        return balls.length;
    }


    /**
     *
     * @return - Returns the map of colour -> int
     */
    public EnumMap getColourMap() {
        return this.colourMap;
    }


    /**
     *
     * @param index - The index to get the value of
     * @return - Returns the colour of a ball at the given index
     */
    public DutchColours GetValue(int index) {
        return balls[index];
    }


    /**
     * Sets a new colour to a given index
     * @param index - Index to change
     * @param value - New value of the index given
     */
    public void SetValue(int index, DutchColours value) {
        this.balls[index] = value;
    }
}
