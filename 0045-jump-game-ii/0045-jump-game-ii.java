class Solution {
    public int jump(int[] nums) {
       
        int[] dp = new int[nums.length];
        Arrays.fill(dp,1000000);
        dp[0]=0;
        for (int i = 0; i < nums.length ; i++) {
            for (int j = 0; j < i; j++) {
                if (j + nums[j] >= i) {
                    dp[i] = Math.min(dp[i], dp[j] + 1);
                }
            }
        }

        return dp[nums.length-1];
    }
}