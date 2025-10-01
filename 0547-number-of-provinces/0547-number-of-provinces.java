class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n=isConnected.length;
    //   List<List<Integer>> adj = new ArrayList<>();
    //   for(int i=0;i<isConnected.length;i++) adj.add(new ArrayList<>());

    //   for(int i=0;i<isConnected.length;i++){
    //     for(int j=0;j<isConnected[0].length;j++){
    //         if(i!=j && isConnected[i][j]==1) adj.get(i).add(j);
    //     }
    //   }

        boolean[] visited = new boolean[n];
        int count=0;
        for(int i=0 ; i<n;i++){
            if(!visited[i]){
                count++;
                dfs(i,visited,isConnected );
            }
        }
        return count;
    }

    private void dfs(int u,boolean[] visited , int[][] isConnected){
        visited[u]=true;

        for(int v=0 ;v< isConnected[u].length ;v++){
            if(!visited[v] && isConnected[u][v]==1 ){
                dfs(v,visited,isConnected);
            }
        }
    }
}