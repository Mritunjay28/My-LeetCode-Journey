class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n=isConnected.length;


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