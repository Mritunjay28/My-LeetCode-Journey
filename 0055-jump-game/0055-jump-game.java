class Solution {
    public boolean canJump(int[] nums) {
        int max =0;
        int n = nums.length;
        for(int i=0;i<n;i++){
            if(max<i) return false;
            int val = nums[i];
            if(i+val>max) max=i+val;
            if(max>=n-1) return true;
        }

        return false;
    }
}