class Solution {
    public int countDigitOccurrences(int[] nums, int digit) {
        int count=0;
        for(int i=0;i<nums.length;i++){
            int n = nums[i];
            while(n >0){
                int rem = n%10;
                if(rem==digit) count++;
                n/=10;
            }
        }
        return count;
    }
}