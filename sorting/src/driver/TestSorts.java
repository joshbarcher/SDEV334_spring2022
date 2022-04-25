package driver;

import sorts.BasicSorts;

import java.util.Arrays;

public class TestSorts
{
    public static void main(String[] args)
    {
        int[] testArray = {5, -1, 7, 9, 3, 7, 24, 45, 12, 25};

        BasicSorts sorts = new BasicSorts();

        System.out.println(Arrays.toString(testArray));
        sorts.bubbleSort(testArray);
        System.out.println(Arrays.toString(testArray));
    }
}















