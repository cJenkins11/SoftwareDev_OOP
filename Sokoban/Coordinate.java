package Sokoban;

/**
 * @author: Callum Jenkins
 * 09/11/2020
 * <p>
 * Class: Coordinate
 */

public class Coordinate {

    private int x;
    private int y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return this.y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean isEqual(Coordinate coordinate) {
        if ((this.getX() == coordinate.getX()) && (this.getY() == coordinate.getY()))
        {
            return true;
        }
        return false;
    }
}
