package Tutorials_Week5;

/**
 * @author: Callum Jenkins
 * 07/10/2020
 * <p>
 * Class: Nondegree
 */

public class Nondegree extends Student {

    private String levelOfStudy;
    private String courseSupervisor;


    public Nondegree(int matriculationNumber, String courseTitle, String levelOfStudy, String courseSupervisor) {
        super(matriculationNumber, courseTitle);
        this.levelOfStudy = levelOfStudy;
        this.courseSupervisor = courseSupervisor;
    }

    public Nondegree() {
        setLevelOfStudy();
        setCourseSupervisor();
    }


    public String getLevelOfStudy() {
        return levelOfStudy;
    }

    public void setLevelOfStudy(String levelOfStudy) {
        this.levelOfStudy = levelOfStudy;
    }
    public void setLevelOfStudy() {
        String levelOfStudy = "";
        Utilities scanner = new Utilities();
        levelOfStudy = scanner.getUserInput("Please enter the level of study: ");
        this.levelOfStudy = levelOfStudy;
    }


    public String getCourseSupervisor() {
        return courseSupervisor;
    }

    public void setCourseSupervisor(String courseSupervisor) {
        this.courseSupervisor = courseSupervisor;
    }
    public void setCourseSupervisor() {
        String courseSupervisor = "";
        Utilities scanner = new Utilities();
        courseSupervisor = scanner.getUserInput("Please enter the course supervisor: ");
        this.courseSupervisor = courseSupervisor;
    }


    public void displayDetails() {
        super.displayDetails();
        System.out.println("Level of study: " + levelOfStudy);
        System.out.println("Course supervisor: " + courseSupervisor);
    }

}
