class Solution {
    public int sortPermutation(int[] nums) {
     int n = nums.length;
        int result = -1;

        for (int i = 0; i < n; i++) {
            if (nums[i] != i) {
                if (result == -1) {
                    result = nums[i];
                } else {
                    result &= nums[i];
                }
            }
        }

        return (result == -1) ? 0 : result;
    }
}

// nums[i]&nums[j]==k k>=0
//  0,1,2,3     0,1,2,3
// [1,0,3,2] , [1,0,3,2]
// 