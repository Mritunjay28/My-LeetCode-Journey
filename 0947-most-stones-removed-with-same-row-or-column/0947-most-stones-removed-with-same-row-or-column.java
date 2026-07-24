class Solution {
    public int removeStones(int[][] stones) {
        int n=stones.length;
        List<Integer>[] adj = new List[n];
        for(int i=0;i<n;i++){
            adj[i]= new ArrayList<>();
        }

        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(stones[i][0]==stones[j][0] || stones[i][1]==stones[j][1] ){
                    adj[i].add(j);
                    adj[j].add(i);
                }
            }
        }

        boolean[] visited = new boolean[n];
        int trip=0;

        for(int i=0;i<n;i++){
            if(!visited[i]){
                dfs(visited,adj,i);
                trip++;
            }
        }

        return n-trip;
    }

    private void dfs( boolean[] visited,List<Integer>[] adj,int u){
        visited[u]=true;

        for(int v : adj[u]){
            if(!visited[v]) dfs(visited,adj,v);
        }
    }
}