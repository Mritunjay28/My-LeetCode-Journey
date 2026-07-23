class Solution {

    List<List<int[]>> graph;
    List<List<int[]>> reverseGraph;

    public long minimumWeight(int n, int[][] edges, int src1, int src2, int dest) {

        buildGraph(n, edges);

        long[] distFromSrc1 = dijkstra(src1, graph);
        long[] distFromSrc2 = dijkstra(src2, graph);
        long[] distToDest = dijkstra(dest, reverseGraph);

        long ans = Long.MAX_VALUE;

        for (int i = 0; i < n; i++) {

            if (distFromSrc1[i] == Long.MAX_VALUE ||
                distFromSrc2[i] == Long.MAX_VALUE ||
                distToDest[i] == Long.MAX_VALUE)
                continue;

            ans = Math.min(ans,
                    distFromSrc1[i] +
                    distFromSrc2[i] +
                    distToDest[i]);
        }

        return ans == Long.MAX_VALUE ? -1 : ans;
    }

    private void buildGraph(int n, int[][] edges) {

        graph = new ArrayList<>();
        reverseGraph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
            reverseGraph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            int weight = edge[2];

            graph.get(from).add(new int[]{to, weight});
            reverseGraph.get(to).add(new int[]{from, weight});
        }
    }

    private long[] dijkstra(int src, List<List<int[]>> graph) {

        long[] dist = new long[graph.size()];
        Arrays.fill(dist, Long.MAX_VALUE);

        PriorityQueue<long[]> pq =
                new PriorityQueue<>(Comparator.comparingLong(a -> a[1]));

        dist[src] = 0;
        pq.offer(new long[]{src, 0});

        while (!pq.isEmpty()) {

            long[] curr = pq.poll();

            int node = (int) curr[0];
            long currDist = curr[1];

            if (currDist > dist[node])
                continue;

            for (int[] neighbor : graph.get(node)) {

                int next = neighbor[0];
                int weight = neighbor[1];

                long newDist = currDist + weight;

                if (newDist < dist[next]) {
                    dist[next] = newDist;
                    pq.offer(new long[]{next, newDist});
                }
            }
        }

        return dist;
    }
}

/*
if we see all point from sr1 and scr2 meet at some common point and that common point leads to dest 

   src1
        \
         \
          i --------> dest
         /
        /
     src2


    we need 
    distance(src1 → i)
    distance(src2 → i)
    distance(i → dest)

    distance(src1 → i) , distance(src2 → i) are easy by dijkastra 

    but distance(i → dest) is difficult in original graph as have to travel from all point to dest 
    but if we reverse the edges  like 0 ----5----> 1 ----2----> 2 to 0 <----5---- 1 <----2---- 2

    now we see that it like we to find min distance  of dist to alll other point 

    then for answer we check all point
     
    MIN(src1[i] + src2[i] + dest[i]) 

*/