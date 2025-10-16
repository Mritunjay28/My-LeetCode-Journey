class Solution {
    public int[] countSubTrees(int n, int[][] edges, String labels) {
        List<HashMap<Integer,Integer>> list = new ArrayList<>();
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            list.add(new HashMap<>());
            adj.add(new ArrayList<>());
        } 
        for(int i=0;i<edges.length;i++){
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }

        int[] ans = new int[n];

        dfs(0,-1,adj,list,labels,ans);
        return ans;
    }

    private HashMap<Integer,Integer> dfs(int u,int parent, List<List<Integer>> adj,List<HashMap<Integer,Integer>> list,String labels,int[] ans){
        HashMap<Integer,Integer> freq = new HashMap<>();
        int label = labels.charAt(u) - 'a';
        freq.put(label, 1);

        for(int v : adj.get(u)){
            if(v==parent) continue;
            HashMap<Integer,Integer> childFreq = dfs(v,u,adj,list,labels, ans);

            for (var entry : childFreq.entrySet()) {
                freq.put(entry.getKey(), freq.getOrDefault(entry.getKey(), 0) + entry.getValue());
            }
            
        }

        list.set(u, freq);
        ans[u] = freq.get(label);
        return freq;
    }
}