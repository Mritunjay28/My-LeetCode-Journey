class Solution {
    public int minimumCost(int[] nums) {
        int n =nums.length;

        int sum =nums[0];
        Arrays.sort(nums, 1, n);
        sum+=nums[1];
        sum+=nums[2];
        return sum;

    }
}
// 1 1000 1 0 10 1 15 