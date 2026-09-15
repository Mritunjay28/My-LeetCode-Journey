class Graph {
    List<List<int[]>> adj;
    boolean[] visited;
    int n;

    public Graph(int n, int[][] edges) {
        this.n=n;
        adj = new ArrayList<>();
        visited = new boolean[n];
        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());

        for (int i = 0; i < edges.length; i++) {
            adj.get(edges[i][0]).add(new int[] { edges[i][1], edges[i][2] });
        }

    }

    public void addEdge(int[] edge) {
        adj.get(edge[0]).add(new int[] { edge[1], edge[2] });
    }

    public int shortestPath(int node1, int node2) {
       int[] dist = new int[n];
    Arrays.fill(dist, Integer.MAX_VALUE);

    PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));

    dist[node1] = 0;
    pq.offer(new int[]{node1, 0});

    while (!pq.isEmpty()) {
        int[] curr = pq.poll();
        int u = curr[0];
        int d = curr[1];

        if (u == node2) return d;

        // Skip outdated entries
        if (d > dist[u]) continue;

        for (int[] edge : adj.get(u)) {
            int v = edge[0];
            int weight = edge[1];

            if (dist[u] + weight < dist[v]) {
                dist[v] = dist[u] + weight;
                pq.offer(new int[]{v, dist[v]});
            }
        }
    }

    return -1;
    }
}

/**
 * Your Graph object will be instantiated and called as such:
 * Graph obj = new Graph(n, edges);
 * obj.addEdge(edge);
 * int param_2 = obj.shortestPath(node1,node2);
 */