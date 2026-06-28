class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());

        for(int i=0;i<edges.length;i++){
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }

        boolean[] visited = new boolean[n];
        dfs(source,destination,adj,visited);

        return visited[destination];
    }

    private void dfs(int s , int end , List<List<Integer>> adj, boolean[] visited ){
        visited[s]=true;
        if(s==end) return ;

        for(int v : adj.get(s)){
            if(!visited[v]) dfs(v,end,adj,visited);
        }
        
    }
}