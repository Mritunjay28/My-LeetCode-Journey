class Solution {
    int minCity = -1;
    int minCount = 1000;

    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        List<List<int[]>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int w = edges[i][2];

            adj.get(u).add(new int[] { v, w });
            adj.get(v).add(new int[] { u, w });
        }

        for (int i = 0; i < n; i++) {
            dijkstra(i, adj, distanceThreshold, n);
        }

        return minCity;
    }

    public void dijkstra(int src, List<List<int[]>> adj, int threshold, int n) {
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[] { src, 0 });

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int u = curr[0];
            int d = curr[1];

            if (d > dist[u]) continue;

            for (int[] nei : adj.get(u)) {
                int v = nei[0];
                int w = nei[1];

                if (dist[u] + w < dist[v]) {
                    dist[v] = dist[u] + w;
                    pq.offer(new int[] { v, dist[v] });
                }
            }
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            if (i != src && dist[i] <= threshold) {
                count++;
            }
        }

        if (count <= minCount) {
            minCount = count;
            minCity = src;
        }
    }
}