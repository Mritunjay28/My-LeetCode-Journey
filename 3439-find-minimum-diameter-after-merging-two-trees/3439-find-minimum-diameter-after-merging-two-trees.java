class Solution {
    public int minimumDiameterAfterMerge(int[][] edges1, int[][] edges2) {
        List<List<Integer>> adj1 = new ArrayList<>();
        for (int i = 0; i < edges1.length+1; i++)
            adj1.add(new ArrayList<>());
        for (int i = 0; i < edges1.length; i++) {
            int u = edges1[i][0];
            int v = edges1[i][1];
            adj1.get(u).add(v);
            adj1.get(v).add(u);
        }

        List<List<Integer>> adj2 = new ArrayList<>();
        for (int i = 0; i < edges2.length+1; i++)
            adj2.add(new ArrayList<>());
        for (int i = 0; i < edges2.length; i++) {
            int u = edges2[i][0];
            int v = edges2[i][1];
            adj2.get(u).add(v);
            adj2.get(v).add(u);
        }

        int mindia1 = 0, mindia2 = 0;
        int vlast1  = bfs(adj1, 0, edges1.length+1,true);
        int vlast2  = bfs(adj2, 0, edges2.length+1,true);
    
        mindia1 = Math.max(mindia1,bfs(adj1, vlast1, edges1.length+1,false) );
        mindia2 = Math.max(mindia2, bfs(adj2, vlast2, edges2.length+1,false) );

      int merged = Math.max(Math.max(mindia1-1, mindia2-1),(int) Math.ceil((mindia1-1) / 2.0) + (int) Math.ceil((mindia2-1) / 2.0) + 1);

        return merged;

    }

    private int bfs(List<List<Integer>> adj, int i, int len,boolean dia) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[len];
        q.offer(i);
        visited[i] = true;
        int diameter = 0;
        int last=0;

        while (!q.isEmpty()) {
            int l = q.size();
            for (int j = 0; j < l; j++) {
                int u = q.poll();
                last=u;
                for (int v : adj.get(u)) {
                    if (!visited[v]){
                        q.offer(v);
                        visited[v]=true;
                    }  
                }
            }

            diameter++;
        }
        if(dia) return last;
        return diameter;
    }
}

/*
    thinking that if traverse both graph and find vertice in graph with max diameter then add both +1
    T.C - travel whole graph by vertices (V) * travel all edge (E) = V1E1 + V2E2 
 */