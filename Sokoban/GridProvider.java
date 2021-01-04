package Sokoban;

public interface GridProvider {


    /**
     * @return number of columns in a grid
     */
    public int getGridWidth();

    /**
     * @return number of rows in a grid
     */
    public int getGridHeight();

    /**
     *
     * @param x
     * @param y
     * @return object in a grid at position(x,y)
     */
    public Object getGridElement(int x, int y);

    /**
     *
     * @param listener listener that is alerted when there is a change in the grid
     */
    public void addGridListener(GridListener listener);

    /**
     *
     * @param listener listener that is alerted when there is a change in the grid
     */
    public void removeGridListener(GridListener listener);

}
