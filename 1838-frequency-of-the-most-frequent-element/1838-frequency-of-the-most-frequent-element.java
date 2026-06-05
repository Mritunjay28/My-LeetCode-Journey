class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int maxfreq=1;
        int s=0,e=0;
        long sum=0;
        while(e<nums.length){
            sum+=nums[e];

            while(sum+k < (long)(e-s+1)*nums[e]){
                sum-=nums[s];
                s++;
            }

            maxfreq=Math.max(maxfreq,e-s+1);
            e++;
        }

        return maxfreq;
    }
}