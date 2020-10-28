package Tutorials_Week2.Problem_2;

public class TestChamber {

    public static void main(String[] args) {

        Rectangle r1 = new Rectangle();
        r1.DisplayAll();

        Circle c1 = new Circle();
        c1.DisplayAll();

        r1.kboard.close();
        c1.kboard.close();
    }
}
