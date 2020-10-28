package DijkstraDutchFlag;/*
Callum Jenkins
Title
28/09/2020 of 09, 2020
*/

import java.util.EnumMap;

public class Sorter {

    private Balls ballsToSort;

    /**
     * Constructor:
     * @param ballsToSort - Balls object to sort
     */
    public Sorter(Balls ballsToSort) {
        this.ballsToSort = ballsToSort;
    }


    /**
     * Outputs the values of the Balls object
     */
    public void displayArray() {
        for (int i = 0; i < ballsToSort.GetNumberOfBalls(); i++)
        {
            System.out.println(ballsToSort.GetValue(i) + " ");
        }
    }

    /**
     * Starts the sorting process
     */
    public void sort() {
        quicksort(0, ballsToSort.GetNumberOfBalls() - 1);
    }


    /**
     *
     * @param low - Low index
     * @param high - High index
     *
     * Pivot is the value being compared to ever other item.
     * Items < pivot move left
     * Items > pivot move right
     *
     */
    public void quicksort(int low, int high) {
        if (low >= high)
        {
            return;
        }

        int pivot = partition(low, high);

        quicksort(low, pivot - 1);
        quicksort(pivot + 1, high);
    }

    /**
     * Moves all elements < pivot to the left of the pivot
     * Moves all elements > pivot to the right of the pivot
     * Then returns pivot index
     * @param low - Smaller index
     * @param high - Higher index
     * @return - Pivot index
     */
    public int partition(int low, int high) {

        EnumMap map = ballsToSort.getColourMap();

        int pivotIndex = (low + high) / 2;

        //Move the value being compared to the end of array
        swap(pivotIndex, high);

        int i = low;

        //Compare the values in the partition to the pivot value
        for (int j = low; j < high; j++)
        {
            //If the value at the high index is lower than he value at j (low index) swap the values
            if ((int) map.get(ballsToSort.GetValue(j)) <= (int) map.get(ballsToSort.GetValue(high)))
            {
                swap(i, j);
                i++;
            }
        }

        swap(i, high);

        return i;
    }

    /**
     * Swaps the values at given indexes
     * @param i - Index to swap
     * @param j - Index to swap
     */
    public void swap(int i, int j) {
        Balls.DutchColours temp = ballsToSort.GetValue(i);
        ballsToSort.SetValue(i, ballsToSort.GetValue(j));
        ballsToSort.SetValue(j, temp);
    }

}
