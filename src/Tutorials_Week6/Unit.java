package Tutorials_Week6;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Random;

/**
 * @author: Callum Jenkins
 * 19/10/2020
 * <p>
 * Class: Unit
 */

public class Unit {
    
    private String unitNumber;
    private String unitTitle;
    //private ArrayList<Student> classlist = new ArrayList<Student>();
    private Student classlist[] = new Student[10];
    private String result[] = new String[10];
    
    public Unit(String unitNumber, String unitTitle) {
        this.unitNumber = unitNumber;
        this.unitTitle= unitTitle;
    }
    
    public void addStudent(Student temp) {
        boolean space = false;
        
        for (int i = 0; i < classlist.length - 1; i++)
        {
            if (classlist[i] == null)
            {
                classlist[i] = temp;
                space = true;
                break;
            }
        }
        
        if (space == true)
        {
            System.out.println("Student added.");
        }
        else
        {
            System.out.println("Class is full.");
        }
    }

    public void fillResults() {

        Random rand = new Random();

        for (int l = 0; l < classlist.length - 1; l++)
        {
            if (classlist[l] != null)
            {
                if (rand.nextInt(2) == 0)
                {
                    result[l] = "p";
                }
                else
                {
                    result[l] = "f";
                }
            }
        }
    }

    public void displayStudent() {

        Utilities scanner = new Utilities();
        String searchTerm = "";

        searchTerm = scanner.getUserInput("Enter the forename/surname of student to view details");
        
        if (classlist[0] != null)
        {
            for (int n = 0; n  < classlist.length - 1; n ++)
            {
                if (classlist[n].getStudentForename().equalsIgnoreCase(searchTerm) || classlist[n].getStudentSurname().equalsIgnoreCase(searchTerm))
                {
                    classlist[n].displayDetails();
                }
                else
                {
                    System.out.println("No record of student: " + searchTerm);
                }
                break;
            }
        }
        else 
        {
            System.out.println("No class list available");
        }
    }

    public void removeStudent() {

        Utilities scanner = new Utilities();
        String searchTerm = "";

        searchTerm = scanner.getUserInput("Enter the forename/surname of student to remove from the unit");

        if (classlist[0] != null)
        {
            for (int j = 0; j < classlist.length - 1; j++)
            {
                if (classlist[j].getStudentForename().equalsIgnoreCase(searchTerm) || classlist[j].getStudentSurname().equalsIgnoreCase(searchTerm))
                {
                    classlist[j] = null;
                    System.out.println("Student removed");
                    return;
                }
            }
        }
        else
        {
            System.out.println("No class list available");
        }
    }

    public Student[] getClasslist() {
        return this.classlist;
    }

    public void calculatePassRate() {
        int pass = 0;
        int results = 0;
        double passRate = 0.0;
        DecimalFormat df = new DecimalFormat("##.##");

        for (int k = 0; k < result.length - 1; k++)
        {
            if (result[k] != null)
            {
                if (result[k] == "p") {
                    pass++;
                }
                results++;
            }
        }

        passRate = ((pass * 100) / results);
        System.out.println(df.format(passRate) + "% of students passed this unit.");
    }

    public void displayPassingStudents() {
        System.out.println("**** Passing Students ****");
        for (int o = 0; o < classlist.length; o++)
        {
            if (classlist[o] != null)
            {
                if (result[o] == "p")
                {
                    System.out.println("Name: " + classlist[o].getStudentForename() + " " + classlist[o].getStudentSurname());
                }
            }
        }
    }
    
    public void displayClasslist() {
        
        System.out.println("**** Students enrolled ****");
        for (int m = 0; m < classlist.length - 1; m++)
        {
            if (classlist[m] != null)
            {
                System.out.println("Name: " + classlist[m].getStudentForename() + " " + classlist[m].getStudentSurname());
            }
            else break;
        }
    }
}
