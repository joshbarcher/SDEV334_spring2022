package graphs;

import adts.IWeightedUndirectedGraph;
import org.w3c.dom.Node;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class MyGraph<V> implements IWeightedUndirectedGraph<V>
{
    private Map<V, Node> adjacencyLists = new HashMap<>();
    //private int vertexSize = 0;
    private int edgeSize = 0;

    @Override
    public boolean addVertex(V element)
    {
        //the vertices are part of a set
        if (containsVertex(element))
        {
            return false;
        }

        //add it (the element and a null head reference in the LL)
        adjacencyLists.put(element, null);
        return true;
    }

    @Override
    public boolean addVertex(V... elements)
    {
        //only return true if all the elements were added
        boolean result = true;
        for (V element : elements)
        {
            boolean added = addVertex(element);
            result = result && added;
        }
        return result;
    }

    @Override
    public boolean addEdge(V first, V second, int weight)
    {
        //make sure the vertices are there and the edge is not
        if (!containsVertex(first) || !containsVertex(second) ||
            containsEdge(first, second))
        {
            return false;
        }

        addDirectedEdge(first, second, weight);
        addDirectedEdge(second, first, weight);
        edgeSize++;

        return true;
    }

    @Override
    public boolean addEdge(Edge<V>... edges)
    {
        boolean result = true;

        for (Edge<V> edge : edges)
        {
            boolean worked = addEdge(edge.getFirst(), edge.getSecond(),
                                     edge.getWeight());
            result = result && worked;
        }

        return result;
    }

    //This adds an edge which represents one direction of the relationship
    private void addDirectedEdge(V source, V destination, int weight)
    {
        Node oldHead = adjacencyLists.get(source);
        if (oldHead == null)
        {
            adjacencyLists.put(source, new Node(destination, weight));
        }
        else
        {
            adjacencyLists.put(source, new Node(destination, weight, oldHead));
        }
    }

    @Override
    public boolean containsVertex(V search)
    {
        return adjacencyLists.containsKey(search);
    }

    @Override
    public boolean containsEdge(V first, V second)
    {
        //look up the adjacency list in the map
        Node current = adjacencyLists.get(first);

        //loop over the linked list and see if second
        //is inside of any of the nodes
        while (current != null)
        {
            if (current.otherVertex.equals(second))
            {
                return true;
            }

            current = current.next;
        }

        return false;
    }

    @Override
    public boolean removeVertex(V search)
    {
        return false;
    }

    //this is challenging, implement this one last!
    @Override
    public boolean removeEdge(V first, V second)
    {
        return false;
    }

    @Override
    public int vertexSize()
    {
        return adjacencyLists.size();
    }

    @Override
    public int edgeSize()
    {
        return edgeSize;
    }

    //don't implement this (yet)!
    @Override
    public int degree(V vertex)
    {
        return 0;
    }

    //inner classes
    private class Node
    {
        //data in the node
        private V otherVertex;
        private int weight;

        //next node
        private Node next;

        public Node(V otherVertex, int weight)
        {
            this.otherVertex = otherVertex;
            this.weight = weight;
        }

        public Node(V otherVertex, int weight, Node next)
        {
            this.otherVertex = otherVertex;
            this.weight = weight;
            this.next = next;
        }

        @Override
        public String toString()
        {
            return otherVertex + " (" + weight + ")";
        }
    }
}
