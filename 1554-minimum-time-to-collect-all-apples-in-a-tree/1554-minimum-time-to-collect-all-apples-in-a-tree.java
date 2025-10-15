class Solution {
    int time=0;

    private boolean dfs( List<Boolean> hasApple,List<List<Integer>> adj,int u,boolean[] visited){
        visited[u]=true;
        boolean has = hasApple.get(u); 

        for (int v : adj.get(u)) {
            if (!visited[v]) {
                if (dfs( hasApple,adj, v, visited)) {
                    time += 2;
                    has = true;
                }
            }
        }

        return has;
    }



    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        for(int i=0;i<edges.length;i++){
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        } 
        boolean[] visited = new boolean[n];
       
        dfs(hasApple,adj,0,visited);
        return time;
    }
}