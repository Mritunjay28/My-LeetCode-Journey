class Solution {
    public int triangularSum(int[] nums) {
        for(int k=0;k<nums.length-1;k++){
            int prev=nums[0] ;
        for(int i=1;i<nums.length-k;i++){
            int curr= nums[i];
            nums[i-1]= (prev+curr)%10;
            prev=curr;
        }
        }

        return nums[0];
        
    }
}