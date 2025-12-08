class Solution {
    public boolean isBipartite(int[][] graph) {
        List<List<Integer>> adj = new ArrayList<>();
        int n= graph.length;
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<graph[i].length;j++){
                adj.get(i).add(graph[i][j]);
            }
        }

        int[] colour = new int[n];
        Arrays.fill(colour,-1);

        for(int i=0;i<n;i++){
            if(colour[i]==-1 && !dfs(adj,i,colour,1)) return false;
        }
        return true;
    }

    public boolean dfs(List<List<Integer>> adj,int u,int[] colour,int col){
        if(colour[u]==-1) colour[u]=col;
        for(int v : adj.get(u)){
            if(colour[v]==-1 && !dfs(adj,v,colour,1-col)) return false;
            else if(colour[v]==col) return false;
        }
        return true;
    }
}