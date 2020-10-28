package Tutorials_Week2.Problem_1;

import java.util.Scanner;

public class Person {

    String forename;
    String surname;
    String email;
    int age;
    String mobileNo;
    Scanner kboard = new Scanner(System.in);


    public Person() {
        this.SetForename();
        this.SetSurname();
        this.SetEmail();
        this.SetAge();
        this.SetContactNumber();
    }

    public Person(String forename, String surname) {
        this.forename = forename;
        this.surname =surname;
    }

    public Person(String forename, String surname, int age) {
        this.forename = forename;
        this.surname =surname;
        this.age = age;
    }

    public void DisplayPerson() {
        System.out.println("\nName: " + forename + " " + surname);
        System.out.println("Email: " + email);
        System.out.println("Age: " + age);
        System.out.println("Mobile Number: " + mobileNo);
    }

    public void SetForename() {


        System.out.println("What is your first name?");
        forename = kboard.nextLine();
    }

    public void SetSurname() {

        System.out.println("What is your last name?");
        surname = kboard.nextLine();
    }

    public void SetEmail() {

        System.out.println("What is your email address?");
        email = kboard.nextLine();
    }

    private void SetAge() {
        String dummy = "";

        System.out.println("How old are you?");
        age = kboard.nextInt();
        dummy = kboard.nextLine();
        while (!CheckAge(age))
        {
            System.out.println("You must be 18+ to enter");
            System.out.println("How old are you?");
            age = kboard.nextInt();
            dummy = kboard.nextLine();
        }
    }

    public void SetContactNumber() {

        System.out.println("What is your mobile number?");
        mobileNo = kboard.nextLine();
    }

    public boolean CheckAge(int age) {
        boolean ofAge;

        ofAge = age >= 18;

        return ofAge;
    }
}
