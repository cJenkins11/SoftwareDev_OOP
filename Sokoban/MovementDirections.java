package Sokoban;

public enum MovementDirections {

    UP(0, -1), RIGHT(1, 0), DOWN(0, 1), LEFT(-1, 0);

    private Coordinate movementVector;

    MovementDirections(int i, int j) {
        movementVector = new Coordinate(i, j);
    }

    public int getX() {
        return this.movementVector.getX();
    }

    public int getY() {
        return this.movementVector.getY();
    }
}
