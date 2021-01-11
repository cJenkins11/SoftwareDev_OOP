package Sokoban;

import javafx.beans.property.SimpleIntegerProperty;

/**
 * @author: Callum Jenkins
 * 10/01/2021
 * <p>
 * Class: GridMovement
 */

public class GridMovement {

    private SimpleIntegerProperty moveCount = new SimpleIntegerProperty();
    //private Grid levelGrid;
    private Grid levelGrid;

    public GridMovement(String level) {
        levelGrid = new Grid(level);
        moveCount.setValue(0);
    }

    public Grid getLevelGrid() {return this.levelGrid;}

    //public char[][] getGrid() {return this.levelGrid.getGrid();}


    public void move(MovementDirections direction) {

        Coordinate player = levelGrid.locatePC();
        Coordinate targetPosition = new Coordinate((player.getX() + direction.getY()),(player.getY() + direction.getX()));

        if (canMove(targetPosition)) {

            //If space is free
            if (levelGrid.getElement(targetPosition) == ' ') {

                levelGrid.setElement(targetPosition, '@');
                //If object was already on a goal
                if (levelGrid.getElement(player) == '+') {
                    levelGrid.setElement(player, '.');
                } else {
                    levelGrid.setElement(player, ' ');
                }
                moveCount.setValue((moveCount.getValue() + 1));
            }

            // if target is '.' Goal
            else if (levelGrid.getElement(targetPosition) == '.') {
                levelGrid.setElement(targetPosition, '+');            // '+' player on goal
                if (levelGrid.getElement(player) == '+') {
                    levelGrid.setElement(player, '.');
                }
                if (levelGrid.getElement(player) == '@') {
                    levelGrid.setElement(player, ' ');
                }
                moveCount.setValue((moveCount.getValue() + 1));
            }

            // if destination is * : crate
            else if (levelGrid.getElement(targetPosition) == '*') {

                //coordinates in front of the target
                Coordinate targetSpace = new Coordinate((targetPosition.getX() + direction.getY()),(targetPosition.getY() + direction.getX()));

                //Clear
                if (levelGrid.getElement(targetSpace) == ' ') {
                    levelGrid.setElement(targetSpace, '*');
                    levelGrid.setElement(targetPosition, '@');
                    if (levelGrid.getElement(player) == '+') {
                        levelGrid.setElement(player, '.');
                    } else {
                        levelGrid.setElement(player, ' ');
                    }
                    moveCount.setValue((moveCount.getValue() + 1));
                }
                //Goal
                else if (levelGrid.getElement(targetSpace) == '.') {
                    levelGrid.setElement(targetSpace, '$');// '$' box on goal
                    levelGrid.setElement(targetPosition, '@');
                    if (levelGrid.getElement(player) == '+') {
                        levelGrid.setElement(player, '.');
                    }else {
                        levelGrid.setElement(player, ' ');
                    }
                    moveCount.setValue((moveCount.getValue() + 1));
                }
            }

            else if (levelGrid.getElement(targetPosition) == '$') {

                Coordinate targetSpace = new Coordinate((targetPosition.getX() + direction.getY()),(targetPosition.getY() + direction.getX()));

                //Clear
                if (levelGrid.getElement(targetSpace) == ' ') {
                    levelGrid.setElement(targetSpace, '*');
                    levelGrid.setElement(targetPosition, '.');
                    if (levelGrid.getElement(player) == '+') {
                        levelGrid.setElement(player, '.');
                    } else {
                        levelGrid.setElement(player, '+');
                    }
                    moveCount.setValue((moveCount.getValue() + 1));
                }
                //Goal
                else if (levelGrid.getElement(targetSpace) == '.') {
                    levelGrid.setElement(targetSpace, '$');// '$' box on goal
                    levelGrid.setElement(targetPosition, '+');
                    if (levelGrid.getElement(player) == '+') {
                        levelGrid.setElement(player, '.');
                    }else {
                        levelGrid.setElement(player, ' ');
                    }
                    moveCount.setValue((moveCount.getValue() + 1));
                }
            }

        }
    }

    private boolean canMove(Coordinate targetPosition) {
        if (levelGrid.getElement(targetPosition) == 'X') {
            return false;
        }
        return true;
    }

    public SimpleIntegerProperty getMoveCount() {return this.moveCount;}

    public Coordinate findChar(char target) {
        Coordinate xy = new Coordinate(0, 0);
        for (int i = 0; i < levelGrid.getGridHeight(); i++) {
            for (int j = 0; j < levelGrid.getGridWidth(); j++) {
                if (levelGrid.getElement(i, j) == target) {
                    xy.setX(i);
                    xy.setY(j);
                    return xy;
                }
            }
        }
        return xy;
    }

    public boolean hasWon() {
        if (findChar('.').getX() == 0 && findChar('.').getY() == 0 && findChar('+').getX() == 0 && findChar('+').getY() == 0) {
            System.out.println("WINNER");
            return true;
        } else {
            //System.out.println("NOT YET");
            return false;
        }
    }

}
