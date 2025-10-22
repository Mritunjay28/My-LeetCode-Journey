class Solution {
        
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>> adj = new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        for(int i=0;i<flights.length;i++){
            adj.get(flights[i][0]).add(new int[] {flights[i][1],flights[i][2]});
        }
        int step=0;

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {src,0});

        int[] cost = new int[n];
        Arrays.fill(cost,Integer.MAX_VALUE);
        cost[src] = 0; 
        
        while(!q.isEmpty() && step<=k){
          int len = q.size();
          int[] temp = Arrays.copyOf(cost, n);
          for(int i=0;i<len;i++){
            int[] curr = q.poll();
            int u= curr[0] , price = curr[1];
        
            for(int[] v : adj.get(u)){
                 if (price+v[1] < temp[v[0]]) { 
                        temp[v[0]] = price+v[1];
                        q.offer(new int[]{v[0], price+v[1]});
                    }
            }
          }
          cost=temp;
          step++;
        }

        return (cost[dst]==Integer.MAX_VALUE) ? -1 :cost[dst];  
      
    }
}