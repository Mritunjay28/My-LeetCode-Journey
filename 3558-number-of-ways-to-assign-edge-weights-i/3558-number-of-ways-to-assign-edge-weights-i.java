class Solution {
    int maxdepth=0 ;
    int mod = (int) 1e9 +7 ;
    public int assignEdgeWeights(int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();

        int l = edges.length;
        int n=l+1;

        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<l;i++){
            int u = edges[i][0];
            int v= edges[i][1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        boolean[] visited = new boolean[n+1];
        findMaxDepth(1,visited,0,adj);

        if(maxdepth==0) return 0;
        return power(2,maxdepth-1);
    }

    private int power(long base, long exp) {
        long res = 1;
        base = base % mod;
        while (exp > 0) {
            if (exp % 2 == 1) {
                res = (res * base) % mod;
            }
            base = (base * base) % mod;
            exp /= 2;
        }
        return (int) res;
    }

  

    public void findMaxDepth(int u,boolean[] visited , int h,  List<List<Integer>> adj){
        visited[u]=true;

        if(h>maxdepth)  maxdepth=h;

        for( int v : adj.get(u)){
            if(!visited[v]) findMaxDepth(v,visited,h+1,adj);
        }
    }
}