class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        permutation(nums,ans, new ArrayList<>(),visited);
        return ans;
    }

    private void permutation(int[] nums ,List<List<Integer>> ans , List<Integer> comb,boolean[] visited){
        if(comb.size() == nums.length){
            ans.add(new ArrayList<>(comb));
            return;
        }


        for(int i=0;i<nums.length;i++){
            if(!visited[i]){
                visited[i]=true;
                comb.add(nums[i]);
                permutation(nums,ans,comb,visited);
                visited[i]=false;
                comb.remove(comb.size()-1);
            }
        }
    }
}