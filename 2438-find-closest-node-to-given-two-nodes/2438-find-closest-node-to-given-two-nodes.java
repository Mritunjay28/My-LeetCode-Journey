class Solution {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int n=edges.length;
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        for(int i=0;i<n;i++) {
            if(edges[i]==-1) continue;
            adj.get(i).add(edges[i]);
        }

        int[] distance1 = new int[n];
        Arrays.fill(distance1,-1);
        boolean[] visited = new boolean[n];
        dfs(node1,adj,distance1,0,visited);

        int[] distance2 = new int[n];
        Arrays.fill(distance2,-1);
        visited = new boolean[n];
        dfs(node2,adj,distance2,0,visited);

        int ans=-1;
        int mindist =10000000;
       for(int i=0;i<n;i++){
        if(distance1[i]!=-1 && distance2[i]!=-1 ){
            int maxdist = Math.max(distance1[i], distance2[i]);
            if(mindist>maxdist){
                mindist=maxdist;
                ans=i;
            }
        }
       }

       return  ans;

    }

    private void dfs(int node , List<List<Integer>> adj, int[] distance , int level, boolean[] visited){
        visited[node]=true;
        distance[node]=level;
        for(int v : adj.get(node)){
            if(!visited[v]){
                dfs(v,adj,distance,level+1,visited);
            }
        }
    }
}