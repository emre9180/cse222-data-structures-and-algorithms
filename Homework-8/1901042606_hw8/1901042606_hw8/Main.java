public class Main {

    public static void main(String[] args) {

        /* ********************************* TESTING THE PART 1 ********************************* */
        System.out.printf("********************************* TESTING THE PART 1 ********************************* \n\n\n");

        // Create the graph
        MyGraph graph1 = new MyGraph(25,true);

        // Create the vertices

        Vertex v1_1 = graph1.newVertex("Emre",3);
        v1_1.addProperty("color", "red");
        graph1.addVertex(v1_1);

        Vertex v1_2 = graph1.newVertex("Tuba",3);
        v1_2.addProperty("color", "black");
        graph1.addVertex(v1_2);

        Vertex v1_3 = graph1.newVertex("Jose",3);
        v1_3.addProperty("color", "black");
        graph1.addVertex(v1_3);

        Vertex v1_4 = graph1.newVertex("Bakal",3);
        v1_4.addProperty("color", "red");
        graph1.addVertex(v1_4);

        Vertex v1_5 = graph1.newVertex("Ozge",3);
        v1_5.addProperty("color", "red");
        graph1.addVertex(v1_5);

        Vertex v1_6 = graph1.newVertex("Yunus",3);
        v1_6.addProperty("color", "yellow");
        graph1.addVertex(v1_6);

        Vertex v1_7 = graph1.newVertex("Dilek",3);
        v1_7.addProperty("color", "green");
        graph1.addVertex(v1_7);

        System.out.printf("Some vertices has created successfuly...\n");
        // Add some edges

        graph1.addEdge(1,5,3);
        graph1.addEdge(1,4,4);
        graph1.addEdge(1,2,5);
        graph1.addEdge(4,2,3);
        graph1.addEdge(2,4,4);
        graph1.addEdge(2,3,5);
        graph1.addEdge(4,3,5);
        graph1.addEdge(6,3,5);
        graph1.addEdge(6,2,5);

        System.out.print("Some edges has created and added successfuly...\n");

        // Print the graph
        System.out.printf("The created directed graph is:\n\n");
        graph1.printGraph();

        // Test the exportMatrix method.
        System.out.printf("exportMatrix method is being tested...\n\nThe matrix that is created is:\n\n");
        double matrix[][] = graph1.exportMatrix();
        graph1.printGraph(matrix);

        // Testing filter method
        System.out.printf("\nFilter(COLOR,RED) method is testing...\nThe subgraph is:\n\n");
        MyGraph subGraph1 = graph1.filterVertices("color", "red");
        subGraph1.printGraph();

        // Remove vertices and edges
        System.out.printf("\n\nRemoving vertice-2...");
        graph1.removeVertex(2);
        System.out.printf("\nThe new graph is:\n\n");
        graph1.printGraph();

        System.out.printf("Removing edge from 4 to 3...");
        graph1.removeEdge(4,3);
        System.out.printf("\nThe new graph is:\n\n");
        graph1.printGraph();


        // Create the new undirected graph
        System.out.printf("\n\nNew graph is being created...\n");
        MyGraph graph2 = new MyGraph(20,false);

        // Create the vertices

        Vertex v2_1 = graph2.newVertex("Emre",3);
        v2_1.addProperty("color", "black");
        graph2.addVertex(v2_1);

        Vertex v2_2 = graph2.newVertex("Tuba",3);
        v2_2.addProperty("color", "black");
        graph2.addVertex(v2_2);

        Vertex v2_3 = graph2.newVertex("Jose",3);
        graph2.addVertex(v2_3);

        Vertex v2_4 = graph2.newVertex("Bakal",3);
        v2_4.addProperty("color", "black");
        graph2.addVertex(v2_4);

        Vertex v2_5 = graph2.newVertex("Ozge",3);
        v2_5.addProperty("color", "red");
        graph2.addVertex(v2_5);

        System.out.printf("Some vertices has created successfuly...\n");
        // Add some edges

        graph2.addEdge(0,1,3);
        graph2.addEdge(0,2,4);
        graph2.addEdge(0,4,5);
        graph2.addEdge(1,4,3);
        graph2.addEdge(1,2,4);
        graph2.addEdge(2,3,5);
        graph2.addEdge(3,4,5);
        graph2.addEdge(4,0,5);

        System.out.printf("Some edges has created and added successfuly...\n");

        // Print the graph
        System.out.printf("The created undirected graph is:\n\n");
        graph2.printGraph();

        // Test the exportMatrix method.
        System.out.printf("exportMatrix method is being tested...\n\nThe matrix that is created is:\n\n");
        double matrix2[][] = graph2.exportMatrix();
        graph2.printGraph(matrix2);

        // Testing filter method
        System.out.printf("\nFilter(COLOR,BLACK) method is testing...\nThe subgraph is:\n\n");
        MyGraph subGraph2 = graph2.filterVertices("color", "black");
        subGraph2.printGraph();

        // Remove vertices and edges
        System.out.printf("\n\nRemoving vertice-2...");
        graph2.removeVertex(2);
        System.out.printf("\nThe new graph is:\n\n");
        graph2.printGraph();

        System.out.printf("Removing edge from 0 to 4...");
        System.out.printf("Removing edge from 1 to 4...\n");
        graph2.removeEdge(0,4);
        graph2.removeEdge(1,4);
        System.out.printf("\nThe new graph is:\n\n");
        graph2.printGraph();





        /* ********************************* TESTING THE PART 2 ********************************* */

        System.out.printf("********************************* TESTING THE PART 2 ********************************* \n\n\n");

        // Creating one more graph to prove part-2 BFS part

        System.out.printf("A new GRAPH-4 is creating...The GRAPH-4:\n\n");

        MyGraph graph4 = new MyGraph(25,true);
        Vertex v41 = graph4.newVertex("test",3);
        v41.addProperty("color", "red");
        v41.addProperty("Boosting","5");
        graph4.addVertex(v41);

        Vertex v42 = graph4.newVertex("test",4);
        v42.addProperty("color", "red");
        v42.addProperty("Boosting","5");
        graph4.addVertex(v42);

        Vertex v43 = graph4.newVertex("test",5);
        v43.addProperty("Boosting","5");
        graph4.addVertex(v43);

        Vertex v44 = graph4.newVertex("test",5);
        v44.addProperty("Boosting","5");
        graph4.addVertex(v44);

        graph4.addEdge(0,1,3);
        graph4.addEdge(0,2,1);
        graph4.addEdge(2,3,6);
        graph4.addEdge(1,3,1);

        graph4.printGraph();

        int total = findTotalLength.findTotal(graph4);

        double totalDistance1 = findTotalLength.findTotal(graph4);

        System.out.printf("Calculating the total distance of the path in the GRAPH-4 for accessing each vertex during the traversal, and printing the difference between the total distances of two\n" +
                "traversal methods...\nTotal distance is: %f",totalDistance1);



        // Creating a new graph. This graph is from the textbook

        System.out.printf("\n\nNew GRAPH-5 is being created to test part-2 and part-3...GRAPH-5:\n\n");

        MyGraph graph3 = new MyGraph(25,true);
        Vertex v22 = graph3.newVertex("test",3);
        v22.addProperty("color", "red");
        v22.addProperty("Boosting","5");
        graph3.addVertex(v22);

        Vertex v23 = graph3.newVertex("test",4);
        v23.addProperty("color", "red");
        v23.addProperty("Boosting","5");
        graph3.addVertex(v23);

        Vertex v24 = graph3.newVertex("test",5);
        v24.addProperty("Boosting","5");
        graph3.addVertex(v24);

        Vertex v25 = graph3.newVertex("test",5);
        v25.addProperty("Boosting","5");
        graph3.addVertex(v25);

        Vertex v26 = graph3.newVertex("test",5);
        v26.addProperty("Boosting","5");
        graph3.addVertex(v26);

        graph3.addEdge(0,1,10);
        graph3.addEdge(0,4,100);
        graph3.addEdge(0,3,30);
        graph3.addEdge(1,2,50);
        graph3.addEdge(3,2,20);
        graph3.addEdge(3,4,60);
        graph3.addEdge(2,4,10);

        graph3.printGraph();
        double totalDistance2 = findTotalLength.findTotal(graph3);

        System.out.printf("Calculating the total distance of the path in the new graph (GRAPH-3) for accessing each vertex during the traversal, and printing the difference between the total distances of two\n" +
                "traversal methods...\nTotal distance is: %f",totalDistance2);










        /* ********************************* TESTING THE PART 3 ********************************* */

        System.out.printf("\n\n\n********************************* TESTING THE PART 3 ********************************* \n\n\n");
        double [] dis = new double[5];
        int [] pred = new int[5];

        double [] dis2 = new double[5];
        int [] pred2 = new int[5];

        DijkstrasAlgorithm.dijkstrasAlgorithm(graph3, 0, pred, dis);

        System.out.printf("The graph-3:\n\n");
        graph3.printGraph();

        System.out.printf("Result of the Dijkstra's Algorithm for graph-3:\n");
        for(int i=0;i<5;++i)
            System.out.println(dis[i]);










    }
}
