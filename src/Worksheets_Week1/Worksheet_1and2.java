package Worksheets_Week1;

import java.util.Scanner;

public class Worksheet_1and2 {

    public static class RandomIntArray {

        public static int[] array;

        //Constructor creates and fills an array of a given length
        public RandomIntArray(int length)
        {
            array = new int[length];
            for (int i = 0; i < length; i++)
            {
                array[i] = (int)(Math.random()*10) + 1;
            }
        }

        //Display all elements of the array
        public void outputArrayValues()
        {
            for (int i = 0; i < array.length; i++)
            {
                System.out.println("Element " + (i + 1) + " is: " + array[i]);
            }
        }

        //Sorts the array using bubble sort algorithm (Ascending/Descending)
        public void BubbleSortAsc()
        {
            boolean switched = true;
            int hold;

            while (switched)
            {
                switched = false;

                //For each element in array
                for (int i = 1; i < array.length; i ++)
                {
                    //Compare adjacent values
                    if (array[i - 1] > array[i])
                    {
                        /*If element on left > element on right
                        Hold the value of the left
                        Assign value of right element to the left index
                        Assign held value to the right index*/

                        hold = array[i - 1];
                        array[i -1] = array[i];
                        array[i] = hold;
                        switched = true;
                    }
                }
            }
        }
        //^^^^
        public void BubbleSortDesc()
        {
            boolean switched = true;
            int hold;

            while (switched)
            {
                switched = false;

                //For each element in array
                for (int i = 1; i < array.length; i ++)
                {
                    //Compare adjacent values
                    if (array[i - 1] < array[i])
                    {
                        /*If element on left < element on right
                        Hold the value of the left
                        Assign value of left element to the right index
                        Assign held value to the left index*/

                        hold = array[i];
                        array[i] = array[i - 1];
                        array[i - 1] = hold;
                        switched = true;
                    }
                }
            }
        }
    }

    public static void main(String[] args)
    {
        int arrayLength_1;
        int arrayLength_2;

        Scanner kboard = new Scanner(System.in);

        System.out.println("Enter array length. Whole, positive numbers only");
        arrayLength_1 = kboard.nextInt();
        RandomIntArray integerArray1 = new RandomIntArray(arrayLength_1);

        System.out.println("\nArray 1");
        integerArray1.outputArrayValues();

        System.out.println("\nArray 1: Sorted Ascending");
        integerArray1.BubbleSortAsc();
        integerArray1.outputArrayValues();

        System.out.println("\nArray 1: Sorted Descending");
        integerArray1.BubbleSortDesc();
        integerArray1.outputArrayValues();


        System.out.println("\nEnter the second array length. Whole, positive numbers only");
        arrayLength_2 = kboard.nextInt();
        RandomIntArray integerArray2 = new RandomIntArray(arrayLength_2);

        System.out.println("\nArray 2");
        integerArray2.outputArrayValues();

        System.out.println("\nArray 2: Sorted Ascending");
        integerArray2.BubbleSortAsc();
        integerArray2.outputArrayValues();

        System.out.println("\nArray 2: Sorted Descending");
        integerArray2.BubbleSortDesc();
        integerArray2.outputArrayValues();

        kboard.close();
    }
}
