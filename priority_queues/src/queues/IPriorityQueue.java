package queues;

public interface IPriorityQueue<T extends Comparable<T>>
{
    /**
     * Adds a new element to the heap
     * @param element the new element
     */
    void add(T element);

    /**
     * Remove and return the min element
     * @return the smallest element
     */
    T remove();

    /**
     * Returns the min element
     * @return the smallest element
     */
    T peek();

    int size();
    boolean isEmpty();
}
