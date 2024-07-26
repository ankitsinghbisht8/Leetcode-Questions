Approach 1: Dijkstra Algorithm

  class Solution {

    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        // Adjacency list to store the graph
        List<int[]>[] adjacencyList = new List[n];
        // Matrix to store shortest path distances from each city
        int[][] shortestPathMatrix = new int[n][n];

        // Initialize adjacency list and shortest path matrix
        for (int i = 0; i < n; i++) {
            Arrays.fill(shortestPathMatrix[i], Integer.MAX_VALUE); // Set all distances to infinity
            shortestPathMatrix[i][i] = 0; // Distance to itself is zero
            adjacencyList[i] = new ArrayList<>();
        }

        // Populate the adjacency list with edges
        for (int[] edge : edges) {
            int start = edge[0];
            int end = edge[1];
            int weight = edge[2];
            adjacencyList[start].add(new int[] { end, weight });
            adjacencyList[end].add(new int[] { start, weight }); // For undirected graph
        }

        // Compute shortest paths from each city using Dijkstra's algorithm
        for (int i = 0; i < n; i++) {
            dijkstra(n, adjacencyList, shortestPathMatrix[i], i);
        }

        // Find the city with the fewest number of reachable cities within the distance threshold
        return getCityWithFewestReachable(
            n,
            shortestPathMatrix,
            distanceThreshold
        );
    }

    // Dijkstra's algorithm to find shortest paths from a source city
    void dijkstra(
        int n,
        List<int[]>[] adjacencyList,
        int[] shortestPathDistances,
        int source
    ) {
        // Priority queue to process nodes with the smallest distance first
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a, b) ->
            (a[1] - b[1])
        );
        priorityQueue.add(new int[] { source, 0 });
        Arrays.fill(shortestPathDistances, Integer.MAX_VALUE); // Set all distances to infinity
        shortestPathDistances[source] = 0; // Distance to source itself is zero

        // Process nodes in priority order
        while (!priorityQueue.isEmpty()) {
            int[] current = priorityQueue.remove();
            int currentCity = current[0];
            int currentDistance = current[1];
            if (currentDistance > shortestPathDistances[currentCity]) {
                continue;
            }

            // Update distances to neighboring cities
            for (int[] neighbor : adjacencyList[currentCity]) {
                int neighborCity = neighbor[0];
                int edgeWeight = neighbor[1];
                if (
                    shortestPathDistances[neighborCity] >
                    currentDistance + edgeWeight
                ) {
                    shortestPathDistances[neighborCity] = currentDistance +
                    edgeWeight;
                    priorityQueue.add(
                        new int[] {
                            neighborCity,
                            shortestPathDistances[neighborCity],
                        }
                    );
                }
            }
        }
    }

    // Determine the city with the fewest number of reachable cities within the distance threshold
    int getCityWithFewestReachable(
        int n,
        int[][] shortestPathMatrix,
        int distanceThreshold
    ) {
        int cityWithFewestReachable = -1;
        int fewestReachableCount = n;

        // Count number of cities reachable within the distance threshold for each city
        for (int i = 0; i < n; i++) {
            int reachableCount = 0;
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                } // Skip self
                if (shortestPathMatrix[i][j] <= distanceThreshold) {
                    reachableCount++;
                }
            }
            // Update the city with the fewest reachable cities
            if (reachableCount <= fewestReachableCount) {
                fewestReachableCount = reachableCount;
                cityWithFewestReachable = i;
            }
        }
        return cityWithFewestReachable;
    }
}


Approach 2 : Bellman-Ford Algorithm

  class Solution {

    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        // Large value to represent infinity
        int INF = (int) 1e9 + 7;
        // Matrix to store shortest path distances from each city
        int[][] shortestPathMatrix = new int[n][n];

        // Initialize shortest path matrix
        for (int i = 0; i < n; i++) {
            Arrays.fill(shortestPathMatrix[i], INF); // Set all distances to infinity
            shortestPathMatrix[i][i] = 0; // Distance to itself is zero
        }

        // Populate the matrix with initial edge weights
        for (int[] edge : edges) {
            int start = edge[0];
            int end = edge[1];
            int weight = edge[2];
            shortestPathMatrix[start][end] = weight;
            shortestPathMatrix[end][start] = weight; // For undirected graph
        }

        // Compute shortest paths from each city using Bellman-Ford algorithm
        for (int i = 0; i < n; i++) {
            bellmanFord(n, edges, shortestPathMatrix[i], i);
        }

        // Find the city with the fewest number of reachable cities within the distance threshold
        return getCityWithFewestReachable(
            n,
            shortestPathMatrix,
            distanceThreshold
        );
    }

    // Bellman-Ford algorithm to find shortest paths from a source city
    void bellmanFord(
        int n,
        int[][] edges,
        int[] shortestPathDistances,
        int source
    ) {
        // Initialize distances from the source
        Arrays.fill(shortestPathDistances, Integer.MAX_VALUE);
        shortestPathDistances[source] = 0; // Distance to source itself is zero

        // Relax edges up to n-1 times
        for (int i = 1; i < n; i++) {
            for (int[] edge : edges) {
                int start = edge[0];
                int end = edge[1];
                int weight = edge[2];
                // Update shortest path distances if a shorter path is found
                if (
                    shortestPathDistances[start] != Integer.MAX_VALUE &&
                    shortestPathDistances[start] + weight <
                    shortestPathDistances[end]
                ) {
                    shortestPathDistances[end] = shortestPathDistances[start] +
                    weight;
                }
                if (
                    shortestPathDistances[end] != Integer.MAX_VALUE &&
                    shortestPathDistances[end] + weight <
                    shortestPathDistances[start]
                ) {
                    shortestPathDistances[start] = shortestPathDistances[end] +
                    weight;
                }
            }
        }
    }

    // Determine the city with the fewest number of reachable cities within the distance threshold
    int getCityWithFewestReachable(
        int n,
        int[][] shortestPathMatrix,
        int distanceThreshold
    ) {
        int cityWithFewestReachable = -1;
        int fewestReachableCount = n;

        // Count number of cities reachable within the distance threshold for each city
        for (int i = 0; i < n; i++) {
            int reachableCount = 0;
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                } // Skip self
                if (shortestPathMatrix[i][j] <= distanceThreshold) {
                    reachableCount++;
                }
            }
            // Update the city with the fewest reachable cities
            if (reachableCount <= fewestReachableCount) {
                fewestReachableCount = reachableCount;
                cityWithFewestReachable = i;
            }
        }
        return cityWithFewestReachable;
    }
}

Approach 3: Shortest Path First Algorithm (SPFA)

class Solution {

    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        // Adjacency list to store the graph
        List<int[]>[] adjacencyList = new List[n];
        // Matrix to store shortest path distances from each city
        int[][] shortestPathMatrix = new int[n][n];

        // Initialize adjacency list and shortest path matrix
        for (int i = 0; i < n; i++) {
            Arrays.fill(shortestPathMatrix[i], Integer.MAX_VALUE); // Set all distances to infinity
            shortestPathMatrix[i][i] = 0; // Distance to itself is zero
            adjacencyList[i] = new ArrayList<>();
        }

        // Populate the adjacency list with edges
        for (int[] edge : edges) {
            int start = edge[0];
            int end = edge[1];
            int weight = edge[2];
            adjacencyList[start].add(new int[] { end, weight });
            adjacencyList[end].add(new int[] { start, weight }); // For undirected graph
        }

        // Compute shortest paths from each city using SPFA algorithm
        for (int i = 0; i < n; i++) {
            spfa(n, adjacencyList, shortestPathMatrix[i], i);
        }

        // Find the city with the fewest number of reachable cities within the distance threshold
        return getCityWithFewestReachable(
            n,
            shortestPathMatrix,
            distanceThreshold
        );
    }

    // SPFA algorithm to find shortest paths from a source city
    void spfa(
        int n,
        List<int[]>[] adjacencyList,
        int[] shortestPathDistances,
        int source
    ) {
        // Queue to process nodes with updated shortest path distances
        Deque<Integer> queue = new ArrayDeque<>();
        // Array to track the number of updates for each node
        int[] updateCount = new int[n];
        queue.add(source);
        Arrays.fill(shortestPathDistances, Integer.MAX_VALUE); // Set all distances to infinity
        shortestPathDistances[source] = 0; // Distance to source itself is zero

        // Process nodes in queue
        while (!queue.isEmpty()) {
            int currentCity = queue.removeFirst();
            for (int[] neighbor : adjacencyList[currentCity]) {
                int neighborCity = neighbor[0];
                int edgeWeight = neighbor[1];

                // Update shortest path distance if a shorter path is found
                if (
                    shortestPathDistances[neighborCity] >
                    shortestPathDistances[currentCity] + edgeWeight
                ) {
                    shortestPathDistances[neighborCity] =
                        shortestPathDistances[currentCity] + edgeWeight;
                    updateCount[neighborCity]++;
                    queue.add(neighborCity);

                    // Detect negative weight cycles (not expected in this problem)
                    if (updateCount[neighborCity] > n) {
                        System.out.println("Negative weight cycle detected");
                    }
                }
            }
        }
    }

    // Determine the city with the fewest number of reachable cities within the distance threshold
    int getCityWithFewestReachable(
        int n,
        int[][] shortestPathMatrix,
        int distanceThreshold
    ) {
        int cityWithFewestReachable = -1;
        int fewestReachableCount = n;

        // Count number of cities reachable within the distance threshold for each city
        for (int i = 0; i < n; i++) {
            int reachableCount = 0;
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                } // Skip self
                if (shortestPathMatrix[i][j] <= distanceThreshold) {
                    reachableCount++;
                }
            }
            // Update the city with the fewest reachable cities
            if (reachableCount <= fewestReachableCount) {
                fewestReachableCount = reachableCount;
                cityWithFewestReachable = i;
            }
        }
        return cityWithFewestReachable;
    }
}


Approach 4: Floyd-Warshall Algorithm
  
  class Solution {

    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        // Large value to represent infinity
        int INF = (int) 1e9 + 7;
        // Distance matrix to store shortest paths between all pairs of cities
        int[][] distanceMatrix = new int[n][n];

        // Initialize distance matrix
        for (int i = 0; i < n; i++) {
            Arrays.fill(distanceMatrix[i], INF); // Set all distances to infinity
            distanceMatrix[i][i] = 0; // Distance to itself is zero
        }

        // Populate the distance matrix with initial edge weights
        for (int[] edge : edges) {
            int start = edge[0];
            int end = edge[1];
            int weight = edge[2];
            distanceMatrix[start][end] = weight;
            distanceMatrix[end][start] = weight; // For undirected graph
        }

        // Compute shortest paths using Floyd-Warshall algorithm
        floyd(n, distanceMatrix);

        // Find the city with the fewest number of reachable cities within the distance threshold
        return getCityWithFewestReachable(n, distanceMatrix, distanceThreshold);
    }

    // Floyd-Warshall algorithm to compute shortest paths between all pairs of cities
    void floyd(int n, int[][] distanceMatrix) {
        // Update distances for each intermediate city
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    // Update shortest path from i to j through k
                    distanceMatrix[i][j] = Math.min(
                        distanceMatrix[i][j],
                        distanceMatrix[i][k] + distanceMatrix[k][j]
                    );
                }
            }
        }
    }

    // Determine the city with the fewest number of reachable cities within the distance threshold
    int getCityWithFewestReachable(
        int n,
        int[][] distanceMatrix,
        int distanceThreshold
    ) {
        int cityWithFewestReachable = -1;
        int fewestReachableCount = n;

        // Count number of cities reachable within the distance threshold for each city
        for (int i = 0; i < n; i++) {
            int reachableCount = 0;
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                } // Skip self
                if (distanceMatrix[i][j] <= distanceThreshold) {
                    reachableCount++;
                }
            }
            // Update the city with the fewest reachable cities
            if (reachableCount <= fewestReachableCount) {
                fewestReachableCount = reachableCount;
                cityWithFewestReachable = i;
            }
        }
        return cityWithFewestReachable;
    }
}
