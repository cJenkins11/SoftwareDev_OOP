/*
package SokoOLD;

*/
/**
 * @author: Callum Jenkins
 * 03/01/2021
 * <p>
 * Class: GridMove
 *//*


public class GridMove {

    private GridOLD levelGridOLD;
    */
/*private Stack<char[][]> moveHistory;
    private Stack<char[][]> redo;*//*


    public GridMove() {
        levelGridOLD = new GridOLD();
        //initStack();
    }

    public GridMove(String level) {
        levelGridOLD = new GridOLD(level);
        //initStack();
    }

    */
/*public void initStack() {
        moveHistory = new Stack<char[][]>();
        redo = new Stack<char[][]>();
    }

    public char[][] undo() {
        String message;
        if (moveHistory.size() > 0) {
            char[][] tempGrid = moveHistory.pop();
            levelGrid.loadGrid(tempGrid);
            moveHistory.push(tempGrid);

            return moveHistory.peek();
            //message = "done";
        }else{
            message = "Can not undo! Stack er empty!";
        }
        return null;
    }


    public char[][] redo() {
        String message = "";
        if (moveHistory.size() > 0) {
            char[][] tempGrid = moveHistory.pop();
            levelGrid.loadGrid(tempGrid);
            moveHistory.push(tempGrid);

            return moveHistory.peek();
        } else {
            message = "can not redo! Stack er empty!";
        }
        return null;
    }
*//*

    public GridOLD getLevelGrid() {
        return this.levelGridOLD;
    }

    public void moveTo(char moveDirection) {
        int x, y;
        // locate player, either + or @
        if (findChar('@')[0] == 0 && findChar('@')[1] == 0) {// +
            x = findChar('+')[0];
            y = findChar('+')[1];
        } else {// find @
            x = findChar('@')[0];
            y = findChar('@')[1];
        }

        //target coordinates based on direction
        int i = x;
        int j = y;
        switch (moveDirection) {
            case 'L':
                j -= 1;
                break;
            case 'D':
                i += 1;
                break;
            case 'R':
                j += 1;
                break;
            case 'U':
                i -= 1;
                break;
        }
        // moving part if target is not X, a wall, then can move == true
        if (canMove(i, j)) {
            // if destination is ' ' Clear
            if (levelGridOLD.getElement(i, j) == ' ') {
                levelGridOLD.setElement(i, j, '@');
                if (levelGridOLD.getElement(x, y) == '+') {
                    levelGridOLD.setElement(x, y, '.');
                } else {
                    levelGridOLD.setElement(x, y, ' ');
                }
            }

            // if target is '.' Goal
            else if (levelGridOLD.getElement(i, j) == '.') {
                levelGridOLD.setElement(i, j, '+');            // '+' player on goal
                if (levelGridOLD.getElement(x, y) == '+') {
                    levelGridOLD.setElement(x, y, '.');
                }
                if (levelGridOLD.getElement(x, y) == '@') {
                    levelGridOLD.setElement(x, y, ' ');
                }
            }


            // if destination is * : crate
            else if (levelGridOLD.getElement(i, j) == '*') {

                //coordinates in front of the target
                int m = nextChar(i, j, x, y)[0];
                int n = nextChar(i, j, x, y)[1];

                //Clear
                if (levelGridOLD.getElement(m, n) == ' ') {
                    levelGridOLD.setElement(m, n, '*');
                    levelGridOLD.setElement(i, j, '@');
                    if (levelGridOLD.getElement(x, y) == '+') {
                        levelGridOLD.setElement(x, y, '.');
                    } else {
                        levelGridOLD.setElement(x, y, ' ');
                    }
                }
                //Goal
                else if (levelGridOLD.getElement(m, n) == '.') {
                    levelGridOLD.setElement(m, n, '$');// '$' box on goal
                    levelGridOLD.setElement(i, j, '@');
                    if (levelGridOLD.getElement(x, y) == '+') {
                        levelGridOLD.setElement(x, y, '.');
                    }else {
                        levelGridOLD.setElement(x, y, ' ');
                    }
                } else if (levelGridOLD.getElement(m, n) == '$') {

                }
            }

            //Crate on Goal
            else if (levelGridOLD.getElement(i, j) == '$') {
                //coordinates in front of the target
                int m = nextChar(i, j, x, y)[0];
                int n = nextChar(i, j, x, y)[1];

                if (levelGridOLD.getElement(m, n) == ' ') {
                    levelGridOLD.setElement(m, n, '*');
                    levelGridOLD.setElement(i, j, '+');

                    //If player is leaving a goal make it a goal
                    //else floor
                    if (levelGridOLD.getElement(x, y) == '+') {
                        levelGridOLD.setElement(x, y, '.');
                    }
                    else {
                        levelGridOLD.setElement(x, y, ' ');
                    }
                }

                else if (levelGridOLD.getElement(m, n) == '.') {
                    levelGridOLD.setElement(m, n, '$');
                    levelGridOLD.setElement(i, j, '+');

                    //If player is leaving a goal make it a goal
                    //else floor
                    if (levelGridOLD.getElement(x, y) == '+') {
                        levelGridOLD.setElement(x, y, '.');
                    }
                    else {
                        levelGridOLD.setElement(x, y, ' ');
                    }
                }


            }
*/
/*
            char[][] newtable = new char[levelGrid.getGridHeight()][levelGrid
                    .getGridWidth()];
            for (int k = 0; k < newtable.length; k++) {
                for (int k2 = 0; k2 < newtable.length; k2++) {
                    newtable[k][k2] = levelGrid.getGameboard()[k][k2];
                }
            }
            moveHistory.push(newtable);*//*

        }
    }


    */
/**
     *
     * @param target - char being searched for
     * @return coordinate x, y of given char
     *//*

    public int[] findChar(char target) {
        int[] xy = { 0, 0 };
        for (int i = 0; i < levelGridOLD.getGridHeight(); i++) {
            for (int j = 0; j < levelGridOLD.getGridWidth(); j++) {
                if (levelGridOLD.getElement(i, j) == target) {
                    xy[0] = i;
                    xy[1] = j;
                    return xy;
                }
            }
        }
        return xy;
    }

    */
/**
     *
     * @param i - player @ x + moveDirection
     * @param j - player @ y + moveDirection
     * @param x - player @ x
     * @param y - player @ y
     * @return - int[{x, y}] : coordinates of
     *//*

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

    */
/**
     *
     * @param i x coordinate of target location
     * @param j y coordinate of target location
     * @return true if target is not a wall
     *//*

    public boolean canMove(int i, int j) {
        if (levelGridOLD.getElement(i, j) == 'X') {
            return false;
        }
        return true;
    }

    */
/*public boolean stop(char inn) {
        if (inn == 'p') {
            return true;
        }
        return false;
    }*//*


    public boolean isValid(char inn) {
        if (inn == 'a' || inn == 's' || inn == 'd' || inn == 'w') {
            return true;
        }
        return false;
    }

    */
/**
     * If there are no uncovered goals or goals covered by player, game complete
     * @return boolean, true = game won, false = incomplete
     *//*

    public boolean hasWon() {
        if (findChar('.')[0] == 0 && findChar('.')[1] == 0 && findChar('+')[0] == 0 && findChar('+')[1] == 0) {
            System.out.println("WINNER");
            return true;
        }
        System.out.println("NOT YET");
        return false;
    }

    public String toString() {
        return levelGridOLD.toString();
    }
}
*/
