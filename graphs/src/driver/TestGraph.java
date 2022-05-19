package driver;

import graphs.Edge;
import graphs.MyGraph;

public class TestGraph
{
    public static void main(String[] args)
    {
        //declare the data and graph
        String[] strings = {"a", "b", "c", "d"};
        MyGraph<String> stringGraph = new MyGraph<>();

        //add vertices
        boolean allAdded = stringGraph.addVertex(strings);
        System.out.println("All vertices added? " + allAdded);

        //search for vertices
        for (String test : strings)
        {
            System.out.println("containsVertex(" + test + ") = " +
                    stringGraph.containsVertex(test));
        }
        System.out.println("containsVertex(g) = " +
                stringGraph.containsVertex("g"));

        //added edges
        stringGraph.addEdge(
            new Edge<String>("a", "b", 3),
            new Edge<String>("b", "d", 2),
            new Edge<String>("a", "d", 1),
            new Edge<String>("a", "c", 0),
            new Edge<String>("b", "c", 4)
        );

        System.out.println(stringGraph);
    }
}














