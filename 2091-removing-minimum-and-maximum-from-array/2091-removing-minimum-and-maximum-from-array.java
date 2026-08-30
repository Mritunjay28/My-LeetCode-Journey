class Solution {
    public int minimumDeletions(int[] nums) {
        int min=0;
        int max=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]<nums[min]){
                min =i;
            }
            if(nums[i]>nums[max]){
                max =i;
            }
        }


        // all from left
        int count1= Math.max(max-0+1,min-0+1);

        // all from right 
        int count2 = Math.max(nums.length-max,nums.length-min);

        // from each end

        int count3 = Math.min(max-0+1 + nums.length-min , min-0+1 + nums.length-max);


        return Math.min(count1,Math.min(count2,count3));

    }
}