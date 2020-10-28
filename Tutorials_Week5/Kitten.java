package Tutorials_Week5;

import java.io.IOException;

/**
 * @author: Callum Jenkins
 * 07/10/2020
 * <p>
 * Class: Kitten
 */

public class Kitten extends Cat {
    private String eyeColour;
    private double length;

    public Kitten(String catName, String catBreed, int catAge, String eyeColour, double length) {
        super(catName, catBreed, catAge);
        this.eyeColour = eyeColour;
        this.length = length;
    }

    public Kitten() {
        setEyeColour();
        setLength();
    }

    public String getEyeColour() {
        return eyeColour;
    }

    public void setEyeColour(String eyeColour) {
        this.eyeColour = eyeColour;
    }
    public void setEyeColour() {
        String eyeColour = "";
        Utilities scanner = new Utilities();
        eyeColour = scanner.getUserInput("What colour is the kittens eyes: ");
        this.eyeColour = eyeColour;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }
    public void setLength() {
        Double length;
        Utilities scanner = new Utilities();
        length = Double.parseDouble(scanner.getUserInput("How long is the kitten: "));
        this.length = length;
    }

    public void displayDetails() throws IOException {
        super.displayDetails();
        System.out.println("The kitten has " + eyeColour + " eyes");
        System.out.println("The kitten is: " + length + "cm");
    }
}

