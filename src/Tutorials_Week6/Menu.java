package Tutorials_Week6;

/**
 * @author: Callum Jenkins
 * 24/10/2020
 * <p>
 * Class: Menu
 */

public class Menu {

    private int menuChoice;

    public Menu() {
        displayMenu();
        setMenuChoice();
    }

    public void displayMenu() {
        System.out.println("\n(1) Add student to class list");
        System.out.println("(2) View full class list");
        System.out.println("(3) Display student");
        System.out.println("(4) Display students that passed");
        System.out.println("(5) Display pass rate");
        System.out.println("(6) Remove a student from class list");
        System.out.println("(7) Exit\n");
    }

    public void setMenuChoice() {
        Utilities scanner = new Utilities();
        do 
            {
                menuChoice = Integer.parseInt(scanner.getUserInput("Please enter a menu choice 1-7: "));
                if (menuChoice < 1 || menuChoice > 7)
                {
                    System.out.println("Only options 1 - 7 are accepted, try again");
                }
            } 
        while (menuChoice < 1 || menuChoice > 7);
    }

    public int getMenuChoice() {
        return menuChoice;
    }

}
