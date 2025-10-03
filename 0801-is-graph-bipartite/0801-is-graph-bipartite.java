class Solution {
    public boolean isBipartite(int[][] graph) {
      List<List<Integer>> adj = new ArrayList<>();  
      for(int i=0;i<graph.length;i++) adj.add(new ArrayList<>());

      for(int i=0;i<graph.length;i++){
        for(int j=0;j<graph[i].length;j++){
            adj.get(i).add(graph[i][j]);
        }
      }

      int[] colour =new int[graph.length];
      Arrays.fill(colour,-1);

      for(int i=0;i<graph.length;i++){
        if(colour[i]==-1 && !dfs(adj,i,colour,1)) return false;
      }

      return true;
    }

    private boolean dfs(List<List<Integer>> adj , int u , int[] colour , int currcolour){
        colour[u]=currcolour;

        for(int v : adj.get(u)){
            if(colour[v]==currcolour) return false;
            else if(colour[v]==-1 && !dfs(adj,v,colour,1-currcolour)) return false;
        }

        return true;
    }
}