package Sokoban;

public interface GridListener {
    /**
     *
     * @param grid
     * @param x
     * @param y
     * @param w width
     * @param h height
     *
     *
     *          Called to notify that a cell has changed in a grid
     */
    void gridChanged(GridProvider grid, int x, int y, int w, int h);
}
