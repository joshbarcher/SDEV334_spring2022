package sorts;

import java.util.Arrays;

public class MergeSort
{
    private int[] aux;

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
        int mid = (high + low) / 2;
        int numElements = (high - low + 1);

        //these indices keep track of each sub-array and the next
        //element to merge together
        int left = low;
        int right = mid + 1;

        //pick the elements one-by-one
        for (int i = 0; i < numElements; i++)
        {
            //first check if a sub-array is "exhausted"
            if (left > mid) //no more elements on the left
            {
                aux[low + i] = array[right++];
            }
            else if (right > high) //no more elements on the right
            {
                aux[low + i] = array[left++];
            }
            //next check for the smallest element
            else if (array[left] <= array[right]) //left side smaller (or equal - stable sort!)
            {
                aux[low + i] = array[left++];
            }
            else //right side is smaller
            {
                aux[low + i] = array[right++];
            }
        }

        //move the elements from the auxiliary array back to the input array
        for (int i = 0; i < numElements; i++)
        {
            array[low + i] = aux[low + i];
        }
    }
}











