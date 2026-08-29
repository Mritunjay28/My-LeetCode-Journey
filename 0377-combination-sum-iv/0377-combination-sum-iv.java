class Solution {
    public int combinationSum4(int[] nums, int target) {
        // return f(nums,target);
        int n = nums.length;
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int j = 1; j <= target; j++) {
            int count = 0;
            for (int i = 0; i < nums.length; i++) {
                if (j - nums[i] >= 0) count += dp[j-nums[i]];
            }
            dp[j] = count;
        }

        return dp[target];
    }

    public int f(int[] nums, int target) {
        if (target == 0)
            return 1;

        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (target - nums[i] >= 0)
                count += f(nums, target - nums[i]);
        }

        return count;
    }
}