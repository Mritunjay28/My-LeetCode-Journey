class Solution {
    public boolean canPartition(int[] nums) {
        int sum=0;
        for(int x : nums) sum+=x;

        if(sum%2!=0) return false;

        int target = sum/2;
        int n = nums.length;

        boolean[][] dp = new boolean[n+1][target+1];

        for(int i=0;i<=n;i++) dp[i][0] =true;
        for(int i=0;i<=target;i++) dp[0][i] =false;

        dp[0][0]=true;

        for(int i=1;i<=n;i++){
            for(int j=1;j<=target;j++){
                if(nums[i-1] <= j){
                    boolean take = dp[i-1][j-nums[i-1]];
                    boolean nottake = dp[i-1][j];

                    dp[i][j] = take || nottake;
                }
                else {
                    boolean nottake = dp[i-1][j];
                    dp[i][j] = nottake;
                }
            }
        }

        return dp[n][target];
    }
}