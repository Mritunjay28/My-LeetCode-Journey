class Solution {
    public int minCost(int n, int[][] edges) {
        List<List<int[]>> adj = new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        for(int i=0;i<edges.length;i++){
            adj.get(edges[i][0]).add(new int[] {edges[i][1],edges[i][2]}); // v,cost
            adj.get(edges[i][1]).add(new int[] {edges[i][0],2*edges[i][2]});
        }
        // boolean[] visited = new boolean[n];

        int[] dist = new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[0]=0;

        PriorityQueue<int[]> q = new PriorityQueue<>((a,b)->a[1]-b[1]);
        q.add(new int[] {0,0}); // u,cost 

        while(!q.isEmpty()){
            int[] curr = q.poll();
            int u= curr[0] , currweight =curr[1];
            if(currweight>dist[u]) continue;
            if(u==n-1) return currweight;

            for(int[] next : adj.get(u)){
                if(next[1]+currweight <dist[next[0]]){
                    dist[next[0]] = next[1]+currweight;
                    q.add(new int[] {next[0],next[1]+currweight});
                }
            }
        }

        return (dist[n-1]==Integer.MAX_VALUE) ? -1 : dist[n-1];
    }
}
// dijkastra 