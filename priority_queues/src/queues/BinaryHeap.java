package queues;

public class BinaryHeap<T extends Comparable<T>> implements IPriorityQueue<T>
{
    //constants to control the heap
    private static final int INITIAL_SIZE = 10;
    private static final double RESIZE_RATE = 2.0;

    //primary fields
    private T[] heap;
    private int size;

    public BinaryHeap()
    {
        heap = (T[])new Comparable[INITIAL_SIZE];
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

    }

    @Override
    public T remove()
    {
        return null;
    }

    @Override
    public T peek()
    {
        return null;
    }

    @Override
    public int size()
    {
        return 0;
    }

    @Override
    public boolean isEmpty()
    {
        return false;
    }
}
