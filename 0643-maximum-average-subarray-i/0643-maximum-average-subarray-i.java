class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double max = -1000000011;
        int s =0,e=0;
        int sum=0;
        while(e<nums.length){
            sum+=nums[e];
            while(e-s+1 >k){
                sum-=nums[s++];
            }
            if(e-s+1==k) max=Math.max((double)max,(double)sum/k) ;
            e++;
        }
        return max;
    }
}