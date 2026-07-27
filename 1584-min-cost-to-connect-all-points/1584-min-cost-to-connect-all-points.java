class Solution {
    int[] parent;
    int[] rank;
    public int minCostConnectPoints(int[][] points) {
       List<int[]> edges = new ArrayList<>();

        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                int weight = Math.abs(points[i][0] - points[j][0]) +
                            Math.abs(points[i][1] - points[j][1]);

                edges.add(new int[]{i, j, weight}); // {u, v, weight} // i,j indexs of points not values
            }
        }

        edges.sort((a,b)-> Integer.compare(a[2], b[2]));


        int n =points.length;
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;

        int sum=0;
        int edgecount=0;
        for(int[] curr : edges){
            int u = curr[0];
            int v = curr[1];
            int w = curr[2];

            int pu = find(u);
            int pv = find(v);

            if(pu==pv) continue;
            edgecount++;
            sum+=w;
            union(u,v);
            if(edgecount == n-1) break;
        }

        return sum;
    }

    public int find(int x){
        if(parent[x]==x) return x;

        return parent[x] = find(parent[x]);
    }

    public void union (int x ,int y ){
        int parentx = find(x);
        int parenty = find(y);

        if(parentx==parenty) return;

        if(rank[parentx] > rank[parenty]){
            parent[parenty]=parentx;
        }
        else if(rank[parentx] < rank[parenty]){
            parent[parentx]=parenty;
        }
        else{
             parent[parenty]=parentx;
             rank[parentx]++;
        }
    }


}