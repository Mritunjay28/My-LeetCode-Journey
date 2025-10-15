class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int n = graph.length;
        List<List<Integer>> ans = new ArrayList<>();

        dfs(0,n-1,graph,ans,new ArrayList<>());

        return ans;
    }

    private void dfs(int s,int end ,int[][] graph,List<List<Integer>> ans,List<Integer> comb ){
        if(s==end){
            comb.add(s);
            ans.add(new ArrayList<>(comb));
            comb.remove(comb.size()-1);
            return ;
        }
        comb.add(s);
        for(int i=0;i<graph[s].length;i++){
            dfs(graph[s][i],end,graph,ans,comb);
        }
        comb.remove(comb.size()-1);
    }
}