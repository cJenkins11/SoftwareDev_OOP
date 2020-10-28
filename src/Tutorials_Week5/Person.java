package Tutorials_Week5;

/**
 * @author: Callum Jenkins
 * 07/10/2020
 * <p>
 * Class: Person
 */

public class Person {

    private String name;
    protected String address;
    private int age;

    public Person(String name, String address, int age) {
        this.name = name;
        this.address = address;
        this.age = age;
    }

    public Person() {
        setName();
        setAddress();
        setAge();
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setName() {
        String name = "";
        Utilities scanner = new Utilities();
        name = scanner.getUserInput("Please enter this persons name: ");
        this.name = name;
    }


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public void setAddress() {
        String address = "";
        Utilities scanner = new Utilities();
        address = scanner.getUserInput("Please enter this persons address: ");
        this.address = address;
    }


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    public void setAge() {
        int age = 0;
        Utilities scanner = new Utilities();
        age = Integer.parseInt(scanner.getUserInput("Please enter the age of this person: "));
        this.age = age;
    }

    public void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("Address: " + address);
        System.out.println("Age: " + age);
    }
}
