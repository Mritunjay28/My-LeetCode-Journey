class Solution {
    public int[] countSubTrees(int n, int[][] edges, String labels) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        } 
        for(int i=0;i<edges.length;i++){
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }

        int[] ans = new int[n];

        dfs(0,-1,adj,labels,ans);
        return ans;
    }

    private int[] dfs(int u,int parent, List<List<Integer>> adj,String labels,int[] ans){
         int[] count = new int[26];
        for (int child : adj.get(u)) {
            if (child == parent) continue;
            int[] childCount = dfs(child, u, adj, labels, ans);
            for (int i = 0; i < 26; i++) count[i] += childCount[i];
        }

        count[labels.charAt(u) - 'a']++;

        ans[u] = count[labels.charAt(u) - 'a'];

        return count;
    }
}