class Solution {
    public int maxProduct(int[] nums) {
        int ans=Integer.MIN_VALUE;
        for(int i:nums){
            ans=Math.max(ans,i);
        }
        int currmax=1,currmin=1;

        for(int i:nums){
            int temp= currmax*i;
            currmax=Math.max(temp,Math.max(currmin*i,i));
            currmin=Math.min(temp,Math.min(currmin*i,i));

            ans=Math.max(ans,currmax);
        }
        return ans;
    }
}