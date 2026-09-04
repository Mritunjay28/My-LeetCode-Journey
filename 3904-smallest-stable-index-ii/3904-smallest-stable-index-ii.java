class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        int[] max = new int[n];
        int[] min = new int[n];

        int currmax = nums[0];
        for(int i=0;i<n;i++) {
            currmax=Math.max(currmax,nums[i]);
            max[i]=currmax;
        }

        int currmin = nums[n-1];
        for(int i=n-1;i>=0;i--) {
            currmin=Math.min(currmin,nums[i]);
            min[i]=currmin;
        }

        for(int i=0;i<n;i++){
            int score = max[i]-min[i];
            if(score <= k) return i;
        }

        return -1;
    }
}