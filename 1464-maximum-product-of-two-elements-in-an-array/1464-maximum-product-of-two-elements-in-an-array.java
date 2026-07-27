class Solution {
    public int maxProduct(int[] nums) {
        int max=Math.max(nums[0],nums[1]);
        int secondmax=Math.min(nums[0],nums[1]);
        for(int i=2;i<nums.length;i++){
            if(nums[i]>max){
                secondmax=max;
                max=nums[i];
            }
            else  if (nums[i]>secondmax) secondmax = nums[i];
        }

        return (max-1)*(secondmax-1);
    }
}