package Tutorials_Week5;

import java.io.IOException;

/**
 * @author: Callum Jenkins
 * 07/10/2020
 * <p>
 * Class: Driver
 */

public class Driver {

    public static void main(String[] args) throws IOException {
        /*Cat cat1 = new Cat("Hamish", "Fat White", 21);
        cat1.displayDetails();
        System.out.println("");
        Kitten k1 = new Kitten("Hamish mk.2", "Fat Grey", 1, "Blue", 25);
        k1.displayDetails();
        Kitten k2 = new Kitten();
        k2.displayDetails();*/

        /*Person person1 = new Person("Riley", "Home", 1);
        Person person2 = new Person();

        System.out.println("\nPerson 1");
        person1.displayDetails();
        System.out.println("\nHappy birthday, " + person1.getName() + "!");
        person1.setAge(person1.getAge() + 1);
        person1.displayDetails();

        System.out.println("\nPerson 2");
        person2.displayDetails();*/

        /*Stock item1 = new Stock(100, "Red Socks", 100);
        Stock item2 = new Stock(101, "Blue Socks", 90);
        Stock item3 = new Stock(102, "Green Socks", 50);

        System.out.println("\nStock\n");
        item1.displayAllDetails();
        System.out.println("");
        item2.displayAllDetails();
        System.out.println("");
        item3.displayAllDetails();*/

        Nondegree undergrad1 = new Nondegree();
        undergrad1.displayDetails();

        Nondegree undergrad2 = new Nondegree(25, "33 HomeAddress Street", "HND", "Mrs Teach");
        undergrad2.displayDetails();
        undergrad2.setAddress();
        undergrad2.displayDetails();

    }
}
