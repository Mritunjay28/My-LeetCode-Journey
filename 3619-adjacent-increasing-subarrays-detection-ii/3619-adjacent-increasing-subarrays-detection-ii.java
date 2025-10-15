class Solution {
    public int maxIncreasingSubarrays(List<Integer> nums) {
        int s=0,e=nums.size()/2;
        int ans=0;
        while(s<=e){
            int mid = s+(e-s)/2;
            if(hasIncreasingSubarrays(nums, mid)){
                ans=mid;
                s=mid+1;
            }
            else e=mid-1;
        }
        return ans;

    }

    private boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        int n = nums.size();
        if (k == 0) return true;
        int[] inc = new int[n];
        inc[0] = 1;
        for (int i = 1; i < n; i++) {
            if (nums.get(i) > nums.get(i - 1)) inc[i] = inc[i - 1] + 1;
            else inc[i] = 1;
        }

        for (int i = k - 1; i + k < n; i++) {
            if (inc[i] >= k && inc[i + k] >= k) return true;
        }
        return false;
    }

}