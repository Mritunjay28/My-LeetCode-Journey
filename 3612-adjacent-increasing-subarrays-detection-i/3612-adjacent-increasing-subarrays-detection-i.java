class Solution {
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        boolean prev=false;
        for(int i = 0; i <= nums.size() - (2 * k); i++){
                boolean firstIsIncreasing = check(nums, k, i);
            if (firstIsIncreasing) {
                boolean secondIsIncreasing = check(nums, k, i + k);
                if (secondIsIncreasing) return true;
            }
        }
        return false;
    }

    private boolean check(List<Integer> nums, int k,int i){
        for(int j=i+1;j<i+k;j++){
             if (nums.get(j) <= nums.get(j - 1)) return false;
        }
        return true;
    }
}