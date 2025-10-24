class Solution {
       int count=0;
    public int minReorder(int n, int[][] connections) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        for(int i=0;i<connections.length;i++) {
            adj.get(connections[i][0]).add(connections[i][1]);
            adj.get(connections[i][1]).add(-connections[i][0]);
        }

        boolean[] visited = new boolean[n];
       
        dfs(0,adj,visited);

        return count;
    }

    private void dfs(int u , List<List<Integer>> adj,boolean[] visited){
       visited[u] = true;
       for(int v : adj.get(u)){
        if(!visited[Math.abs(v)] ){
            if(v > 0) count++;
            dfs(Math.abs(v) ,adj,visited);
        }
       }

    }

}
/*
 4 case 
 1visted 1 not visited 
 1 not visited 1visted
 both visited
 both unvisited
*/