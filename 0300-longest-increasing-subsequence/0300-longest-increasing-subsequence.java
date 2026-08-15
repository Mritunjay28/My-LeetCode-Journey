class Solution {
    public int lengthOfLIS(int[] nums) {
        int max = 0;
        int[] dp = new int[nums.length];
        for (int i = nums.length-1; i >=0; i--) {
            // max=Math.max(max,f(i,nums));

            int curr = 1;
            for (int j = nums.length - 1; j >= i; j--) {
                if (nums[i] < nums[j]) curr = Math.max(curr, 1 + dp[j]);
            }
            dp[i]=curr;
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public int f(int i, int[] nums) {

        int max = 1;
        for (int j = i + 1; j < nums.length; j++) {
            if (nums[i] < nums[j])
                max = Math.max(max, 1 + f(j, nums));
        }

        return max;
    }
}