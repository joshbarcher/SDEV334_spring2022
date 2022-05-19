package graphs;

public class Edge<V>
{
    private V first;
    private V second;
    private int weight;

    public Edge(V first, V second, int weight)
    {
        this.first = first;
        this.second = second;
        this.weight = weight;
    }

    public V getFirst()
    {
        return first;
    }

    public V getSecond()
    {
        return second;
    }

    public int getWeight()
    {
        return weight;
    }

    @Override
    public String toString()
    {
        return "(" + first + ", " + second + ")";
    }
}
