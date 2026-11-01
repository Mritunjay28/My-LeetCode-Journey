class Solution {
    public int minMoves(int[] nums) {
        boolean allsame=true;
        for(int i=1;i<nums.length;i++) if(nums[i]!=nums[i-1]) {
            allsame=false;
            break;
        }

        if(allsame) return 0;
        Arrays.sort(nums);
        int sum = 0;
        int prev = nums[0];
        for (int i = nums.length - 1; i > 0; i--) {
            int curr = nums[i] + sum;
            sum += (curr - prev);
            prev = curr;
        }
        return sum;
    }
}