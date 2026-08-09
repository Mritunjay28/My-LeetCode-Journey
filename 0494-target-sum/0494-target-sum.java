class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return f(0,target,nums);
    }

    public int f(int i, int target,int[] nums){
        if(i==nums.length && target==0) return 1;
        if(i==nums.length) return 0;

        int ways=0;
        // take +ve
        ways+= f(i+1,target-nums[i],nums);
        // not take -ve
        ways+= f(i+1,target+nums[i],nums);

        return ways;
    }
}