package Sokoban;

import Sokoban.*;

import java.util.ArrayList;

/**
 * @author: Callum Jenkins
 * 03/01/2021
 * <p>
 * Class: Grid
 */

public class Grid {

    private char[][] board;

    public Grid(String level) {
        init(level);
    }

    public void init(String level) {
        ReadFile filereader = new ReadFile();
        filereader.run(level);
        this.board = filereader.getGrid();
    }

    public void loadBoard(char[][] board) {
        this.board = board;
    }


    public char getElement(Coordinate position) {
        return board[position.getX()][position.getY()];
    }

    public char getElement(int x, int y) {
        return board[x][y];
    }

    public void setElement(Coordinate position, char newChar) {
        board[position.getX()][position.getY()] = newChar;
        //gridChanged(position);
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

    public Coordinate locatePC() {
        for (int i = 0; i < board.length; i ++) {
            for (int j = 0; j < board[0].length; j++) {
                if ((board[i][j] == '@' ) || (board[i][j] == '+')) {
                    return new Coordinate(i, j);
                }
            }
        }
        return null;
    }

    /*public int getGridWidth() {
        int maxCount = 0;
        int rows = board.length;

        for (int i = 0; i < rows; i++) {
            if (board[i] == null) {
                return maxCount;
            } else {
                if (maxCount < board[i].length) {
                    maxCount = board[i].length;
                }
            }
        }
        return maxCount;
    }

    public int getGridHeight() {
        int maxCount = 0;
        int colCount = 0;
        int columns = board[colCount].length;
        for (int i = colCount; i < columns; i++) {
            if (board[i] == null) {
                return maxCount;
            } else {
                if (maxCount < board[i].length) {
                    maxCount = board[i].length;
                }
            }
        }
        return maxCount;
    }*/

    //Override
    public char[][] getGrid() {
        return this.board;
    }


    public char getGridElement(Coordinate position) {
        return getGrid()[position.getX()][position.getY()];
    }

    //@Override
    public int getGridWidth() {
        return board[0].length;
    }

    //@Override
    public int getGridHeight() {
        return board.length;
    }
}
