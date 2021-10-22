public class DijkstrasAlgorithm_FarthestVertex {


    /**
     * Implement Dijkstra's Algorithm to find the "most distant vertex"
     * from a given starting vertex in a graph. The most distant vertex is
     * the one whose shortest path from the starting node is the longest
     * among all nodes in the graph. You can assume that graphs are always
     * connected and undirected.
     *
     * @param startingVertex the starting vertex
     *
     * @param adjacencyCostMatrix  an ajdacency matrix that also stores cost
     * 		                        0 -> no connection
     * 		                        i != 0 -> cost of i
     *
     * @return the distance to the most distant vertex
     */

    public int farthestVertex(int startingVertex, int[][] adjacencyCostMatrix)
    {
        // YOUR CODE HERE

        // defining the number of vertices in the graph
        int numberOfVertices = adjacencyCostMatrix[0].length;

        // shortestDistances[i] holds the shortest distance from the starting vertex to every other vertex
        int[] shortestDistancesArray = new int[numberOfVertices];

        // added[i] is true if the vertex i is included in shortest path or shortest distance from the starting vertex to another vertex i is finalized
        boolean[] added = new boolean[numberOfVertices];

        // Initialize all distances as INFINITE and added[] as false
        for (int vertexIndex = 0; vertexIndex < numberOfVertices; vertexIndex++) {
            shortestDistancesArray[vertexIndex] = Integer.MAX_VALUE;
            added[vertexIndex] = false;
        }

        // Distance of the starting vertex from itself is always 0
        shortestDistancesArray[startingVertex] = 0;

        // Parent array to store shortest path
        int[] parents = new int[numberOfVertices];

        // the starting vertex does not have a path (predecessor)
        parents[startingVertex] = -1;

        // iterating over every vertex and finding the shortest path for every vertex
        for(int i = 1; i < numberOfVertices; i++) {

            // initializing the nearest vertex. It is always equal to the starting vertex in the first iteration
            int nearestVertex = -1;

            // initializing the shortest distance
            int shortestDistance = Integer.MAX_VALUE;

            // iterating over the vertices and select the shortest distance vertex from all vertices which are not processed yet
            for (int vertexIndex = 0; vertexIndex < numberOfVertices; vertexIndex++) {
                if(!added[vertexIndex] && shortestDistancesArray[vertexIndex] < shortestDistance) {
                    nearestVertex = vertexIndex;
                    shortestDistance = shortestDistancesArray[vertexIndex];
                }
            }

            // the picked vertex is then marked as processed
            added[nearestVertex] = true;

            // updating the distance value of the adjacent vertices of the picked vertex
            for (int vertexIndex = 0; vertexIndex < numberOfVertices; vertexIndex++) {

                int edgeDistance = adjacencyCostMatrix[nearestVertex][vertexIndex];

                if(edgeDistance > 0 && ((shortestDistance + edgeDistance) < shortestDistancesArray[vertexIndex])) {
                    parents[vertexIndex] = nearestVertex;
                    shortestDistancesArray[vertexIndex] = shortestDistance + edgeDistance;
                }

            }
        }

        // all shortest distances are stored in the shortestDistancesArray and now we have to find the greatest value
        // because we want to find the most distant vertex
        // therefore we sort the array ascending (for optimizing run time) and then select the last value of the array, which is the greatest value then
        quickSort(shortestDistancesArray, 0, shortestDistancesArray.length-1);
        return shortestDistancesArray[shortestDistancesArray.length-1];

    }

    // method for sorting the array (quicksort algorithm)

    public void quickSort(int arr[], int begin, int end) {
        if (begin < end) {
            int partitionIndex = partition(arr, begin, end);

            quickSort(arr, begin, partitionIndex-1);
            quickSort(arr, partitionIndex+1, end);
        }
    }
    private int partition(int arr[], int begin, int end) {
        int pivot = arr[end];
        int i = (begin-1);

        for (int j = begin; j < end; j++) {
            if (arr[j] <= pivot) {
                i++;

                int swapTemp = arr[i];
                arr[i] = arr[j];
                arr[j] = swapTemp;
            }
        }

        int swapTemp = arr[i+1];
        arr[i+1] = arr[end];
        arr[end] = swapTemp;

        return i+1;
    }



}
