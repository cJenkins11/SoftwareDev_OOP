package Tutorials_Week2.Problem_2;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Circle {
    
    private double radius;
    Scanner kboard = new Scanner(System.in);
    
    public Circle() {

        this.SetRadius();
    }

    public void SetRadius() {

        double newRadius;

        do {
            System.out.println("\nPlease enter Radius: ");
            newRadius = kboard.nextDouble();

            if (newRadius <= 0)
            {
                System.out.println("Radius must be more than 0");
            }

        } while (newRadius <= 0);

        this.radius = newRadius;
    }

    public double GetRadius() {
        return this.radius;
    }

    public String CalculateArea() {

        double area;
        DecimalFormat df = new DecimalFormat("#.##");

        area = 2 * Math.PI * this.radius;

        return df.format(area);

    }

    public void DisplayAll() {

        System.out.println("Radius: " + GetRadius());
        System.out.println("Area: " + CalculateArea());

    }
}
