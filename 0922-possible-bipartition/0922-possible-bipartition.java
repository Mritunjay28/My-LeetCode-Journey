class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());

        for(int i=0;i<dislikes.length;i++) {
            int u=dislikes[i][0] , v=dislikes[i][1];
            adj.get(u-1).add(v-1);
            adj.get(v-1).add(u-1);
        }

        int[] colour = new int[n];
        Arrays.fill(colour,-1);

        for(int i=0;i<n;i++){
            if(colour[i]==-1 && !dfs(adj,i,colour,1)) return false;
        }

        return true;
    }

    private boolean dfs(List<List<Integer>> adj,int u,int[] colour,int currcolour){
        colour[u]=currcolour;

        for(int v : adj.get(u)){
            int nextcolour = 1-currcolour;
            if(colour[v]==-1 && !dfs(adj,v,colour,nextcolour)) return false;
            else if (colour[v]==currcolour) return false;
        }

        return true;
    }
}