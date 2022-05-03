package sorts;

import java.util.Arrays;

public class MergeSort
{
    public static void main(String[] args)
    {
        int[] testMe = {4, 2, 9, 5, 11, 4};
        System.out.println("Before sort: " + Arrays.toString(testMe));

        MergeSort sorter = new MergeSort();
        sorter.mergeSort(testMe);

        System.out.println("After sort: " + Arrays.toString(testMe));
    }

    //public method that accepts only an array, the "outside" world
    //doesn't need to be aware of whether we are using recursion or not
    public void mergeSort(int[] array)
    {
        mergeSort(array, 0, array.length - 1);
    }

    //private method that sorts elements in the index range [low, high]
    private void mergeSort(int[] array, int low, int high)
    {
        if (high - low <= 0) //base case (one or less elements, which are sorted)
        {
            return; //exit!
        }
        else //otherwise, perform the sort on this sub-array
        {
            //get our mid point
            int mid = (high + low) / 2;

            //recursively sort the left and right sides of the array
            mergeSort(array, low, mid);
            mergeSort(array, mid + 1, high);

            //merge together the sorted sub-arrays
            merge(array, low, high);
        }
    }

    private void merge(int[] array, int low, int high)
    {
        //TODO write this after the break...
    }
}
