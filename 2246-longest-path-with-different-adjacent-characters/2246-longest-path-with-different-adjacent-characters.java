class Solution {
    int max=1;
    public int longestPath(int[] parent, String s) {
        int n=parent.length;
       List<List<Integer>> adj = new ArrayList<>();
       for(int i=0;i<n;i++) adj.add(new ArrayList<>());

       for(int i=1;i<n;i++) {
        adj.get(i).add(parent[i]);
        adj.get(parent[i]).add(i);
        }

        dfs(0,-1,adj,s);

        return max;
    }

    private int dfs(int u,int parent,List<List<Integer>> adj,String s){
        int longest=0,secondlongest=0;
        for(int v : adj.get(u)){
            if(v==parent) continue;
            int count= dfs(v,u,adj,s);
            if(s.charAt(v)==s.charAt(u)) continue;

            if(count>longest){
                secondlongest=longest;
                longest=count;
            }
            else if(secondlongest < count){
                secondlongest=count;
            }
        }

        max=Math.max(max,1+longest+secondlongest);

        return 1+longest ;
    }
}