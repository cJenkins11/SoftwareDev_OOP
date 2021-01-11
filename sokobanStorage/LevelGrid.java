/*
package Sokoban;

import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.util.ArrayList;

*/
/**
 * @author: Callum Jenkins
 * 08/01/2021
 * <p>
 * Class: LevelGrid
 *//*


public class LevelGrid implements PullFromGrid {

    private MapElement[][] map;
    private int height = 0;
    private int length = 0;
    private String levelPath;
    private ArrayList<ListenToGrid> listeners;


    public LevelGrid(String level) {
        listeners = new ArrayList<ListenToGrid>();
        initMap(level);
    }

    public void initMap(String level) {
        ReadFile reader = new ReadFile();
        reader.run(level);
        map = reader.toMapElement();
    }

    public void move(MapElement object, MovementDirections direction) {

        //target element where object wants to move
        MapElement target = map[(object.getPosition().getX() + direction.getY())][(object.getPosition().getY() + direction.getX())];


        if (canMove(target.getPosition())) {

            //If space is free
            if (target instanceof Tile) {
                map[target.getPosition().getX()][target.getPosition().getY()] = new PlayerCharacter(target.getPosition().getX(), target.getPosition().getY());

                //If object was already on a goal
                if (object.getState() == '+') {
                    map[object.getPosition().getX()][object.getPosition().getY()].setState('.');
                } else {
                    map[object.getPosition().getX()][object.getPosition().getY()] = new Tile(object.getPosition().getX(), object.getPosition().getY());
                }

            }
        }
    }

    public boolean canMove(Coordinate targetPosition) {
        if (map[targetPosition.getX()][targetPosition.getY()] instanceof Wall) {
            return false;
        } else return true;
    }

    */
/*public MapElement getElement(Coordinate position) {
        return getMap()[position.getX()][position.getY()];
    }*//*


    public void setElement(Coordinate position, char iconChar) {
        getMap()[position.getX()][position.getY()].setState(iconChar);
        gridChanged(position);
    }

    public void gridChanged(Coordinate postitionChanged) {
        for (ListenToGrid listener : this.listeners) {
            listener.gridChanged(this, postitionChanged);
        }

    }

    public Coordinate locatePC() {
        for (int i = 0; i < map.length; i ++) {
            for (int j = 0; j < map[i].length; i++) {
                if (map[i][j] instanceof PlayerCharacter) {
                    return new Coordinate(i, j);
                }
            }
        }
        return null;
    }


    private EventHandler<KeyEvent> keyListener = new EventHandler<KeyEvent>() {
        @Override
        public void handle(KeyEvent event) {
            if(event.getCode() == KeyCode.UP || event.getCode() == KeyCode.DOWN ||
                    event.getCode() == KeyCode.RIGHT || event.getCode() == KeyCode.LEFT) {
                //movement
                if (event.getCode() == KeyCode.UP) {
                    move(getGridElement(locatePC()), MovementDirections.UP);
                } else if (event.getCode() == KeyCode.DOWN) {
                    move(getGridElement(locatePC()), MovementDirections.DOWN);
                } else if (event.getCode() == KeyCode.LEFT) {
                    move(getGridElement(locatePC()), MovementDirections.LEFT);
                } else if (event.getCode() == KeyCode.RIGHT) {
                    move(getGridElement(locatePC()), MovementDirections.RIGHT);
                }

            }
            else if(event.getCode() == KeyCode.SPACE) {
                //restart


            }
            event.consume();
        }
    };

    @Override
    public char[][] getMap() {
        return this.map;
    }

    */
/**
     * @return number of columns in a grid
     *//*

    @Override
    public int getGridWidth() {
        int width = 0;
        int maxWidth = 0;
        for(int i = 0; i < getMap().length; i++) {
            for (int j = 0; j < getMap()[i].length; j++) {
                */
/*if (getGridElement(new Coordinate(i, j)) != null) {
                    width ++;
                    if (width > maxWidth) {
                        maxWidth = width;
                    }
                }*//*

            }
        }
        return maxWidth;
    }

    */
/**
     * @return number of rows in a grid
     *//*

    @Override
    public int getGridHeight() {
        int height = 0;
        int maxHeight = 0;

        for(int i = 0; i < getMap()[i].length; i++) {
            for (int j = 0; j < getMap().length; j++) {
                */
/*if (getGridElement(new Coordinate(i, j)) != null) {
                    height ++;
                    if (height > maxHeight) {
                        maxHeight = height;
                    }
                }*//*

            }
        }
        return maxHeight;
    }

    */
/**
     * @param position - coordinate object contains (x, y) position
     * @return MapElement in a grid at given position
     *//*

   */
/* @Override
    public MapElement getGridElement(Coordinate position) {
        return getMap()[position.getX()][position.getY()];
    }*//*


    */
/**
     * @param listener listener that is alerted when there is a change in the grid
     *//*

    @Override
    public void addGridListener(ListenToGrid listener) {
        if (!this.listeners.contains(listener)) {
            this.listeners.add(listener);
        }
    }

    */
/**
     * @param listener listener that is alerted when there is a change in the grid
     *//*

    @Override
    public void removeGridListener(ListenToGrid listener) {
        if (this.listeners.contains(listener)) {
            this.listeners.remove(listener);
        }
    }
}
*/
