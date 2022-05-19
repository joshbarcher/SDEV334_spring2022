package adts;

import graphs.Edge;

/**
 * This represents a weighted, undirected graph.
 * @param <V> this is the type of vertices
 */
public interface IWeightedUndirectedGraph<V>
{
    //basic methods
    boolean addVertex(V element);
    boolean addVertex(V... elements);
    boolean addEdge(V first, V second, int weight);
    boolean addEdge(Edge<V>... edges);
    boolean containsVertex(V search);
    boolean containsEdge(V first, V second);
    boolean removeVertex(V search);
    boolean removeEdge(V first, V second);
    int vertexSize();
    int edgeSize();

    //algorithms
    int degree(V vertex);

}
