package Tutorials_Week5;

/**
 * @author: Callum Jenkins
 * 07/10/2020
 * <p>
 * Class: Student
 */

public class Student extends Person {

    private int matriculationNumber;
    private String courseTitle;

    public Student(int matriculationNumber, String courseTitle) {
        this.matriculationNumber = matriculationNumber;
        this.courseTitle = courseTitle;
    }
    public Student() {
        setMatriculationNumber();
        setCourseTitle();
    }

    public void setAddress(String address) {
        super.address = address;
    }
    public void setAddress() {
        String address = "";
        Utilities scanner = new Utilities();
        address = scanner.getUserInput("Please enter this persons address: ");
        super.address = address;
    }


    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }
    public void setCourseTitle() {
        String courseTitle = "";
        Utilities scanner = new Utilities();
        courseTitle = scanner.getUserInput("Please enter the course title: ");
        this.courseTitle = courseTitle;
    }


    public void setMatriculationNumber(int matriculationNumber) {
        this.matriculationNumber = matriculationNumber;
    }
    public void setMatriculationNumber() {
        int matriculationNumber;
        Utilities scanner = new Utilities();
        matriculationNumber = Integer.parseInt(scanner.getUserInput("Please enter matriculation number: "));
        this.matriculationNumber = matriculationNumber;
    }
    
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Matriculation number: " + matriculationNumber);
        System.out.println("Course title: " + courseTitle);
    }
}
