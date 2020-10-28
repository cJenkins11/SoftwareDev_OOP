package Tutorials_Week5;

/**
 * @author: Callum Jenkins
 * 07/10/2020
 * <p>
 * Class: Degree
 */

public class Degree extends Student {

    private int yearOfStudy;
    private String tutorName;

    public Degree(int matriculationNumber, String courseTitle, int yearOfStudy, String tutorName) {
        super(matriculationNumber, courseTitle);
        this.yearOfStudy = yearOfStudy;
        this.tutorName = tutorName;
    }
    public Degree() {
        setYearOfStudy();
        setTutorName();
    }


    public int getYearOfStudy() {
        return yearOfStudy;
    }

    public void setYearOfStudy(int yearOfStudy) {
        this.yearOfStudy = yearOfStudy;
    }
    public void setYearOfStudy() {
        int yearOfStudy = 0;
        Utilities scanner = new Utilities();
        yearOfStudy = Integer.parseInt(scanner.getUserInput("Please enter the year of study: "));
        this.yearOfStudy = yearOfStudy;
    }

    public String getTutorName() {
        return tutorName;
    }

    public void setTutorName(String tutorName) {
        this.tutorName = tutorName;
    }
    public void setTutorName() {
        String tutorName = "";
        Utilities scanner = new Utilities();
        tutorName = scanner.getUserInput("Please enter the tutor name ");
        this.tutorName = tutorName;
    }

    public void displayDetails() {
        super.displayDetails();
        System.out.println("Year of study: " + yearOfStudy);
        System.out.println("Tutor name: " + tutorName);
    }
}
