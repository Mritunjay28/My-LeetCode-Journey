class Solution {
    public int[] findRedundantDirectedConnection(int[][] edges) {
    int n = edges.length;

        List<List<Integer>> adj = new ArrayList<>();

        for(int i=0;i<n;i++) adj.add(new ArrayList<>());

        int[] indegree = new int[n];

        for(int[] edge : edges){
            int u = edge[0]-1;
            int v = edge[1]-1;

            adj.get(u).add(v);
            indegree[v]++;
        }

        for(int i=n-1;i>=0;i--){
            int u = edges[i][0]-1;
            int v = edges[i][1]-1;
            int[] in = indegree.clone();

            adj.get(u).remove((Integer) v);
            in[v]--;

            int roots = 0;
            boolean ok = true;

            for (int x : in) {
                if (x == 0)
                    roots++;
                else if (x != 1) {
                    ok = false;
                    break;
                }
            }

            if (ok && roots == 1 && !isCycle(in, adj, n))
                return edges[i];

            adj.get(u).add(v);
        
        }

        return new int[2];
    }

    public boolean isCycle( int[] indegree ,List<List<Integer>> adj,int n){
        Queue<Integer> q = new LinkedList<>();
        

        int count=0;
        for(int i=0;i<n;i++) if(indegree[i]==0){
            q.add(i);
        }

        while(!q.isEmpty()){
            int u  = q.poll();
            count++;

            for(int v :adj.get(u)){
                indegree[v]--;

                if(indegree[v]==0) q.add(v);
            }
        }

        if(count==n) return false;


        return true;
    }
}