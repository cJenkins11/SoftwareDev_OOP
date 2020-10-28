package StarWarsNameGenerator;

/**
@author Callum Jenkins
Title
28/09/2020 of 09, 2020
*/

public class Generator {

    private User user;
    private String swForename;
    private String swSurname;

    public Generator(User user){
        this.user = user;
        SetSwForname();
        SetSwSurname();
    }

    public void SetSwForname() {
        this.swForename = user.GetForename().substring(0, 2) + user.GetSurname().substring(0, 3);
    }

    public String GetSwForename() {
        return this.swForename;
    }

    public void SetSwSurname() {
        this.swSurname = user.GetPlaceOfBirth().substring(0, 2) + user.GetMaidenName().substring(0, 2);
    }

    public String GetSwSurname() {
        return this.swSurname;
    }
    
    public void DisplaySwName() {
        System.out.println("Your Star Wars name is: " + GetSwForename() + " " + GetSwSurname());
    }
}
