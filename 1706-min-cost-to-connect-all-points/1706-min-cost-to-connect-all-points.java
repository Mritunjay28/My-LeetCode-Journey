class Solution {
    public int minCostConnectPoints(int[][] points) {
        List<List<int[]>> adj = new ArrayList<>();
        for(int i=0;i<points.length;i++) adj.add(new ArrayList<>());

        for(int i=0;i<points.length;i++){
           for(int j=i+1;j<points.length;j++){
            int val = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
            adj.get(i).add(new int[] {j,val}); // u , v , weight
            adj.get(j).add(new int[] {i,val}); // u , v , weight
           }
        }

        PriorityQueue<int[]> q = new PriorityQueue<>((a,b)-> a[0]-b[0]);
        boolean[] ismst = new boolean[points.length];
        q.offer(new int[] {0,0});// weight,v
 
        int sum=0;

        while(!q.isEmpty()){
            int[] curr =q.poll();
            int w = curr[0];
            int u= curr[1];

            if(ismst[u]) continue;
            ismst[u]=true;
            sum+=w;

            for(int[] v : adj.get(u)){
                if(ismst[v[0]]) continue;
                q.add(new int[] {v[1],v[0]} );
            }
        }

        return sum;

    }
}