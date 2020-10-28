package Tutorials_Week6;

/**
 * @author: Callum Jenkins
 * 19/10/2020
 * <p>
 * Class: Test
 */

public class Main {
    public static void main(String[] args) {

        Unit unit = new Unit("H123 D34", "Object Oriented Programming");
        Menu options = new Menu();

        do {

            switch (options.getMenuChoice()) {
                //Add student
                case 1: {
                    unit.addStudent(new Student());
                    break;
                }

                //Display class list
                case 2: {
                    unit.displayClasslist();
                    break;
                }

                //Display specific student
                case 3: {
                    unit.displayStudent();
                    break;
                }

                //Display passing students
                case 4: {
                    unit.addStudent(new Student("15012241", "Callum", "Jenkins", "15012241@uhi.ac.uk", "01463123123"));
                    unit.addStudent(new Student("15012346", "Joe", "Oak", "someemail@uhi.ac.uk", "01463321321"));
                    unit.addStudent(new Student("15673232", "Emma", "Brown", "anotheremail@uhi.ac.uk", "0146300000"));
                    unit.fillResults();
                    unit.displayPassingStudents();
                    break;
                }

                //Display pass rate of unit
                case 5: {
                    unit.calculatePassRate();
                    break;
                }

                //Remove a student from the class list
                case 6: {
                    unit.removeStudent();
                    break;
                }

                //Exit
                case 7: {
                    System.out.println("Goodbye");
                    break;
                }

                default: {
                    break;
                }
            }

            options.displayMenu();
            options.setMenuChoice();

        } while (options.getMenuChoice() != 7);

        /*Unit testUnit = new Unit("032564", "Unit title");
        Student testStudent = new Student("15012241", "Callum", "Jenkins", "15012241@uhi.ac.uk", "01463123123");
        Student testStudent2 = new Student("15012346", "Joe", "Oak", "someemail@uhi.ac.uk", "01463321321");
        Student testStudent3 = new Student("15673232", "Emma", "Brown", "anotheremail@uhi.ac.uk", "0146300000");



        testUnit.displayClasslist();
        testUnit.addStudent(testStudent);
        testUnit.addStudent(testStudent2);
        testUnit.addStudent(testStudent3);
        testUnit.displayClasslist();*/
    }
}
