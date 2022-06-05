/**
 * DynamicGraph interface by extending the Graph interface in the book. This graph class will be dynamic.
 * We will be able to remove/add vertices and edges.
 */
public interface DynamicGraph extends Graph {

    /**
     * Generate a new vertex by given parameters.
     * @param label Label of new vertex
     * @param weight Weight of the new vertex
     * @return Return true if generating is successful
     */
    public Vertex newVertex(String label, double weight);

    /**
     * Add the given vertex to the graph.
     * @param new_vertex Target  vertex
     * @return If the adding process is successfull, return true
     */
    public boolean addVertex(Vertex new_vertex);

    /**
     * Add an edge between the given two vertices in the graph.
     * @param vertexID1 The source vertex
     * @param vertexID2 The target vertex
     * @param weight Weight of the new vertex
     * @return Return true if the adding process is successful
     */
    public boolean addEdge(int vertexID1, int vertexID2, double weight);

    /**
     * Remove the edge between the given two vertices.
     * @param vertexID1 The source vertex
     * @param vertexID2 The target vertex
     * @return
     */
    public boolean removeEdge(int vertexID1, int vertexID2);

    /**
     * Remove the vertex from the graph with respect to the given vertex id.
     * @param vertexID ID of target vertex
     * @return Return true if the removing process is done successfully
     */
    public Vertex removeVertex(int vertexID);

    /**
     * Remove the vertices that have the given label from the graph.
     * @param label Label of the target vertex
     * @return Return true if the removing process is done successfully
     */
    public Vertex removeVertex(String label);

    /**
     * Filter the vertices by the given user-defined property and returns a subgraph of the graph.
     * @param key Key
     * @param filter Value
     * @return Return the subgraph
     */
    public DynamicGraph filterVertices(String key, String filter);

    /**
     * Generate the adjacency matrix representation of the graph and returns the matrix.
     * @return Return true if the exporting process is done successfully
     */
    public double[][] exportMatrix();

    /**
     * Print the graph in adjacency list format
     */
    public void printGraph();

}


