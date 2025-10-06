class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {

        List<List<int[]>> adj = new ArrayList<>();
        for(int i=0;i<n+1;i++) adj.add(new ArrayList<>());

        for(int i=0;i<times.length;i++){
            adj.get(times[i][0]).add(new int[]{times[i][1],times[i][2]});//node,distance
        } 

        PriorityQueue<int[]> q = new PriorityQueue<>((a,b)-> a[0]-b[0]);
        int[] distance = new int[n+1];
        Arrays.fill(distance,Integer.MAX_VALUE);
        distance[0]=0;
        distance[k]=0;
        q.offer(new int[]{0,k});// distance,node

        while(!q.isEmpty()){
            int[] curr =q.poll();
            int currdistance= curr[0];
            int u = curr[1];

            for(int[] v : adj.get(u)){
                int adjnode = v[0];
                int newdistance = v[1];
                int totaldistance= newdistance+currdistance;
                if(totaldistance < distance[adjnode]){
                    distance[adjnode] = totaldistance;
                    q.offer(new int[]{totaldistance,adjnode});
                }
            }
        }

        int max=-1;
        for(int i : distance) {
            if(i==Integer.MAX_VALUE) return -1;
            max=Math.max(max,i);
        }

        return max;
    }
}