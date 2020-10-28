package StarWarsNameGenerator;/*
Callum Jenkins
Title
28/09/2020 of 09, 2020
*/

public class NameGenerator {

    public static void main(String[] args) {

        User user1 = new User("Joe", "Bloggs", "Doe", "Sometown");
        Generator u1Generator = new Generator(user1);
        u1Generator.DisplaySwName();

        User user2 = new User();
        //System.out.println(user2.GetForename() + user2.GetSurname() + user2.GetMaidenName() + user2.GetPlaceOfBirth());
        Generator u2Generator = new Generator(user2);
        u2Generator.DisplaySwName();


    }
}
