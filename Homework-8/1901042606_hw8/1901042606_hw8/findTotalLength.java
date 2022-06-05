/**
 * Takes a MyGraph object as a parameter and performs BFS and DFS traversals. The method calculates the total distance of the path for accessing each vertex during the traversal, and it returns the difference between the total distances of two traversal methods. If there are more than one alternative to access a vertex at a specific level during the BFS, the shortest alternative should be considered. The vertices should be considered in distance order during DFS traversal, so, from a vertex v, DFS should continue
 * with a vertex w which has the smallest edge from v, among all adjacent vertices of v.
 */
public class findTotalLength {

    /**
     * Takes a MyGraph object as a parameter and performs BFS and DFS traversals. The method calculates the total distance of the path for accessing each vertex during the traversal, and it returns the difference between the total distances of two traversal methods. If there are more than one alternative to access a vertex at a specific level during the BFS, the shortest alternative should be considered. The vertices should be considered in distance order during DFS traversal, so, from a vertex v, DFS should continue
     *  with a vertex w which has the smallest edge from v, among all adjacent vertices of v.
     * @param graph Graph object
     * @return Return the total distance
     */
    public static int findTotal(MyGraph graph)
    {
        double [] weightsBFS = new double[graph.getNumV()];
        double [] weightsDFS = new double[graph.getNumV()];

        BreadthFirstSearch.breadthFirstSearch(graph,0,weightsBFS);
        DepthFirstSearch DFS = new DepthFirstSearch(graph, weightsDFS);

        int total = 0;
        for(int i=0;i<weightsDFS.length;i++)
            total += weightsDFS[i];

        for(int i=0;i<weightsBFS.length;i++)
            total += weightsBFS[i];

        /*// If you want to check the result of the BFS, remove the comment marks
        System.out.printf("\n\nAll the BFS weights:\n");
        for(int i=0;i<weightsBFS.length;i++)
           System.out.println(weightsBFS[i]);

        // If you want to check the result of the DFS, remove the comment marks
        System.out.printf("\nAll the DFS weights:\n");
        for(int i=0;i<weightsDFS.length;i++)
           System.out.println(weightsDFS[i]);*/

        return total;
    }
}
