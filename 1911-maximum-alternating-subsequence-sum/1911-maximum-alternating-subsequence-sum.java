class Solution {
    public long maxAlternatingSum(int[] nums) {
        // return  f(nums,0,true);
        int n=nums.length;

        long[][] dp = new long[n+1][2]; // 0->true,1->false
        // base case
        dp[n][0]=0;
        dp[n][1]=0;

        // traversal depend on future so for from backward
        for(int i=n-1;i>=0;i--){
            for(int j=0;j<2;j++){
                //take
                long val = dp[i+1][1-j];
                long take = 0;
                if(j==0){
                    take =val+nums[i];
                }
                else take = val-nums[i];

                //mot take 
                long nottake=dp[i+1][j];

                dp[i][j] = Math.max(take,nottake);
            }
        }

        return Math.max(dp[0][0],dp[0][1]);
    }

    // public long f(int[] nums,int i,boolean isEven){
    //     if(i==nums.length){
    //         return 0L;
    //     }

    //    // take 
    //    long val = f(nums,i+1,!isEven);
    //    long take=0L;
    //    if(isEven) take = nums[i]+val;
    //    else take = val-nums[i];

    //    // not take so val
    //     val = f(nums,i+1,isEven);

    //    return Math.max(take,val);
    // }
}
/*
Given arr find subsequence with max alternating sum 
first thought generate all subsequence then check for each - to generate all subsequence will require 
take-not take  can be done with backtracking or dp

now for backtracking it's 2^(10^5) so no but brute force done 

now how to convert to dp ???

state : 
base case 
tansition 
answer location 

*/