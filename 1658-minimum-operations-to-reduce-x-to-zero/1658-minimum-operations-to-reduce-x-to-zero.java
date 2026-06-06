class Solution {
    public int minOperations(int[] nums, int x) {
        int sum=0;
        for(int a : nums) sum+=a;
        int target = sum-x;
        if(target<0) return -1;
        int l =0,r=0;
        int ans =Integer.MIN_VALUE;
        sum=0;
        while(r<nums.length){
            sum+=nums[r];

            while(sum>target){
                sum-=nums[l];
                l++;
            }

            if(sum==target) ans =Math.max(ans,r-l+1);
            r++;
        }

        if(ans == Integer.MIN_VALUE) return -1;

        return nums.length-ans;
    }
}