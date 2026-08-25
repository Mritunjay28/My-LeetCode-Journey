class Solution {
    public int missingMultiple(int[] nums, int k) {
        Arrays.sort(nums);
        int count=1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==count*k){
                count++;
            }
        }
        return count*k;
    }
}