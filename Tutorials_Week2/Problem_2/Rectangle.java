package Tutorials_Week2.Problem_2;

import java.util.Scanner;

public class Rectangle {

    private double height;
    private double width;
    Scanner kboard = new Scanner(System.in);

    public Rectangle() {

        this.SetHeight();
        this.SetWidth();

    }

    public void SetHeight() {

        double newHeight;

        do {
            System.out.println("Please enter height: ");
            newHeight = kboard.nextDouble();

            if (newHeight <= 0)
            {
                System.out.println("Height must be more than 0");
            }

        } while (newHeight <= 0);

        this.height = newHeight;
    }

    public double GetHeight() {

        return this.height;

    }

    public void SetWidth() {

        double newWidth;

        do {
            System.out.println("Please enter height: ");
            newWidth = kboard.nextDouble();

            if (newWidth <= 0)
            {
                System.out.println("Height must be more than 0");
            }

        } while (newWidth <= 0);

        this.width = newWidth;
    }

    public double GetWidth() {

        return this.width;

    }

    public double CalculateArea() {

        double area;

        area = this.height * this.width;

        return area;

    }

    public boolean IsSquare() {

        boolean square;

        square = this.height == this.width;

        return square;

    }

    public void DisplayAll() {

        System.out.println("Height: " + GetHeight());
        System.out.println("Width: " + GetWidth());
        System.out.println("Area: " + CalculateArea());

        if (IsSquare())
        {
            System.out.println("This is a square");
        } else
        {
            System.out.println("This is not a square");
        }

    }
}
