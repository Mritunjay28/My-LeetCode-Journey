class Solution {
    public int deleteAndEarn(int[] nums) {
        int[] freq = new int[10001];
        for(int i=0;i<nums.length;i++){
            freq[nums[i]]++;
        }

        int[] dp = new int[10001];

        dp[1]=freq[1];
        int sum = freq[1];
        int max =dp[1];
        for(int i=2;i<10001;i++){
           dp[i] = Math.max(dp[i-1] , (i*freq[i])+dp[i-2]);
        }

        return dp[10000];
    }
}