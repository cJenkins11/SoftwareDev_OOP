package Tutorials_Week6;

/**
 * @author: Callum Jenkins
 * 19/10/2020
 * <p>
 * Class: Student
 */

public class Student {

    private String studentNumber;
    private String studentForename;
    private String studentSurname;
    private String studentEmail;
    private String studentMobile;

    public Student(String studentNumber, String studentForename, String studentSurname, String studentEmail, String studentMobile) {
        this.studentNumber = studentNumber;
        this.studentForename = studentForename;
        this.studentSurname = studentSurname;
        this.studentEmail = studentEmail;
        this.studentMobile = studentMobile;
    }
    public Student() {
        setStudentNumber();
        setStudentForename();
        setStudentSurname();
        setStudentEmail();
        setStudentMobile();
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }
    public void setStudentNumber() {
        String studentNumber = "";
        Utilities scanner = new Utilities();
        studentNumber = scanner.getUserInput("Please enter student number: ");
        this.studentNumber = studentNumber;
    }


    public String getStudentForename() {
        return studentForename;
    }

    public void setStudentForename(String studentForename) {
        this.studentForename = studentForename;
    }
    public void setStudentForename() {
        String studentForename = "";
        Utilities scanner = new Utilities();
        studentForename = scanner.getUserInput("Please enter student forename: ");
        this.studentForename = studentForename;
    }


    public String getStudentSurname() {
        return studentSurname;
    }

    public void setStudentSurname(String studentSurname) {
        this.studentSurname = studentSurname;
    }
    public void setStudentSurname() {
        String studentSurname = "";
        Utilities scanner = new Utilities();
        studentSurname = scanner.getUserInput("Please enter student surname: ");
        this.studentSurname = studentSurname;
    }


    public String getStudentEmail() {
        return studentEmail;
    }

    public void setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail;
    }
    public void setStudentEmail() {
        String studentEmail = "";
        Utilities scanner = new Utilities();
        studentEmail = scanner.getUserInput("Please enter student email address: ");
        this.studentEmail = studentEmail;
    }


    public String getStudentMobile() {
        return studentMobile;
    }

    public void setStudentMobile(String studentMobile) {
        this.studentMobile = studentMobile;
    }
    public void setStudentMobile() {
        String studentMobile = "";
        Utilities scanner = new Utilities();
        studentMobile = scanner.getUserInput("Please enter student mobile number: ");
        this.studentMobile = studentMobile;
    }

    public void displayDetails() {
        System.out.println("Student Number: " + studentNumber);
        System.out.println("Name: " + studentForename + " " + studentSurname);
        System.out.println("Email: " + studentEmail);
        System.out.println("Mobile: " + studentMobile);
    }
}
