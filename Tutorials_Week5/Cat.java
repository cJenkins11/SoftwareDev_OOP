package Tutorials_Week5;

import java.io.IOException;

/**
 * @author: Callum Jenkins
 * 07/10/2020
 * <p>
 * Class: Cat
 */

public class Cat {

    private String catName;
    private String catBreed;
    private int catAge;

    public Cat(String catName, String catBreed, int catAge) {
        setCatDetails(catName, catBreed, catAge);
    }

    public Cat() {
        setCatName();
        setCatBreed();
        setCatAge();
    }

    public void setCatName() {
        String catName = "";
        Utilities scanner = new Utilities();
        catName = scanner.getUserInput("Please enter the name of the cat: ");
        this.catName = catName;
    }

    public void setCatBreed() {
        String catBreed = "";
        Utilities scanner = new Utilities();
        catBreed = scanner.getUserInput("Please enter the breed of the cat: ");
        this.catBreed = catBreed;
    }

    public void setCatAge() {
        int catAge = 0;
        Utilities scanner = new Utilities();
        catAge = Integer.parseInt(scanner.getUserInput("Please enter the age of the cat: "));
        this.catAge = catAge;
    }

    public void setCatDetails(String catName, String catBreed, int catAge) {
        this.catName = catName;
        this.catBreed = catBreed;
        this.catAge = catAge;
    }

    public void displayDetails() throws IOException {
        System.out.println("Cats name is: " + catName);
        System.out.println("Cats breed is: " + catBreed);
        System.out.println("Cats age is: " + catAge);
    }

}
