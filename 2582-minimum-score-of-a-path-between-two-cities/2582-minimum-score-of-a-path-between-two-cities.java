class Solution {
    public int minScore(int n, int[][] roads) {
        List<List<int[]>> adj = new ArrayList<>();
        for(int i=0;i<n+1;i++) adj.add(new ArrayList<>());
        for(int i=0;i<roads.length;i++){
            adj.get(roads[i][0]).add( new int[] {roads[i][1],roads[i][2]});
            adj.get(roads[i][1]).add( new int[] {roads[i][0],roads[i][2]});
        }

        int ans= Integer.MAX_VALUE;
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        boolean[] visited = new boolean[n+1];
        visited[1]=true;

        while(!q.isEmpty()){
            int u = q.poll();
            for(int[] v : adj.get(u)){
                ans=Math.min(ans,v[1]);
                if(!visited[v[0]]){
                    visited[v[0]]=true;
                    q.offer(v[0]);
                }
            }
        }

        return ans;
    }
}