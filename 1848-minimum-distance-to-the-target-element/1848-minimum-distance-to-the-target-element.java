class Solution {
    public int getMinDistance(int[] nums, int target, int start) {
        int val =(int)1e9;
        for(int i=0;i<nums.length;i++) {
            if(nums[i]==target) {
                val = Math.min(val,Math.abs(i-start));
                if(val==0) break;
            }
        }
        return val;
    }
}