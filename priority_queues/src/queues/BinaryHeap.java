package queues;

import java.util.Arrays;

public class BinaryHeap<T extends Comparable<T>> implements IPriorityQueue<T>
{
    //constants to control the heap
    private static final int INITIAL_SIZE = 10;
    private static final int RESIZE_RATE = 2;

    //primary fields
    private T[] heap;
    private int size;

    public BinaryHeap()
    {
        heap = (T[])new Comparable[INITIAL_SIZE];

        //TODO add something here...
    }

    //this is the heapify (build-heap) operation
    public BinaryHeap(T[] elements)
    {
        //copy the input elements to the heap
        heap = (T[]) new Comparable[elements.length + 1]; //+1 to adjust for the empty index 0
        for (int i = 0; i < elements.length; i++)
        {
            heap[i + 1] = elements[i];
        }
        size = elements.length;

        //then heapify
        int lastIndexWithChild = size / 2;
        for (int i = lastIndexWithChild; i >= 1; i--)
        {
            sink(i);
        }
    }

    @Override
    public void add(T element)
    {
        //do we need to perform a resize?
        if (size == heap.length - 1)
        {
            resize();
        }

        //store the newly added element to the next unused position
        heap[size + 1] = element;
        size++;

        //adjust the heap ordering
        swim(size);
    }

    private void swim(int currentIndex)
    {
        //current index is not the root (which means we have a parent index)
        while (currentIndex > 1)
        {
            int parentIndex = currentIndex / 2;

            //are they out of order? (child element is smaller)
            if (heap[currentIndex].compareTo(heap[parentIndex]) < 0)
            {
                swap(currentIndex, parentIndex);
                currentIndex = parentIndex; //move up to the parent
            }
            else
            {
                //what do we do if the parent and child are in order?
                break;
            }
        }
    }

    private void swap(int firstIndex, int secondIndex)
    {
        T tempElement = heap[firstIndex];
        heap[firstIndex] = heap[secondIndex];
        heap[secondIndex] = tempElement;
    }

    private void resize()
    {
        //create variables to hold old and new heap
        T[] oldHeap = heap;
        heap = (T[]) new Comparable[oldHeap.length * RESIZE_RATE];

        //copy elements over to the new heap
        for (int i = 1; i <= size; i++)
        {
            heap[i] = oldHeap[i];
        }
    }

    @Override
    public T remove()
    {
        //save the return value
        T result = heap[1];

        //pick a new root
        heap[1] = heap[size];

        //remove the last leaf
        heap[size] = null;
        size--;

        //adjust the heap ordering
        sink(1);

        return result;
    }

    private void sink(int currentIndex)
    {
        //loop as long as the current node has a child
        while (currentIndex * 2 <= size)
        {
            //indices for children
            int leftChildIndex = currentIndex * 2;
            int rightChildIndex = currentIndex * 2 + 1;

            //find the smallest child
            int smallestChildIndex = leftChildIndex;
            if (heap[rightChildIndex] != null && heap[leftChildIndex].compareTo(heap[rightChildIndex]) > 0)
            {
                smallestChildIndex = rightChildIndex;
            }

            //swap if out of order (the parent and the smallest child)
            if (heap[currentIndex].compareTo(heap[smallestChildIndex]) > 0)
            {
                swap(currentIndex, smallestChildIndex);
                currentIndex = smallestChildIndex; //move to the smallest child
            }
            else
            {
                break; //short-circuit when the order is correct
            }
        }
    }

    @Override
    public T peek()
    {
        return heap[1];
    }

    @Override
    public int size()
    {
        return size;
    }

    @Override
    public boolean isEmpty()
    {
        return size == 0;
    }

    @Override
    public String toString()
    {
        return "Heap: " + Arrays.toString(heap);
    }
}
