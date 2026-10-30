class Solution {
    public int shortestPath(int n, int[][] edges, String labels, int k) {
        List<int[]>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();
        for (int[] edge : edges) adj[edge[0]].add(new int[]{edge[1], edge[2]});

        long[][] dist = new long[n][k + 1];
        for (long[] row : dist) Arrays.fill(row, Integer.MAX_VALUE);

        // {distance, node, count}
        PriorityQueue<long[]> pq =new PriorityQueue<>((a, b) -> Long.compare(a[0], b[0]));

        dist[0][1] = 0;
        pq.offer(new long[]{0, 0, 1});

        while (!pq.isEmpty()) {
            long[] cur = pq.poll();
            long d = cur[0];
            int u = (int) cur[1];
            int count = (int) cur[2];

            if (d != dist[u][count]) continue;

            for (int[] vec : adj[u]) {
                int v = vec[0], w = vec[1];
                int newcount = (labels.charAt(v) == labels.charAt(u)) ? count + 1 : 1;
                if (newcount > k) continue;

                if (dist[v][newcount] > d + w) {
                    dist[v][newcount] = d + w;
                    pq.offer(new long[]{dist[v][newcount], v, newcount});
                }
            }
        }

        long ans = Integer.MAX_VALUE;
        for (int i = 1; i <= k; i++) ans = Math.min(ans, dist[n - 1][i]);
        return ans == Integer.MAX_VALUE ? -1 : (int) ans;
    }
}