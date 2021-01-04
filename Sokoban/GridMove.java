package Sokoban;

import java.util.Stack;

/**
 * @author: Callum Jenkins
 * 03/01/2021
 * <p>
 * Class: GridMove
 */

public class GridMove {

    private Grid levelGrid;
    private Stack<char[][]> moveHistory;
    private Stack<char[][]> redo;

    public GridMove() {
        levelGrid = new Grid();
        initStack();
    }

    public GridMove(String level) {
        levelGrid = new Grid(level);
        initStack();
    }

    public void initStack() {
        moveHistory = new Stack<char[][]>();
        moveHistory = new Stack<char[][]>();
    }

    public String undo() {
        String message;
        if (moveHistory.size() > 0) {
            char[][] tempGrid = moveHistory.pop();
            levelGrid.loadGrid(tempGrid);
            moveHistory.push(tempGrid);
            message = "done";
        }else{
            message = "Can not undo! Stack er empty!";
        }
        return message;
    }

    public String redo() {
        String message = "";
        if (moveHistory.size() > 0) {
            char[][] tempGrid = moveHistory.pop();
            levelGrid.loadGrid(tempGrid);
            moveHistory.push(tempGrid);
        } else {
            message = "can not redo! Stack er empty!";
        }
        return message;
    }

    public Grid getLevelGrid() {
        return this.levelGrid;
    }

    public void moveTo(char moveDirection) {
        int x, y;
        // find +
        if (findChar('@')[0] == 0 && findChar('@')[1] == 0) {// +
            x = findChar('+')[0];
            y = findChar('+')[1];
        } else {// find @
            x = findChar('@')[0];
            y = findChar('@')[1];
        }
        int i = x;
        int j = y;
        switch (moveDirection) {
            case 'a':
                j -= 1;
                break;
            case 's':
                i += 1;
                break;
            case 'd':
                j += 1;
                break;
            case 'w':
                i -= 1;
                break;
        }
        // moving part if not # * can move
        if (canMove(i, j)) {
            // if destination is ' '
            if (levelGrid.getElement(i, j) == ' ') {
                levelGrid.setElement(i, j, '@');
                if (levelGrid.getElement(x, y) == '+') {
                    levelGrid.setElement(x, y, '.');
                } else {
                    levelGrid.setElement(x, y, ' ');
                }
            }
            // if destination is '.'
            else if (levelGrid.getElement(i, j) == '.') {
                levelGrid.setElement(i, j, '+');// '+' spiller på mål
                if (levelGrid.getElement(x, y) == '+') {
                    levelGrid.setElement(x, y, '.');
                }
                if (levelGrid.getElement(x, y) == '@') {
                    levelGrid.setElement(x, y, ' ');
                }
            }
            // if destination is *
            else if (levelGrid.getElement(i, j) == '*') {// '*' boks
                int m = nextChar(i, j, x, y)[0];
                int n = nextChar(i, j, x, y)[1];
                if (levelGrid.getElement(m, n) == ' ') {
                    levelGrid.setElement(m, n, '*');
                    levelGrid.setElement(i, j, '@');
                    if (levelGrid.getElement(x, y) == '+') {
                        levelGrid.setElement(x, y, '.');
                    } else {
                        levelGrid.setElement(x, y, ' ');
                    }
                } else if (levelGrid.getElement(m, n) == '.') {
                    levelGrid.setElement(m, n, '$');// '*' boks på mål
                    levelGrid.setElement(i, j, '@');
                    if (levelGrid.getElement(x, y) == '+') {
                        levelGrid.setElement(x, y, '.');
                    }else {
                        levelGrid.setElement(x, y, ' ');
                    }
                }
            }
            char[][] newtable = new char[levelGrid.getGridHeight()][levelGrid
                    .getGridWidth()];
            for (int k = 0; k < newtable.length; k++) {
                for (int k2 = 0; k2 < newtable.length; k2++) {
                    newtable[k][k2] = levelGrid.getGameboard()[k][k2];
                }
            }
            moveHistory.push(newtable);
        }
    }

    public int[] findChar(char target) {
        int[] xy = { 0, 0 };
        for (int i = 0; i < levelGrid.getGridHeight(); i++) {
            for (int j = 0; j < levelGrid.getGridWidth(); j++) {
                if (levelGrid.getElement(i, j) == target) {
                    xy[0] = i;
                    xy[1] = j;
                    return xy;
                }
            }
        }
        return xy;
    }

    public int[] nextChar(int i, int j, int x, int y) {
        int[] table = { 0, 0 };
        if (i == x) {
            if (j < y) {
                table[0] = i;
                table[1] = j - 1;
                return table;
            }
            if (j > y) {
                table[0] = i;
                table[1] = j + 1;
                return table;
            }
        }
        if (j == y) {
            if (i < x) {
                table[0] = i - 1;
                table[1] = j;
                return table;
            }
            if (i > x) {
                table[0] = i + 1;
                table[1] = j;
                return table;
            }
        }
        return table;
    }

    public boolean canMove(int i, int j) {
        if (levelGrid.getElement(i, j) == '#' || levelGrid.getElement(i, j) == '$') {
            return false;
        }
        return true;
    }

    public boolean stop(char inn) {
        if (inn == 'p') {
            return true;
        }
        return false;
    }

    public boolean isValid(char inn) {
        if (inn == 'a' || inn == 's' || inn == 'd' || inn == 'w') {
            return true;
        }
        return false;
    }

    public boolean hasWon() {
        if (findChar('.')[0] == 0 && findChar('.')[1] == 0 && findChar('+')[0] == 0
                && findChar('+')[1] == 0) {
            return true;
        }
        return false;
    }

    public String toString() {
        return levelGrid.toString();
    }
}
