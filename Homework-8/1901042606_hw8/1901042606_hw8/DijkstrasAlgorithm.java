import java.util.*;

/** A class for calling Dijkstra's algorithm.
 *  @author Koffman and Wolfgang
 */

public class DijkstrasAlgorithm {

    /** Dijkstra�s Shortest-Path algorithm.
     @param graph The weighted graph to be searched
     @param start The start vertex
     @param pred Output array to contain the predecessors
     in the shortest path
     @param dist Output array to contain the distance
     in the shortest path
     */
    public static void dijkstrasAlgorithm(MyGraph graph,
                                          int start,
                                          int[] pred,
                                          double[] dist) {
        int numV = graph.getNumV();
        HashSet < Integer > vMinusS = new HashSet < Integer > (numV);
        // Initialize V�S.
        for (int i = 0; i < numV; i++) {
            if (i != start) {
                vMinusS.add(i);
            }
        }
        // Initialize pred and dist.
        for (int v : vMinusS) {
            pred[v] = start;
            dist[v] = graph.getEdge(start, v).getWeight();
            if(dist[v]<0) dist[v] = 0;
        }
        // Main loop
        while (vMinusS.size() != 0) {
            // Find the value u in V�S with the smallest dist[u].
            double minDist = Double.POSITIVE_INFINITY;
            int u = -1;
            for (int v : vMinusS) {
                if (dist[v] < minDist) {
                    minDist = dist[v];
                    u = v;
                }
            }
            // Remove u from vMinusS.
            vMinusS.remove(u);

            // Update the distances.

            double boostedDouble = 0;
            if(u!=-1)
            {
                String boosted; // UPDATED
                boosted = graph.getVertex(u).getProperty("Boosting"); // UPDATED
                if(boosted!=null) boostedDouble = Double.parseDouble(boosted); // UPDATED
                else boostedDouble = 0;
            }

            for (int v : vMinusS) {
                if (graph.isEdge(u, v)) {
                    double weight = graph.getEdge(u, v).getWeight()-boostedDouble;
                    if(weight<0) weight=0;
                    if (dist[u] + weight < dist[v]) {
                        dist[v] = dist[u] + weight;
                        pred[v] = u;
                    }
                }
            }
        }
    }
}
