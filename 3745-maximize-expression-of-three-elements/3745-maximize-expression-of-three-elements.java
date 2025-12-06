class Solution {
    public int maximizeExpressionOfThree(int[] nums) {
        int n =Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
             for(int k=j+1;k<nums.length;k++){
            if(nums[i]+nums[j]-nums[k] > n) n =nums[i]+nums[j]-nums[k] ;
            if(nums[k]+nums[j]-nums[i] > n) n =nums[k]+nums[j]-nums[i] ;
            if(nums[i]+nums[k]-nums[j] > n) n =nums[i]+nums[k]-nums[j] ;
        }
        } 
        }
        return n;
    }
}