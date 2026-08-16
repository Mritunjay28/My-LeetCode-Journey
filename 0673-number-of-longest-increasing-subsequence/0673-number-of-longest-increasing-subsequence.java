class Solution {
    public int findNumberOfLIS(int[] nums) {
        int max = 0;
        int count = 0;

        int[][] dp = new int[nums.length][2]; //dp[i][0] = max length of LIS , dp[i][1] = count of LIS
       
        for (int i = nums.length-1; i >=0; i--) {
           int curMax = 1;
            int curCount = 1;

            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] > nums[i]) {
                    int len = dp[j][0] + 1;
                    int c = dp[j][1];

                    if (len == curMax) {
                        curCount += c;
                    } else if (len > curMax) {
                        curMax = len;
                        curCount = c;
                    }
                }
            }

            dp[i][0] = curMax;
            dp[i][1] = curCount;

            if (curMax == max) {
                count += curCount;
            } else if (curMax > max) {
                max = curMax;
                count = curCount;
            }
        }
        
        return count;
    }

    public int[] f(int i, int[] nums) {
        int max = 1;
        int count = 1;

        for (int j = i + 1; j < nums.length; j++) {
            if (nums[j] > nums[i]) {
                int[] curr = f(j, nums);
                if (curr[0]+1 == max)
                    count += curr[1];
                else if (curr[0]+1 > max) {
                    max = curr[0]+1;
                    count = curr[1];
                }
            }
        }
        return new int[] { max, count };
    }
}