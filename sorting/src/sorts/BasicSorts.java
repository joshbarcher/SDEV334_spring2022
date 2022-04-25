package sorts;

import utilties.SortingUtilities;

public class BasicSorts
{
    public void bubbleSort(int[] array)
    {
        //this determines how many "passes" over the array
        for (int i = 0; i < array.length; i++)
        {
            //this determines which adjacent elements will bubble
            for (int j = 0; j < array.length - 1 - i; j++)
            {
                //see if adjacent elements are out of order
                if (array[j] > array[j + 1])
                {
                    SortingUtilities.swap(array, j, j + 1);
                }
            }
        }
    }

    public static void insertionSort(int[] array)
    {
        //for each new element in the array
        for (int i = 1; i < array.length; i++)
        {
            //move the element into the lower (sorted) positions in the array
            for (int j = i; j >= 1; j--)
            {
                //if out of order swap, otherwise short-circuit and move on
                //to the next element
                if (array[j] < array[j - 1])
                {
                    SortingUtilities.swap(array, j, j - 1);
                }
                else
                {
                    break;
                }
            }
        }
    }

    public static void selectionSort(int[] array)
    {
        //for each index in the array
        for (int i = 0; i < array.length; i++)
        {
            //assume the current element is the smallest
            int smallest = array[i];
            int smallestIndex = i;

            //find any smaller element
            for (int j = i + 1; j < array.length; j++)
            {
                if (array[j] < smallest)
                {
                    smallest = array[j];
                    smallestIndex = j;
                }
            }

            //copy the smallest element into the next smallest index
            //in the array
            SortingUtilities.swap(array, i, smallestIndex);
        }
    }
}
