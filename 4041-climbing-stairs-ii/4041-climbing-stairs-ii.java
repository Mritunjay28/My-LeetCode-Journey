class Solution {
    public int climbStairs(int n, int[] cost) {
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = cost[0] +1;
        if(n<2) return dp[1];
        int for0 = dp[0] + cost[1]+4;
        int for1 = dp[1] + cost[1]+1;
        dp[2] = Math.min(for0,for1);
        if(n<3) return dp[2];
        for(int i=3;i<n+1;i++){
            int from0 = dp[i-3] + cost[i-1] +9;  // i-3 i-2 i-1 i
            int from1 = dp[i-2] + cost[i-1] +4;  // i-3 i-2 i-1 i
            int from2 = dp[i-1] + cost[i-1] +1;
            dp[i]= Math.min(from0,Math.min(from1,from2));  // i-3 i-2 i-1 i
        }   

        return dp[n];
    }
}
// dp as want min and current depend previous result
// at each step try to find previous min 
// at each step want to know at which i are and check if i>2 then chen check which prev 3 + curr value give least then update it  