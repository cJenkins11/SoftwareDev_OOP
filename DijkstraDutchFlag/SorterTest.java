package DijkstraDutchFlag;

import java.util.Scanner;

/**
 * @author: Callum Jenkins
 * 02/10/2020
 * <p>
 * Class: SorterTest
 */

public class SorterTest {

    Balls chefsChocolatyUnsortedBalls;
    Sorter sorter;

    public SorterTest() {
        chefsChocolatyUnsortedBalls = new Balls(chooseTestLength());
        sorter = new Sorter(chefsChocolatyUnsortedBalls);
    }

    public int chooseTestLength() {
        int choice;
        Scanner kboard = new Scanner(System.in);

        System.out.println("How many balls would you like to sort?");
        choice = kboard.nextInt();
        kboard.close();

        return choice;
    }

    public void runTest() {
        sorter.sort();
        sorter.displayArray();
    }

    public static void main(String[] args) {
        SorterTest test = new SorterTest();
        test.runTest();
    }
}
