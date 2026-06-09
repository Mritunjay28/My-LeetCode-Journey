class Solution {
    public long maxTotalValue(int[] nums, int k) {
        int max = 0,min=Integer.MAX_VALUE;
        for(int x : nums){
            max=Math.max(max,x);
            min=Math.min(min,x);
        }

        long ans = (long)(max-min)*k;
        return ans;
    }
}