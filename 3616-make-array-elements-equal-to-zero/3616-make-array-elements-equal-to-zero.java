class Solution {
    public int countValidSelections(int[] nums) {
        int sum=0;
        for(int i=0;i<nums.length;i++) sum+=nums[i];

        int count=0,prevsum=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0 && prevsum==sum-prevsum) count+=2;
            else if(nums[i]==0 && ((prevsum+1==sum-prevsum) || (prevsum==sum-prevsum+1))) count++;
            prevsum+=nums[i];
        }
        return count;
    }
}