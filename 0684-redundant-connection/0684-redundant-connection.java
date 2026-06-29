class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;

        List<List<Integer>> adj = new ArrayList<>();

        for(int i=0;i<n;i++) adj.add(new ArrayList<>());

        for(int[] edge : edges){
            int u = edge[0]-1;
            int v = edge[1]-1;

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        for(int i=n-1;i>=0;i--){
            int u = edges[i][0]-1;
            int v = edges[i][1]-1;

            adj.get(u).remove((Integer) v);
            adj.get(v).remove((Integer) u);

            boolean[] visited = new boolean[n];

            dfs(u,visited,adj);

            boolean alltrue= true;
            for(int j=0;j<n;j++) {
                if(!visited[j]) {
                    alltrue=false;
                    break;
                }
            }

            if(alltrue) return edges[i];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        return new int[2];
    }

    public void dfs(int u ,boolean[] visited ,List<List<Integer>> adj){
        visited[u] = true;

        for(int v : adj.get(u)){
            if(visited[v]==false) dfs(v,visited,adj);
        }
    }
}