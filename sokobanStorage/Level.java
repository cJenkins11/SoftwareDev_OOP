/*
package Sokoban;

//import SokobanTest2.*;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.Text;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

*/
/**
 * @author: Callum Jenkins
 * 09/11/2020
 * <p>
 * Class: Map
 *//*



public class Level {

    private MapElement[][] map;
    private GridPane grid;
    private PlayerCharacter playerCharacter;
    private int height = 0;
    private int length = 0;
    private boolean complete = false;
    private SimpleIntegerProperty moveCount;
    private Text movesText;
    private String levelPath;
    private ArrayList<Goal> goals;
    private ArrayList<Crate> crates;


    public Level(String levelPath) throws IOException {
        */
/*addKeyListener(new TAdapter());
        setFocusable(true);*//*

        initialiseLevel();
        setLevel(levelPath);
        map = new MapElement[grid.getRowCount()][grid.getColumnCount()];
        goals = new ArrayList<Goal>();
        crates = new ArrayList<Crate>();
        loadMap();
    }

    private void setLevel(String levelPath) {
        this.levelPath = levelPath;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getLength() {
        return this.length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    */
/**
     * Create a new GridPane with enough rows and columns for all levels
     *//*

    public void initialiseLevel() {

        grid = new GridPane();
        moveCount = new SimpleIntegerProperty(0);
        movesText = new Text("# of Moves: 0");

        for (int i = 0; i <= 30; i++) {
            ColumnConstraints column = new ColumnConstraints(32);
            RowConstraints row = new RowConstraints(32);
            grid.getColumnConstraints().add(column);
            grid.getRowConstraints().add(row);
        }
    }

    */
/**
     * Fills array of MapElements and populates javaFX grid
     *
     * @throws IOException
     *//*

    public void loadMap() throws IOException {
        Scanner scanner = null;
        Wall wall;
        Crate crate;
        Tile tile;
        Goal goal;

        try {
            scanner = new Scanner(new File("H:\\HND\\Semester 1\\Software Dev - OOP\\Repos\\SoftwareDev_OOP\\Sokoban\\levels\\level"+levelPath+".txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        for (int row = 0; scanner.hasNextLine() && row < grid.getRowCount(); row++) {
            char[] chars = scanner.nextLine().toCharArray();
            for (int i = 0; i < grid.getColumnCount() && i < chars.length; i++) {

                switch(chars[i]) {
                    //WALL
                    case 'X': {

                        wall = new Wall(row, i);
                        wall.innitIv();
                        wall.getIv().setImage(wall.getImage());
                        map[row][i] = wall;
                        grid.add(wall.getIv(), i, row, 1, 1);
                        break;
                    }
                    case ' ': {
                        tile = new Tile(row, i);
                        tile.innitIv();
                        tile.getIv().setImage(tile.getImage());
                        map[row][i] = tile;
                        grid.add(tile.getIv(), i, row, 1, 1);
                        break;
                    }
                    case '.': {
                        goal = new Goal(row, i);
                        goals.add(goal);
                        goal.innitIv();
                        goal.getIv().setImage(goal.getImage());
                        map[row][i] = goal;
                        grid.add(goal.getIv(), i, row, 1, 1);
                        break;
                    }
                    case '*': {
                        crate = new Crate(row, i);
                        crates.add(crate);
                        crate.innitIv();
                        crate.getIv().setImage(crate.getImage());
                        map[row][i] = crate;
                        grid.add(crate.getIv(), i, row, 1, 1);
                        break;
                    }
                    case '@': {
                        playerCharacter = new PlayerCharacter(row, i);
                        playerCharacter.innitIv();
                        playerCharacter.getIv().setImage(playerCharacter.getImage());
                        map[row][i] = playerCharacter;
                        grid.add(playerCharacter.getIv(), i, row, 1, 1);
                        break;
                    }
                }
            }
        }
    }

    public GridPane getGrid() {
        return this.grid;
    }


   */
/* public void swap(MapElement object, MovementDirections targetDirection) {

        MapElement target = map[(object.getPosition().getX() + targetDirection.getY())][(object.getPosition().getY() + targetDirection.getX())];
        System.out.println("taget coords: x = " + (object.getPosition().getX() + targetDirection.getY()) + " y = " + (object.getPosition().getY() + targetDirection.getX()));

        grid.getChildren().removeAll(object.getIv(), target.getIv());

        target.setPosition(object.getPosition().getX(), object.getPosition().getY());
        object.setPosition((target.getPosition().getX() + targetDirection.getY()), (target.getPosition().getY() + targetDirection.getX()));

        grid.add(object.getIv(), object.getPosition().getY(), object.getPosition().getX(), 1, 1);
        grid.add(target.getIv(), target.getPosition().getY(), target.getPosition().getX(), 1, 1);

        map[target.getPosition().getX()][target.getPosition().getY()] = target;
        map[object.getPosition().getX()][object.getPosition().getY()] = object;

    }*//*


    public void swap(MapElement object, MovementDirections targetDirection) {

        MapElement target = map[(object.getPosition().getX() + targetDirection.getY())][(object.getPosition().getY() + targetDirection.getX())];
        System.out.println("taget coords: x = " + (object.getPosition().getX() + targetDirection.getY()) + " y = " + (object.getPosition().getY() + targetDirection.getX()));

        //Checks for crate or wall collision
        if ((target instanceof Crate) || (target instanceof Wall) || (target instanceof Goal)) {

            //If crate collision, check space ahead is clear or is a goal
            if (target instanceof Crate) {

                if (map[(target.getPosition().getX() + targetDirection.getY())][(target.getPosition().getY() + targetDirection.getX())] instanceof Crate
                    || map[(target.getPosition().getX() + targetDirection.getY())][(target.getPosition().getY() +  targetDirection.getX())] instanceof Wall
                    || map[(target.getPosition().getX() + targetDirection.getY())][(target.getPosition().getY() +  targetDirection.getX())] instanceof Goal) {

                    if (map[(target.getPosition().getX() + targetDirection.getY())][(target.getPosition().getY() +  targetDirection.getX())] instanceof Goal) {
                        System.out.println("GOAL DETECTED");

                        Tile tempTile = new Tile((target.getPosition().getX() + targetDirection.getY()), (target.getPosition().getY() +  targetDirection.getX()));
                        */
/*temp.innitIv();
                        temp.getIv().setImage(temp.getImage());
                        grid.getChildren().removeAll(target.getIv());
                        grid.add(target.getIv(), temp.getPosition().getY(), temp.getPosition().getX(), 1, 1);*//*

                        map[(target.getPosition().getX() + targetDirection.getY())][(target.getPosition().getY() + targetDirection.getX())].setImage(tempTile.getImage()); ;//= temp;

                        swap(target, targetDirection);
                        System.out.println("Target:" + map[(target.getPosition().getX() )][(target.getPosition().getY() )] + "\nObject" + map[object.getPosition().getX()][object.getPosition().getY()]);
                        map[(target.getPosition().getX() + targetDirection.getY())][(target.getPosition().getY() + targetDirection.getX())] = new Goal((target.getPosition().getX() + targetDirection.getY()), (target.getPosition().getY() + targetDirection.getX()));
                        map[(target.getPosition().getX() + targetDirection.getY())][(target.getPosition().getY() + targetDirection.getX())].innitIv();
                        //map[target.getPosition().getX()][target.getPosition().getY()] =
                        swap(object, targetDirection);
                        decrementMoves();
                        updateMoveText();

                        */
/*if (hasWon())
                        {
                            System.out.println("CONGRATS YOU WIN!");
                        }*//*

                        //incrementMoves();
                    }
                    
                } else {
                    swap(target, targetDirection);
                    swap(object, targetDirection);
                    decrementMoves();
                    updateMoveText();

                    */
/*if (hasWon())
                    {
                        System.out.println("CONGRATS YOU WIN!");
                    }*//*

                    //incrementMoves();
                }


            } */
/*else if (target instanceof Goal) {
                // THIS IS A TEST
                System.out.println("GOAL DETECTED");

                Tile tempTile = new Tile(target.getPosition().getX(), target.getPosition().getY());
                        *//*
*/
/*temp.innitIv();
                        temp.getIv().setImage(temp.getImage());*//*
*/
/*
                        *//*
*/
/*grid.getChildren().removeAll(target.getIv());
                        grid.add(target.getIv(), temp.getPosition().getY(), temp.getPosition().getX(), 1, 1);*//*
*/
/*
                map[target.getPosition().getX()][target.getPosition().getY()].setImage(tempTile.getImage()); ;//= temp;

                grid.getChildren().removeAll(object.getIv(), target.getIv());

                target.setPosition(object.getPosition().getX(), object.getPosition().getY());
                object.setPosition((target.getPosition().getX() + targetDirection.getY()), (target.getPosition().getY() + targetDirection.getX()));

                grid.add(object.getIv(), object.getPosition().getY(), object.getPosition().getX(), 1, 1);
                grid.add(target.getIv(), target.getPosition().getY(), target.getPosition().getX(), 1, 1);

*//*
*/
/*
                map[target.getPosition().getX()][target.getPosition().getY()] = target;
                map[object.getPosition().getX()][object.getPosition().getY()] = object;
*//*
*/
/*
                incrementMoves();
                updateMoveText();

            }*//*


            if (target instanceof Goal) {
                grid.getChildren().removeAll(object.getIv(), target.getIv());

                target.setPosition(object.getPosition().getX(), object.getPosition().getY());
                object.setPosition((target.getPosition().getX() + targetDirection.getY()), (target.getPosition().getY() + targetDirection.getX()));

                grid.add(object.getIv(), object.getPosition().getY(), object.getPosition().getX(), 1, 1);
                grid.add(target.getIv(), target.getPosition().getY(), target.getPosition().getX(), 1, 1);

                map[target.getPosition().getX()][target.getPosition().getY()] = target;
                map[object.getPosition().getX()][object.getPosition().getY()] = object;
                incrementMoves();
                updateMoveText();
            }
*/
/*
                Tile temp = new Tile(target.getPosition().getX(), target.getPosition().getY());
                Goal goal = new Goal(target.getPosition().getX(), target.getPosition().getY());
*//*


        //        grid.getChildren().removeAll(object.getIv(), target.getIv());

                //target.setPosition(object.getPosition().getX(), object.getPosition().getY());
      //          object.setPosition((object.getPosition().getX() + targetDirection.getY()), (object.getPosition().getY() + targetDirection.getX()));

    //            grid.add(object.getIv(), object.getPosition().getY(), object.getPosition().getX(), 1, 1);
                //target.getIv().setImage(temp.getImage());
  //              grid.add(target.getIv(), (object.getPosition().getY() - targetDirection.getX()), (object.getPosition().getX() - targetDirection.getY()), 1, 1);
                //target.getIv().setImage(goal.getImage());

*/
/*
                map[target.getPosition().getX()][target.getPosition().getY()] = target;
                map[object.getPosition().getX()][object.getPosition().getY()] = object;
*//*

*/
/*
                incrementMoves();
                updateMoveText();*//*


                //object.setPosition((object.getPosition().getX() + targetDirection.getY()), (object.getPosition().getY() + targetDirection.getX()));

            //}


        } else {
            grid.getChildren().removeAll(object.getIv(), target.getIv());

            target.setPosition(object.getPosition().getX(), object.getPosition().getY());
            object.setPosition((target.getPosition().getX() + targetDirection.getY()), (target.getPosition().getY() + targetDirection.getX()));

            grid.add(object.getIv(), object.getPosition().getY(), object.getPosition().getX(), 1, 1);
            grid.add(target.getIv(), target.getPosition().getY(), target.getPosition().getX(), 1, 1);

            map[target.getPosition().getX()][target.getPosition().getY()] = target;
            map[object.getPosition().getX()][object.getPosition().getY()] = object;
            incrementMoves();
            updateMoveText();

            */
/*if (hasWon())
            {
                System.out.println("CONGRATS YOU WIN!");
            }*//*

        }
    }

    public void swapMK2(MapElement object, MovementDirections targetDirection) {

        Coordinate startingPosition = object.getPosition();
        MapElement target = map[(object.getPosition().getX() + targetDirection.getY())][(object.getPosition().getY() + targetDirection.getX())];
        System.out.println("taget coords: x = " + (object.getPosition().getX() + targetDirection.getY()) + " y = " + (object.getPosition().getY() + targetDirection.getX()));

        if (canMove(target.getPosition())) {

            if (target instanceof Tile) {

                    map[target.getPosition().getX()][target.getPosition().getY()] = playerCharacter;
                    //If character is on a goal
                    */
/*if (levelGrid.getElement(x, y) == '+') {
                        levelGrid.setElement(x, y, '.');
                    } else {
                        levelGrid.setElement(x, y, ' ');
                    }*//*

                }
            }

    }

    public boolean canMove(Coordinate targetPosition) {
        if (getMap()[targetPosition.getX()][targetPosition.getY()] instanceof Wall) {
            return false;
        } else return true;
    }

    public boolean hasWon() {
        //if all goals are covered by crates = win
        int numberofGoals = goals.size();
        int completedGoals = 0;

        for (int i = 0; i < numberofGoals; i++) {
            Crate crate = crates.get(i);
            for (int j = 0; j < numberofGoals; j++) {
                Goal goal = goals.get(i);

                if ((crate.getPosition().getX() == goal.getPosition().getX())
                        && (crate.getPosition().getY() == goal.getPosition().getY())) {
                    completedGoals += 1;
                }
            }
                        //inPlace[i] = //map[goalPositions.get(i).getX()][goalPositions.get(i).getY()] instanceof Crate;
        }

        if (completedGoals == numberofGoals) {
            return true;
        }
*/
/*
        for (boolean b: inPlace) {
            if (!b) {
                return  false;
            }
            return true;
        }*//*


        */
/*for (int i = 0; i < goalPositions.size(); i++) {
            System.out.println("X: " + goalPositions.get(i).getX()
                             + "\nY: " + goalPositions.get(i).getY());
        }*//*


        return false;
    }

    public void checkGoals() {
        for (int i = 0; i < goals.size(); i++) {
            System.out.println(map[goals.get(i).getPosition().getX()][goals.get(i).getPosition().getY()] + " @ x: " + goals.get(i).getPosition().getX()+ " y: " + goals.get(i).getPosition().getY());
        }
    }

    public MapElement[][] getMap() {
        return this.map;
    }

    public PlayerCharacter getPlayerCharacter() {
        return this.playerCharacter;
    }

    public SimpleIntegerProperty getMoveCount() {
        return this.moveCount;
    }

    public void incrementMoves() {
        this.moveCount.setValue((this.moveCount.getValue() + 1));
        //movesText.textProperty().bind(new SimpleStringProperty("# of Moves ").concat(moveCount.getValue().toString()));
    }

    public void decrementMoves() {
        this.moveCount.setValue((this.moveCount.getValue() - 1));
    }

    public void updateMoveText() {
        this.movesText.textProperty().bind(new SimpleStringProperty("# of Moves: ").concat(this.moveCount.getValue().toString()));
        */
/*for (int i = 0; i < goalPositions.size(); i++) {
            System.out.println("X: " + goalPositions.get(i).getX()
                             + "\nY: " + goalPositions.get(i).getY());
        }*//*

    }

    */
/*public boolean movePC(int direction) {

    }*//*


    public Text getMoveText() {
        return this.movesText;
    }

    public void updateGrid() {

    }
}

*/
/*    private class TAdapter extends KeyAdapter {

        public void keyPressed(KeyEvent e) {
            if (complete) {
                return;
            }

            int key = e.getKeyCode();

            if (key == KeyEvent.VK_LEFT) {
                if (checkWallCollision(playerCharacter, LEFT_COLLISION)) {
                    return;
                }
                if (checkCrateCollision(LEFT_COLLISION)) {
                    return;
                }
                playerCharacter.moveElement(-SPACE, 0);
            } else if (key == KeyEvent.VK_RIGHT) {
                if (checkWallCollision(playerCharacter, RIGHT_COLLISION)) {
                    return;
                }
                if (checkCrateCollision(RIGHT_COLLISION)) {
                    return;
                }
                playerCharacter.moveElement(SPACE, 0);
            } else if (key == KeyEvent.VK_UP) {
                if (checkWallCollision(playerCharacter, TOP_COLLISION)) {
                    return;
                }
                if (checkCrateCollision(TOP_COLLISION)) {
                    return;
                }
                playerCharacter.moveElement(0, -SPACE);
            } else if (key == KeyEvent.VK_DOWN) {
                if (checkWallCollision(playerCharacter, BOTTOM_COLLISION)) {
                    return;
                }
                if (checkCrateCollision(BOTTOM_COLLISION)) {
                    return;
                }
                playerCharacter.moveElement(0, SPACE);
            }
            //ADD UNDO, RESTART, EXIT
            //updateLevel();
        }

    }

    private boolean checkWallCollision(MapElement playerCharacter, int type) {
        switch (type) {
            case LEFT_COLLISION:
                {
                    for (int i = 0; i < walls.size(); i++) {
                        Wall wall = walls.get(i);
                        if (playerCharacter.hasCollidedLeft(wall)) {
                            return true;
                        }
                    }
                    return false;
                }

            case RIGHT_COLLISION:
            {
                for (int i = 0; i < walls.size(); i++) {
                    Wall wall = walls.get(i);
                    if (playerCharacter.hasCollidedRight(wall)) {
                        return true;
                    }
                }
                return false;
            }

            case TOP_COLLISION:
            {
                for (int i = 0; i < walls.size(); i++) {
                    Wall wall = walls.get(i);
                    if (playerCharacter.hasCollidedTop(wall)) {
                        return true;
                    }
                }
                return false;
            }

            case BOTTOM_COLLISION:
            {
                for (int i = 0; i < walls.size(); i++) {
                    Wall wall = walls.get(i);
                    if (playerCharacter.hasCollidedBottom(wall)) {
                        return true;
                    }
                }
                return false;
            }

            default: break;
        }
        return false;
    }

    private boolean checkCrateCollision(int type) {
        switch (type) {
            case LEFT_COLLISION:
            {
                for (int i = 0; i < crates.size(); i++) {
                    Crate crate = crates.get(i);
                    if (playerCharacter.hasCollidedLeft(crate)) {
                        for (int j = 0; j < crates.size(); j++) {
                            Crate element = crates.get(i);

                            if (!crate.equals(element)) {
                                if(crate.hasCollidedLeft(element)) {
                                    return true;
                                }
                            }

                            if (checkWallCollision(crate, LEFT_COLLISION)) {
                                return true;
                            }
                        }
                        crate.moveElement(-SPACE, 0);
                        isComplete();
                    }
                }
                return false;
            }

            case RIGHT_COLLISION:
            {
                for (int i = 0; i < crates.size(); i++) {
                    Crate crate = crates.get(i);
                    if (playerCharacter.hasCollidedRight(crate)) {
                        for (int j = 0; j < crates.size(); j++) {
                            Crate element = crates.get(i);

                            if (!crate.equals(element)) {
                                if(crate.hasCollidedRight(element)) {
                                    return true;
                                }
                            }

                            if (checkWallCollision(crate, RIGHT_COLLISION)) {
                                return true;
                            }
                        }
                        crate.moveElement(SPACE, 0);
                        isComplete();
                    }
                }
                return false;
            }

            case TOP_COLLISION:
            {
                for (int i = 0; i < crates.size(); i++) {
                    Crate crate = crates.get(i);
                    if (playerCharacter.hasCollidedTop(crate)) {
                        for (int j = 0; j < crates.size(); j++) {
                            Crate element = crates.get(i);

                            if (!crate.equals(element)) {
                                if(crate.hasCollidedTop(element)) {
                                    return true;
                                }
                            }

                            if (checkWallCollision(crate, TOP_COLLISION)) {
                                return true;
                            }
                        }
                        crate.moveElement(0, -SPACE);
                        isComplete();
                    }
                }
                return false;
            }

            case BOTTOM_COLLISION:
            {
                for (int i = 0; i < crates.size(); i++) {
                    Crate crate = crates.get(i);
                    if (playerCharacter.hasCollidedBottom(crate)) {
                        for (int j = 0; j < crates.size(); j++) {
                            Crate element = crates.get(i);

                            if (!crate.equals(element)) {
                                if(crate.hasCollidedBottom(element)) {
                                    return true;
                                }
                            }

                            if (checkWallCollision(crate, BOTTOM_COLLISION)) {
                                return true;
                            }
                        }
                        crate.moveElement(0, SPACE);
                        isComplete();
                    }
                }
                return false;
            }

            default: break;
        }
        return false;
    }

    public void isComplete() {
        int numberCrates = crates.size();
        int cratesOnGoals = 0;

        for (int i = 0; i < numberCrates; i++) {
            Crate crate = crates.get(i);
            for (int j = 0; j < numberCrates; j++) {
                Goal goal = goals.get(j);

                if (crate.getPosition().isEqual(goal.getPosition()))
                {
                    cratesOnGoals++;
                }
            }
        }

        if (cratesOnGoals == numberCrates) {
            complete = true;
        }
    }

    public void restartLevel() {
        tiles.clear();
        walls.clear();
        crates.clear();
        goals.clear();
    }

}*/

