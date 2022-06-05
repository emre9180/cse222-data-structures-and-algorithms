import java.util.*;

/** Class to implement the depth-first search algorithm.
 *   @author Koffman and Wolfgang
 * */

public class DepthFirstSearch {
    // Data Fields
    /** A reference to the graph being searched. */
    private MyGraph graph;

    /** Array of parents in the depth-first search tree. */
    private int[] parent;

    /** Flag to indicate whether this vertex has been visited. */
    private boolean[] visited;

    /** The array that contains each vertex in discovery order. */
    private int[] discoveryOrder;

    /** The array that contains each vertex in finish order. */
    private int[] finishOrder;

    /** The index that indicates the discovery order. */
    private int discoverIndex = 0;

    /** The index that indicates the finish order. */
    private int finishIndex = 0;

    int counter = 0;

    // Constructors
    /** Construct the depth-first search of a Graph
     starting at vertex 0 and visiting the start vertices in
     ascending order.
     @param graph The graph
     */
    public DepthFirstSearch(MyGraph graph, double [] weights) {
        this.graph = graph;
        int n = graph.getNumV();
        parent = new int[n];
        visited = new boolean[n];
        discoveryOrder = new int[n];
        finishOrder = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = -1;
        }
        for (int i = 0; i < n; i++) {
            if (!visited[i])
                depthFirstSearch(i,weights);
        }
    }

    /** Construct the depth-first search of a Graph
     selecting the start vertices in the specified order.
     The first vertex visited is order[0].
     @param graph The graph
     @param order The array giving the order
     in which the start vertices should be selected
     */
    public DepthFirstSearch(MyGraph graph, int[] order) {
        // Same as constructor above except for the if statement.
    }

    /** Recursively depth-first search the graph
     starting at vertex current.
     @param current The start vertex
     */
    public void depthFirstSearch(int current, double [] weights) {
        /* Mark the current vertex visited. */
        visited[current] = true;
        discoveryOrder[discoverIndex++] = current;

        /* Examine each vertex adjacent to the current vertex and add them to the array. */

        Iterator < Edge > itr = graph.edgeIterator(current); // ADDED BY EMRE YILMAZ
        Edge [] adjecensy = new Edge[graph.getEdgesFromVer(current)]; // ADDED BY EMRE YILMAZ
        int ct = 0; // ADDED BY EMRE YILMAZ

        // ADDED BY EMRE YILMAZ
        while (itr.hasNext())
        {
            adjecensy[ct] = itr.next();
            ++ct;
        }

        // Sort the edge array according to their weights // ADDED BY EMRE YILMAZ
        InsertionSort.sort(adjecensy); // ADDED BY EMRE YILMAZ

        /* Examine each elements in the Edge array. Its elements is sorted according the weights */
        for(int i=0;i<graph.getEdgesFromVer(current);++i) { // CHANGED BY EMRE YILMAZ.
            int neighbor = adjecensy[i].getDest();

            /* Process a neighbor that has not been visited */
            if (!visited[neighbor]) {
        /* Insert (current, neighbor) into the depth-
           first search tree. */
                parent[neighbor] = current;
                weights[counter++] = adjecensy[i].getWeight();
        /* Recursively apply the algorithm
           starting at neighbor. */
                depthFirstSearch(neighbor, weights);
            }
        }
        /* Mark current finished. */
        finishOrder[finishIndex++] = current;
    }

    /**** BEGIN EXERCISE ****/
    /** Get the finish order
     @return finish order
     */
    public int[] getFinishOrder() {
        return finishOrder;
    }

    /**** END EXERCISE ****/
}
