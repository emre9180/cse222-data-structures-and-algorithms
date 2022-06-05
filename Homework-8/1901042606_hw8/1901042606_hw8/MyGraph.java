import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Objects;

/**
 * Dynamic Graph Class.
 */
public class MyGraph implements DynamicGraph{

    /**
     * Number of edges
     */
    private int numEdge;

    /**
     * Number of vertices
     */
    private int numV;

    /**
     * Capacity of array
     */
    private int capacity;

    /**
     * Indicates whether the graph is directed
     */
    private boolean directed;

    /**
     * Vertex List
     */
    private ArrayList<Vertex> verList;

    /**
     * An array of Linked Lists to contain the edges that
     * originate with each vertex.
     */
    private LinkedList < Edge > [] edges;

    /** Construct a graph with the specified number of
     vertices and directionality.
     @param numV The number of vertices
     @param directed The directionality flag
     */
    public MyGraph(int numV, boolean directed) {
        capacity = numV;
        this.directed = directed;
        edges = new LinkedList[numV];
        for (int i = 0; i < numV; i++) {
            edges[i] = new LinkedList<Edge>();
        }
        verList = new ArrayList<>();
    }

    /**
     * Vertex Creater. It takes label and weight as parameter and returns a new Vertex with ID.
     * @param label Label of new vertex
     * @param weight Weight of the new vertex
     * @return Returns the Vertex
     */
    @Override
    public Vertex newVertex(String label, double weight)
    {
        if(verList.size()==0) return new Vertex(0, label, weight);
        else
            return new Vertex(verList.get(verList.size()-1).getID()+1, label, weight) ;
    }

    /**
     * Add the vertex in the parameter to the Vertex List
     * @param new_vertex Target  vertex
     * @return Returns true if the adding process is successful
     */
    @Override
    public boolean addVertex(Vertex new_vertex)
    {
        verList.add(new_vertex);
        numV++;
        return true;
    }

    /**
     * Private helper method. It finds the vertex index with given ID
     * @param id Target ID
     * @return Returns the index
     */
    public int findVertexIndex(int id)
    {
        for (int i=0;i< verList.size();++i)
            if (verList.get(i).getID() == id) return i;
        return -1;
    }

    /**
     * Adds an edge to the Edge List Array
     * @param vertexID1 The source vertex
     * @param vertexID2 The target vertex
     * @param weight Weight of the new vertex
     * @return Returns true if the adding process is successful
     */
    @Override
    public boolean addEdge(int vertexID1, int vertexID2, double weight)
    {
        Edge addEdge = new Edge(vertexID1, vertexID2, weight);
        if(numEdge==capacity)
            reallocate();
        if(!this.isEdge(vertexID1, vertexID2))
        {
            insert(addEdge);
            numEdge++;
            return true;
        }

        return false;
    }

    /**
     * Removes an edge from the Edge List Array
     * @param vertexID1 The source vertex
     * @param vertexID2 The target vertex
     * @return Returns true if the adding process is done successfuly
     */
    @Override
    public boolean removeEdge(int vertexID1, int vertexID2)
    {
        Iterator<Edge> iter = edgeIterator(vertexID1);
        while (iter.hasNext())
        {
            if(vertexID2==iter.next().getDest())
            {
                iter.remove();
                --numEdge;
                return true;
            }
        }

        if(!isDirected())
        {
            iter = edgeIterator(vertexID2);
            while (iter.hasNext())
            {
                if(vertexID1==iter.next().getDest())
                {
                    iter.remove();
                    --numEdge;
                    return true;
                }
            }
        }

        return true;
    }

    /**
     * Remove the vertices that have the given label from the graph.
     * @param vertexID Label of the target vertex
     * @return Return true if the removing process is done successfully
     */
    @Override
    public Vertex removeVertex(int vertexID)
    {
        for(int i=0;i<numEdge;++i)
        {
            Iterator<Edge> iter = this.edgeIterator(i);
            while(iter.hasNext())
            {
                boolean delete = false; // Indicates whether there is need to delete the edge
                Edge currentEdge = iter.next();
                int sourceID = currentEdge.getSource();
                int targetID = currentEdge.getDest();


                int listIndexofSource;
                int listIndexofTarget;

                // Search for the vertex ID
                if(sourceID<verList.size() && verList.get(sourceID).getID()==sourceID)
                    listIndexofSource = sourceID;
                else listIndexofSource = findVertexIndex(sourceID);

                // Search for the vertex ID
                if(targetID<verList.size() && verList.get(targetID).getID()==targetID)
                    listIndexofTarget = targetID;
                else listIndexofTarget = findVertexIndex(targetID);


                // If the vertex is in the vertex list, remove it
                if(listIndexofSource==-1 || verList.get(listIndexofSource).getID()==vertexID)
                {
                    if(listIndexofSource!=-1)
                    {
                        verList.remove(listIndexofSource);
                        --numV;
                    }

                    delete = true;
                }

                // If the vertex is in the vertex list, remove it
                if(listIndexofTarget==-1 || verList.get(listIndexofTarget).getID()==vertexID)
                {
                    if(listIndexofTarget!=-1)
                    {
                        verList.remove(listIndexofTarget);
                        --numV;
                    }

                    delete = true;
                }

                // Delete the edge
                if(delete)
                    iter.remove();
            }
        }

        return null;
    }

    /**
     * Remove the vertices that have the given label from the graph.
     * @param label Label of the target vertex
     * @return Return true if the removing process is done successfully
     */
    @Override
    public Vertex removeVertex(String label) {
        for(int i=0;i<numEdge;++i)
        {
            Iterator<Edge> iter = this.edgeIterator(i);
            while(iter.hasNext())
            {
               boolean delete = false; // Indicates whether there is need to delete the edge
               Edge currentEdge = iter.next();
               int sourceID = currentEdge.getSource();
               int targetID = currentEdge.getDest();


                int listIndexofSource;
                int listIndexofTarget;

                // Search for the vertex ID
                if(sourceID<verList.size() && verList.get(sourceID).getID()==sourceID)
                    listIndexofSource = sourceID;
                else listIndexofSource = findVertexIndex(sourceID);

                // Search for the vertex ID
                if(targetID<verList.size() && verList.get(targetID).getID()==targetID)
                    listIndexofTarget = targetID;
                else listIndexofTarget = findVertexIndex(targetID);


                // If the vertex is in the vertex list, remove it
               if(listIndexofSource==-1 || verList.get(listIndexofSource).getLabel()==label)
               {
                   if(listIndexofSource!=-1)
                       verList.remove(listIndexofSource);


                   delete = true;
               }

                // If the vertex is in the vertex list, remove it
               if(listIndexofTarget==-1 || verList.get(listIndexofTarget).getLabel()==label)
               {
                   if(listIndexofTarget!=-1)
                       verList.remove(listIndexofTarget);

                   delete = true;
               }

                // Delete the edge
               if(delete)
               {
                   iter.remove();
                   numEdge--;
               }
            }
        }

        return null;
    }

    /**
     * Generate the adjacency matrix representation of the graph and returns the matrix.
     * @return Return true if the exporting process is done successfully
     */
    @Override
    public MyGraph filterVertices(String key, String filter)
    {
        MyGraph newGraph = new MyGraph(25,this.directed);
        newGraph.numEdge = this.numEdge;
        newGraph.numV = this.numV;

        for(int i=0;i<numEdge;++i)
        {
            Iterator<Edge> iter = this.edgeIterator(i);

            while(iter.hasNext())
            {
                boolean addEdge = true;
                Edge currentEdge = iter.next();
                int sourceID = currentEdge.getSource();
                int targetID = currentEdge.getDest();

                int listIndexofSource; // Vertex list ID that including ID matches edge source and destination ID
                int listIndexofTarget; // Vertex list ID that including ID matches edge source and destination ID


                if(sourceID<verList.size() && verList.get(sourceID).getID()==sourceID)
                    listIndexofSource = sourceID;

                else listIndexofSource = findVertexIndex(sourceID);


                if(targetID<verList.size() && verList.get(targetID).getID()==targetID)
                    listIndexofTarget = targetID;

                else listIndexofTarget = findVertexIndex(targetID);


                if(listIndexofSource!=-1 && Objects.equals(verList.get(listIndexofSource).getProperty(key), filter))
                {
                    if(newGraph.findVertexIndex(listIndexofSource)==-1)
                        newGraph.addVertex(verList.get(listIndexofSource));

                }

                else
                    addEdge=false;

                if(listIndexofTarget!=-1 && Objects.equals(verList.get(listIndexofTarget).getProperty(key), filter))
                {
                    if(newGraph.findVertexIndex(listIndexofTarget)==-1)
                        newGraph.addVertex(verList.get(listIndexofTarget));


                }

                else
                    addEdge=false;

                if(addEdge)
                {
                    newGraph.addEdge(listIndexofSource, listIndexofTarget, currentEdge.getWeight());
                }

            }
        }

        return newGraph;
    }


    @Override
    public double[][] exportMatrix() {
        double [][] matrix;

        matrix = new double[getNumV()][];
        if (!directed) {
            for (int i = 0; i != getNumV(); ++i) {
                matrix[i] = new double[getNumV()];
                for (int j = 0; j != getNumV(); ++j) {
                    matrix[i][j] = 0;
                }
            }
        }
        else {
            for (int i = 0; i != getNumV(); ++i) {
                matrix[i] = new double[getNumV()];
                for (int j = 0; j != getNumV(); ++j) {
                    matrix[i][j] = 0;
                }
            }
        }

        for(int i=0;i != getNumV();++i)
        {
            Iterator<Edge> iter = edgeIterator(i);

            while(iter.hasNext())
            {
                  matrix[i][iter.next().getDest()]=1;
            }
        }
        return matrix;
    }

    @Override
    public void printGraph()
    {
        StringBuilder sb = new StringBuilder();

        for(int i=0;i<numV;++i)
        {
            System.out.println(edges[i].toString());
        }
        System.out.println();
        for(int i=0;i<verList.size();++i)
        {
            System.out.printf("VERTEX ID: %d\nLabel: %s\nWeight: %f\n\n",verList.get(i).getID(), verList.get(i).getLabel(), verList.get(i).getWeight());
        }

    }

    // Accessor Methods
    /** Return the number of edges.
     @return The number of edges
     */
    public int getNumE() {
        return numEdge;
    }

    // Accessor Methods
    /** Return the number of vertices.
     @return The number of vertices
     */
    public int getNumV()
    {
        return verList.size();
    }

    /**
     * Returns a vertex with given ID
     * @param ID target ID
     * @return Returns the found Vertex
     */
    public Vertex getVertex(int ID)
    {
        if(ID>=verList.size() || ID<0) return null;
        if(verList.get(ID).getID()==ID) return verList.get(ID);// add

        int VertexIndex = findVertexIndex(ID);
        if(VertexIndex!=-1) return verList.get(VertexIndex);
        else return null;
    }

    /** Determine whether this is a directed graph.
            @return true if this is a directed graph
     */
    @Override
    public boolean isDirected() {
        return directed;
    }

    @Override
    public void insert(Edge edge) {
        edges[edge.getSource()].add(edge);
        if (!isDirected() && !this.isEdge(edge.getDest(), edge.getSource())) {
            edges[edge.getDest()].add(new Edge(edge.getDest(), edge.getSource(), edge.getWeight()));
        }
    }

    /** Determine whether an edge exists.
     @param source The source vertex
     @param dest The destination vertex
     @return true if there is an edge from source to dest
     */
    @Override
    public boolean isEdge(int source, int dest) {
        if(source<0 || source>=numEdge) return false;

        if(edges[source].contains(new Edge(source,dest)))
            return true;
        else
            return false;
    }

    /** Get the edge between two vertices.
     @param source The source vertex
     @param dest The destination vertex
     @return The Edge between these two vertices
     or an Edge with a weight of
     Double.POSITIVE_INFINITY if there is no edge
     */
    @Override
    public Edge getEdge(int source, int dest) {
        Edge target =
                new Edge(source, dest, Double.POSITIVE_INFINITY);
        for (Edge edge : edges[source]) {
            if (edge.equals(target))
                return edge; // Desired edge found, return it.
        }
        // Assert: All edges for source checked.
        return target; // Desired edge not found.
    }

    /** Return an iterator to the edges connected
     to a given vertex.
     @param source The source vertex
     @return An Iterator<Edge> to the vertices
     connected to source
     */
    @Override
    public Iterator<Edge> edgeIterator(int source) {
        return edges[source].iterator();
    }


    /**
     * Reallocates the Edge list array
     */
    public void reallocate()
    {
        LinkedList < Edge > [] newList;

        newList = new LinkedList[capacity*2];

        for(int i=0;i<numEdge;++i)
            newList[i] = edges[i];

        capacity = capacity*2;
        edges = newList;
    }

    /**
     * Print the graph in adjacency list format
     */
    public void printGraph(double matrix[][])
    {
       int row = matrix.length;
       int col = matrix[0].length;

       System.out.printf("%-5c",' ');
       for(int i=0;i<col;i++)
           System.out.printf("%-5d",i);
       System.out.println();

       for(int i=0;i<row;i++)
       {
           for(int j=0;j<col;j++)
           {
               if(j==0) System.out.printf("%-5d",i);
               System.out.printf("%-5.1f",matrix[i][j]);
           }
           System.out.println();
       }
    }

    /**
     * Return edge number from a vertex
     * @param index Target index
     * @return Returns the edge number
     */
    public int getEdgesFromVer(int index)
    {
        return edges[index].size();
    }
}
