import java.util.*;

/** Class to implement the breadth-first search algorithm.
 *  @author Koffman and Wolfgang
 * */

public class BreadthFirstSearch {

    /** Perform a breadth-first search of a graph.
     post: The array parent will contain the predecessor
     of each vertex in the breadth-first
     search tree.
     @param graph The graph to be searched
     @param start The start vertex
     @return The array of parents
     */
    public static int[] breadthFirstSearch(MyGraph graph, int start, double [] weights) {
        Queue < Integer > theQueue = new LinkedList < Integer > ();
        // Declare array parent and initialize its elements to �1.
        int[] parent = new int[graph.getNumE()]; //ŞUNA BAK
        for (int i = 0; i < graph.getNumE(); i++) {
            parent[i] = -1;
        }
        // Declare array identified and
        // initialize its identified data field to false.
        Identified[] identified = new Identified[graph.getNumV()];
        for(int i=0;i<identified.length;++i)
            identified[i] = new Identified(false, 123,0); //ŞUNA BAK

    /* Mark the start vertex as identified and insert it
       into the queue */
        int level = 0; // Level of visiting // ADDED BY EMRE YILMAZ
        identified[start] = new Identified(true, 0); // CHANGED BY EMRE YILMAZ
        theQueue.offer(start);
        /* While the queue is not empty */
        while (!theQueue.isEmpty()) {
      /* Take a vertex, current, out of the queue.
       (Begin visiting current). */
            int current = theQueue.remove();
            level++; // // ADDED BY EMRE YILMAZ
            /* Examine each vertex, neighbor, adjacent to current. */
            Iterator < Edge > itr = graph.edgeIterator(current);
            while (itr.hasNext()) {
                Edge edge = itr.next();
                int neighbor = edge.getDest();
                // If neighbor has not been identified
                if (identified[neighbor]==null || !identified[neighbor].getIdentified()) { // CHANGE BY EMRE YILMAZ
                    // Mark it identified.
                    identified[neighbor] = new Identified(true, level, edge.getWeight()); // CHANGE BY EMRE YILMAZ
          /* Insert the edge (current, neighbor)
             into the tree. */
                    // Place it into the queue.
                    theQueue.offer(neighbor);
                    parent[neighbor] = current;
                }


                // ADDED BY EMRE YILMAZ
                // Although the destination vertice is visited, we will check its weight that is already done.
                // If its weight is more than the new one, we will update it
                if(identified[neighbor].getIdentified() && identified[current].getLevel()==identified[neighbor].getLevel()-1 && identified[neighbor].getWeight()>edge.getWeight())
                {
                    identified[neighbor].setWeight(edge.getWeight());
                }
            }
            // Finished visiting current.
        }



        // ADDED BY EMRE YILMAZ
        // Calculate the total distance we have done.
        for(int i=0;i< identified.length;++i)
        {
            if(identified[i].getIdentified()) weights[i] = identified[i].getWeight();
        }
        return parent;
    }
}
