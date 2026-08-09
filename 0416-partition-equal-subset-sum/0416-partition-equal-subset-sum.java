class Solution {
    public boolean canPartition(int[] nums) {
        int sum=0;
        for(int i=0;i<nums.length;i++) sum+=nums[i];

        if(sum%2!=0) return false;

        int target = sum/2;
        // return f(0,target,nums);

        int n=nums.length;

        boolean[][] dp = new boolean [n+1][target+1];

        for(int i=0;i<=n;i++) dp[i][0] = true;
        
        for(int i=n-1;i>=0;i--){
            for(int j=1;j<=target;j++){
                boolean ispossible = false;
                if(j-nums[i]>=0) ispossible|= dp[i+1][j-nums[i]];
                ispossible|= dp[i+1][j];

                dp[i][j] = ispossible;
            }
        }

        return dp[0][target];

    }

    // public boolean f(int i, int target, int[] nums) {
    //     if (target == 0) return true;
    //     if (i >= nums.length) return false;

    //     boolean ispossible = false;
    //     // take
    //     if( target - nums[i] >=0) ispossible |= f(i + 1, target - nums[i], nums);
    //     //not take
    //     ispossible |= f(i + 1, target, nums);

    //     return ispossible;
    // }
}