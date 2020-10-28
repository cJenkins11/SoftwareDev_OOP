package StarWarsNameGenerator;/*
Callum Jenkins
Title
28/09/2020 of 09, 2020
*/

import java.util.Scanner;

public class User {

    private String forename;
    private String surname;
    private String maidenName;
    private String placeOfBirth;
    public Scanner kboard;

    public User() {
        SetForename();
        SetSurname();
        SetMaidenName();
        SetPlaceOfBirth();
    }

    public User(String forename, String surname, String maidenName, String placeOfBirth){
        this.forename = forename;
        this.surname = surname;
        this.maidenName = maidenName;
        this.placeOfBirth = placeOfBirth;
    }

    public String GetForename() {
        return this.forename;
    }

    public void SetForename() {
        String forename;
        kboard = new Scanner(System.in);

        System.out.println("What is your forename?");
        forename = kboard.nextLine();

        this.forename = forename;
    }

    public String GetSurname() {
        return this.surname;
    }

    public void SetSurname() {
        String surname;
        kboard = new Scanner(System.in);

        System.out.println("What is your surname?");
        surname = kboard.nextLine();

        this.surname = surname;
    }

    public String GetMaidenName() {
        return this.maidenName;
    }

    public void SetMaidenName() {
        String maidenName;
        kboard = new Scanner(System.in);

        System.out.println("What is your mothers maiden name?");
        maidenName = kboard.nextLine();

        this.maidenName = maidenName;
    }

    public String GetPlaceOfBirth() {
        return this.placeOfBirth;
    }

    public void SetPlaceOfBirth() {
        String placeOfBirth;
        kboard = new Scanner(System.in);

        System.out.println("Where were you born?");
        placeOfBirth = kboard.nextLine();

        this.placeOfBirth = placeOfBirth;
    }

}
