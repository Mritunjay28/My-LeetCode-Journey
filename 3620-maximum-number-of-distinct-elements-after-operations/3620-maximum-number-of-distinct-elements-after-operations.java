class Solution {
    public int maxDistinctElements(int[] nums, int k) {
        Arrays.sort(nums);
       int count=0;
       int last = -10000000;
       for(int i=0;i<nums.length;i++){
        int low=nums[i]-k;
        int high = nums[i]+k;

        if(high<=last) continue;

        int pick = Math.max(low,last+1);
        last=pick;
        count++;
       }
       return count;
    }
}