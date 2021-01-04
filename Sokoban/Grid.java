package Sokoban;

import java.io.FileReader;
import java.util.ArrayList;

/**
 * @author: Callum Jenkins
 * 03/01/2021
 * <p>
 * Class: Grid
 */

public class Grid implements GridProvider {

    private char[][]                board;
    private ArrayList<GridListener> listener;

    public Grid() {
        listener = new ArrayList<GridListener>();
    }

    public Grid(String level) {
        listener = new ArrayList<GridListener>();

        init(level);
    }

    public void init(String level) {
        ReadFile filereader = new ReadFile();
        filereader.run(level);
        this.board = filereader.getGrid();
    }

    public char[][] getGameboard() {
        return this.board;
    }

    public void loadGrid(char[][] board) {
        this.board = board;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                gridChanged(i, j);
            }
        }
    }

    public char getElement(int i, int j) {
        return board[i][j];
    }

    public void setElement(int i, int j, char newChar) {
        board[i][j] = newChar;
        gridChanged(i, j);
    }

    public String toString() {
        String gameboardString = "";
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                gameboardString += board[i][j];
            }
            gameboardString += "\n";
        }
        return gameboardString;
    }


    /**
     * @return number of columns in a grid
     */
    @Override
    public int getGridWidth() {
        return board[0].length;
    }


    /**
     * @return number of rows in a grid
     */
    @Override
    public int getGridHeight() {
        return board.length;
    }


    /**
     * @param x
     * @param y
     * @return object in a grid at position(x,y)
     */
    @Override
    public Object getGridElement(int x, int y) {
        return board[y][x];
    }


    /**
     * @param listener listener that is alerted when there is a change in the grid
     */
    @Override
    public void addGridListener(GridListener listener) {
        if (!this.listener.contains(listener)) {
            this.listener.add(listener);
        }
    }


    /**
     * @param listener listener that is alerted when there is a change in the grid
     */
    @Override
    public void removeGridListener(GridListener listener) {
        if (this.listener.contains(listener)) {
            this.listener.remove(listener);
        }
    }

    public void gridChanged(int x, int y) {
        for (GridListener listener : this.listener) {
            listener.gridChanged(this, y, x, 1, 1);
        }
    }
}
