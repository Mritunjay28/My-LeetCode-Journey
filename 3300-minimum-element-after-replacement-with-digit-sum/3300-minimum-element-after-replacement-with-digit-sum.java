class Solution {
    public int minElement(int[] nums) {
        int min = 100000;
        for(int i=0;i<nums.length;i++){
            int sum=0;
            int x = nums[i];
            while(x>0){
                int rem = x%10;
                sum+=rem;
                x/=10;
            }
            min=Math.min(min,sum);
        }
        return min;
    }
}